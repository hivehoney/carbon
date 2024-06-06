package com.carbon.emissions.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("page")
public class PageController {

    @GetMapping("/carbon/dashboard")
    public String getDashBoard(Model model) {
        model.addAttribute("title", "경기도 온실가스 배출량");
        return "index";
    }

    @GetMapping("/carbon/emission/gg")
    public String getGasEmissionsGG(Model model) {
        model.addAttribute("title", "경기도 온실가스 배출 세부내용");
        return "carbonEmission";
    }

    @GetMapping("/carbon/emission/corp")
    public String getGasEmissionsCorp(Model model) {
        model.addAttribute("title", "사업장 온실가스 배출 세부내용");
        return "corpEmission";
    }

    @GetMapping("/carbon/statistics")
    public String getStatistics(Model model) {
        model.addAttribute("title", "통계");
        return "statistics";
    }
}
