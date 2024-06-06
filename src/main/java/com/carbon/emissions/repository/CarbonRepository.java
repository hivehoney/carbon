package com.carbon.emissions.repository;

import com.carbon.emissions.domain.EnergyConsumption;
import com.carbon.emissions.domain.GasEmissionScrap;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CarbonRepository {
    List<GasEmissionScrap> selectGasEmission(String year);
    List<EnergyConsumption> selectCorpEmission(HashMap<String, Object> params);
    List<EnergyConsumption> selectCorpStatistics(HashMap<String, Object> params);
    List<EnergyConsumption> selectCorpDsgnStatistics(String year);
    List<GasEmissionScrap> selectGgStatistics(String year);
    List<GasEmissionScrap> selectYyStatistics();

    void upsertGasEmission(List<GasEmissionScrap> gas);

    void upsertCorpEmission(List<EnergyConsumption> corp);
}
