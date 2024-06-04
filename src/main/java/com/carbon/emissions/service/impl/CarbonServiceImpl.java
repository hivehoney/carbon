package com.carbon.emissions.service.impl;

import com.carbon.emissions.domain.EnergyConsumption;
import com.carbon.emissions.domain.GasEmissionScrap;
import com.carbon.emissions.repository.CarbonRepository;
import com.carbon.emissions.service.CarbonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarbonServiceImpl implements CarbonService {

    private final CarbonRepository carbonRepository;

    @Transactional
    public List<GasEmissionScrap> selectGasEmission(String year){
        return carbonRepository.selectGasEmission(year);
    }

    @Transactional
    public List<EnergyConsumption> selectCorpEmission(String year){
        return carbonRepository.selectCorpEmission(year);
    }

    @Transactional
    public List<EnergyConsumption> selectCorpDsgnStatistics(String year){
        return carbonRepository.selectCorpDsgnStatistics(year);
    }

    @Transactional
    public List<GasEmissionScrap> selectGgStatistics(String year){
        return carbonRepository.selectGgStatistics(year);
    }
}
