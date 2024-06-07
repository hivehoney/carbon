package com.carbon.emissions.domain.excel;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GasEmissionScrapDto {
    private String yy;
    private String signNm;
    private int gasEnisnAmnt;
    private int gasReductAmnt;
    private int crbnReductAmnt;
    private int reductBizReductAmnt;
    private BigDecimal gasReductRt;
    private int stdEmisnAmnt;
}
