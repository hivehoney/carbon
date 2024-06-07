package com.carbon.emissions.domain.excel;

import com.carbon.emissions.domain.GasEmissionScrap;
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

    @Builder
    public GasEmissionScrapDto(String yy, String signNm, int gasEnisnAmnt, int gasReductAmnt, int crbnReductAmnt,
                            int reductBizReductAmnt, BigDecimal gasReductRt, int stdEmisnAmnt) {
        this.yy = yy;
        this.signNm = signNm;
        this.gasEnisnAmnt = gasEnisnAmnt;
        this.gasReductAmnt = gasReductAmnt;
        this.crbnReductAmnt = crbnReductAmnt;
        this.reductBizReductAmnt = reductBizReductAmnt;
        this.gasReductRt = gasReductRt;
        this.stdEmisnAmnt = stdEmisnAmnt;
    }

    public static GasEmissionScrapDto of(GasEmissionScrap var) {

        return GasEmissionScrapDto.builder()
                .yy(var.getYy())
                .signNm(var.getSignNm())
                .gasEnisnAmnt(var.getGasEnisnAmnt())
                .gasReductAmnt(var.getGasReductAmnt())
                .crbnReductAmnt(var.getCrbnReductAmnt())
                .reductBizReductAmnt(var.getReductBizReductAmnt())
                .gasReductRt(var.getGasReductRt())
                .stdEmisnAmnt(var.getStdEmisnAmnt())
                .build();
    }
}
