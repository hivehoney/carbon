package com.carbon.emissions.service;

import com.carbon.emissions.domain.EnergyConsumption;
import com.carbon.emissions.domain.GasEmissionScrap;

import java.util.HashMap;
import java.util.List;

public interface CarbonService {
    List<GasEmissionScrap> selectGasEmission(String year);
    List<GasEmissionScrap> selectSigunStatistics(String year);
    List<EnergyConsumption> selectCorpEmission(HashMap<String, Object> params);
    List<EnergyConsumption> selectCorpDsgnStatistics();
    List<EnergyConsumption> selectCorpStatistics(HashMap<String, Object> params);
    List<GasEmissionScrap> selectGgStatistics();
    List<GasEmissionScrap> selectYyStatistics();
}