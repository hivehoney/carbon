package com.carbon.emissions.service.impl;

import com.carbon.emissions.domain.EnergyConsumption;
import com.carbon.emissions.domain.GasEmissionScrap;
import com.carbon.emissions.domain.ProductVo;
import com.carbon.emissions.repository.CarbonRepository;
import com.carbon.emissions.service.CarbonService;
import com.carbon.emissions.service.ScrapService;
import com.carbon.emissions.service.WebClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScrapServiceImpl implements ScrapService {

    private final WebClientService webClientService;
    private final CarbonRepository carbonRepository;

    @Transactional
    public void scrapData() {
        try {
            List<Map<String, Object>> scrapData = webClientService.getScrapData();

            List<GasEmissionScrap> gas = scrapData.stream()
                    .map(this::mapToGasEmissionScrap)
                    .collect(Collectors.toList());

            carbonRepository.upsertGasEmission(gas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void scrapData2() {
        try {
            List<Map<String, Object>> scrapData1 = webClientService.getScrapData2();

            List<EnergyConsumption> corp = scrapData1.stream()
                    .map(this::mapToCorpEmissionScrap)
                    .collect(Collectors.toMap(
                            item -> item.getYy() + "-" + item.getCorpNm(),
                            item -> item,
                            (existing, replacement) -> replacement
                    ))
                    .values()
                    .stream()
                    .collect(Collectors.toList());

            carbonRepository.upsertCorpEmission(corp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private GasEmissionScrap mapToGasEmissionScrap(Map<String, Object> map) {
        String yy = (String) map.get("YY");
        String signNm = (String) map.get("SIGUN_NM");
        int gasEnisnAmnt = (Integer) map.get("GAS_EMISN_AMNT");
        int gasReductAmnt = (Integer) map.get("GAS_REDUCT_AMNT");
        int crbnReductAmnt = (Integer) map.get("CRBN_REDUCT_AMNT");
        int reductBizReductAmnt = (Integer) map.get("REDUCT_BIZ_REDUCT_AMNT");
        BigDecimal gasReductRt = BigDecimal.valueOf(((Number) map.get("GAS_REDUCT_RT")).doubleValue());
        int stdEmisnAmnt = (Integer) map.get("STD_EMISN_AMNT");

        return GasEmissionScrap.of(yy, signNm, gasEnisnAmnt, gasReductAmnt, crbnReductAmnt, reductBizReductAmnt, gasReductRt, stdEmisnAmnt);
    }

    /**
     * trgt_year: 대상연도
     * eng_unit: 에너지 사용량 단위
     * adres: 주소
     * corp_nm: 법인명
     * eng_cnsm: 에너지 사용량
     * tst: 매출액(원)
     * dprtm_chrg: 소관부처
     * dsgn_clsf: 지정구분
     * dsgn_inds: 지정업종
     * ghg_ems: 온실가스 배출량
     * ghg_unit: 온실가스 배출량 단위
     * vrfct_agncy: 검증수행기관
     */
    private EnergyConsumption mapToCorpEmissionScrap(Map<String, Object> map) {
        String yy = (String) map.get("trgt_year");
        String corpNm = (String) map.get("corp_nm");
        String adres = (String) map.get("adres");
        String dsgnInds = (String) map.get("dsgn_inds");
        Long tst = parseToLong((String) map.get("tst"));
        String vrfctAgncy = (String) map.get("vrfct_agncy");
        Long engCnsm = parseToLong((String) map.get("eng_cnsm"));
        String engUnit = (String) map.get("eng_unit");
        Long ghgEms = parseToLong((String) map.get("ghg_ems"));
        String ghgUnit = (String) map.get("ghg_unit");
        String dprtmChrg = (String) map.get("dprtm_chrg");
        String dsgnClsf = (String) map.get("dsgn_clsf");

        return EnergyConsumption.of(yy, corpNm, adres, dsgnInds, tst, vrfctAgncy
                                        , engCnsm, engUnit, ghgEms, ghgUnit, dprtmChrg, dsgnClsf);
    }

    private static Long parseToLong(String value) {
        try {
            return Long.parseLong(value.replaceAll(",", "").strip());
        } catch (NumberFormatException e) {
            return 0L; // 숫자가 아닌 경우 0으로 처리
        }
    }
}
