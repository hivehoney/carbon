package com.carbon.emissions.service;

import com.carbon.emissions.domain.EnergyConsumption;
import com.carbon.emissions.domain.GasEmissionScrap;

import java.util.HashMap;
import java.util.List;

public interface CarbonService {
    List<GasEmissionScrap> selectGasEmission(String year);
    List<EnergyConsumption> selectCorpEmission(HashMap<String, Object> params);
    List<EnergyConsumption> selectCorpDsgnStatistics(String year);
    List<EnergyConsumption> selectCorpStatistics(HashMap<String, Object> params);
    List<GasEmissionScrap> selectGgStatistics(String year);
    List<GasEmissionScrap> selectYyStatistics();
}