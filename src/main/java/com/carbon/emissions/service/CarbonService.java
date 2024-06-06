package com.carbon.emissions.service;

import com.carbon.emissions.domain.EnergyConsumption;
import com.carbon.emissions.domain.GasEmissionScrap;
import com.carbon.emissions.domain.ProductVo;

import java.util.HashMap;
import java.util.List;

public interface CarbonService {
    List<GasEmissionScrap> selectGasEmission(String year);
    List<EnergyConsumption> selectCorpEmission(HashMap<String, Object> params);
    List<EnergyConsumption> selectCorpDsgnStatistics(String year);
    List<GasEmissionScrap> selectGgStatistics(String year);
}