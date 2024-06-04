package com.carbon.emissions.service;

import com.carbon.emissions.domain.EnergyConsumption;
import com.carbon.emissions.domain.GasEmissionScrap;
import com.carbon.emissions.domain.ProductVo;

import java.util.List;

public interface CarbonService {
    List<GasEmissionScrap> selectGasEmission(String year);
    List<EnergyConsumption> selectCorpEmission(String year);
    List<EnergyConsumption> selectCorpDsgnStatistics(String year);
    List<GasEmissionScrap> selectGgStatistics(String year);
}