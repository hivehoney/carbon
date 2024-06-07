package com.carbon.emissions.service.impl;

import com.carbon.emissions.domain.EnergyConsumption;
import com.carbon.emissions.domain.GasEmissionScrap;
import com.carbon.emissions.repository.CarbonRepository;
import com.carbon.emissions.service.CarbonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
    public List<GasEmissionScrap> selectSigunStatistics(String year){
        return carbonRepository.selectSigunStatistics(year);
    }

    @Transactional
    public void carbonDataClear() {
        carbonRepository.deleteGasEmission();
        carbonRepository.deleteCorpEmission();
    }

    @Transactional
    public List<EnergyConsumption> selectCorpEmission(HashMap<String, Object> params){
        return carbonRepository.selectCorpEmission(params);
    }

    @Transactional
    public List<EnergyConsumption> selectCorpStatistics(HashMap<String, Object> params){
        return carbonRepository.selectCorpStatistics(params);
    }

    @Transactional
    public List<EnergyConsumption> selectCorpDsgnStatistics(){
        return carbonRepository.selectCorpDsgnStatistics();
    }

    @Transactional
    public List<GasEmissionScrap> selectGgStatistics(){
        return carbonRepository.selectGgStatistics();
    }

    @Transactional
    public List<GasEmissionScrap> selectYyStatistics(){
        return carbonRepository.selectYyStatistics();
    }
}
