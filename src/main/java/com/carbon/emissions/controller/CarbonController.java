package com.carbon.emissions.controller;

import com.carbon.emissions.domain.EnergyConsumption;
import com.carbon.emissions.domain.GasEmissionScrap;
import com.carbon.emissions.service.CarbonService;
import com.carbon.emissions.service.ScrapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("api/carbon")
public class CarbonController {

    private final CarbonService carbonService;
    private final ScrapService scrapService;

    /**
     * 전체 리스트 조회
     * @return  전체 리스트
     */
    @ResponseBody
    @GetMapping("/emission/list")
    public Map<String, Object> getEmissionList(@RequestParam(name = "year") String year) throws Exception {
        List<GasEmissionScrap> gasEmissionList = carbonService.selectGasEmission(year);
        Map<String, Object> map = new HashMap<>();
        map.put("gasEmissionList", gasEmissionList);
        return map;
    }

    /**
     * 전체 리스트 조회
     * @return  전체 리스트
     */
    @ResponseBody
    @GetMapping(value = "/corp/list")
    public Map<String, Object> corpEmissionList(@RequestParam(name = "year") String year) throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("year", year);

        List<EnergyConsumption> corpEmissionList = carbonService.selectCorpEmission(params);
        Map<String, Object> map = new HashMap<>();
        map.put("corpEmissionList", corpEmissionList);
        return map;
    }

    /**
     * 전체 리스트 조회
     * @return  전체 리스트
     */
    @ResponseBody
    @GetMapping(value = "/statistics")
    public Map<String, Object> carbonStatistics(@RequestParam(name = "year") String year) throws Exception {
        List<EnergyConsumption> corpDsgnStatistics = carbonService.selectCorpDsgnStatistics(year);
        List<GasEmissionScrap> ggStatistics = carbonService.selectGgStatistics(year);
        Map<String, Object> map = new HashMap<>();
        map.put("corpDsgnStatistics", corpDsgnStatistics);
        map.put("ggStatistics", ggStatistics);
        return map;
    }

    /**
     * 전체 리스트 조회
     * @return  전체 리스트
     */
    @ResponseBody
    @GetMapping(value = "/sigun/dashboard")
    public Map<String, Object> carbonSigunDashboard(@RequestParam(name = "year") String year) throws Exception {
        List<GasEmissionScrap> ggStatistics = carbonService.selectGgStatistics(year);
        Map<String, Object> map = new HashMap<>();
        map.put("ggStatistics", ggStatistics);
        return map;
    }

    @ResponseBody
    @GetMapping(value = "/corp/dashboard")
    public Map<String, Object> carbonCorpDashboard(@RequestParam(name = "year") String year,
                                                   @RequestParam(name = "adres") String adres) throws Exception {

        HashMap<String, Object> params = new HashMap<>();
        params.put("adres", adres);
        params.put("year", year);

        List<EnergyConsumption> corpEmissionList = carbonService.selectCorpEmission(params);

        Map<String, Object> map = new HashMap<>();
        map.put("corpEmissionList", corpEmissionList);
        return map;
    }

    @ResponseBody
    @GetMapping(value = "/corp/statistics")
    public Map<String, Object> carbonCorpStatistics(@RequestParam(name = "year") String year,
                                                   @RequestParam(name = "dsgnInds") String dsgnInds) throws Exception {

        HashMap<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("dsgnInds", dsgnInds);

        List<EnergyConsumption> corpEmissionList = carbonService.selectCorpEmission(params);

        Map<String, Object> map = new HashMap<>();
        map.put("corpEmissionList", corpEmissionList);

        return map;
    }

    /*@PostMapping(value = "/excel")
    public void excelExport(HttpServletResponse res) {
        Excel export = new Excel<>(req, GasEmissionScrap.class);
        export.write(res, "엑셀데이터");
    }*/

    /**
     * 사용자 데이터 스크래핑을 수행합니다.
     *
     * @param userAccount 사용자 계정 정보
     * @return HTTP 응답 상태 코드 {@code 200 (OK)}
     */
    @ResponseBody
    @GetMapping(value = "/scrap")
    public HttpStatus scrapeUserData() {
        try {
            // 스크래핑 서비스를 통해 사용자 데이터 스크래핑 수행
            scrapService.scrapData();
            return HttpStatus.OK;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return HttpStatus.BAD_GATEWAY;
    }

    /**
     * 사용자 데이터 스크래핑을 수행합니다.
     *
     * @param userAccount 사용자 계정 정보
     * @return HTTP 응답 상태 코드 {@code 200 (OK)}
     */
    @ResponseBody
    @GetMapping(value = "/scrap2")
    public HttpStatus scrapeCorpData() {
        try {
            // 스크래핑 서비스를 통해 사용자 데이터 스크래핑 수행
            scrapService.scrapData2();
            return HttpStatus.OK;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return HttpStatus.BAD_GATEWAY;
    }
}
