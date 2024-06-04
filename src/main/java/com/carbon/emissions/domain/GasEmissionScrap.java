package com.carbon.emissions.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GasEmissionScrap {
    private String yy;
    private String signNm;
    private int gasEnisnAmnt;
    private int gasReductAmnt;
    private int crbnReductAmnt;
    private int reductBizReductAmnt;
    private BigDecimal gasReductRt;
    private int stdEmisnAmnt;

    @Builder
    public GasEmissionScrap(String yy, String signNm, int gasEnisnAmnt, int gasReductAmnt, int crbnReductAmnt,
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

    public static GasEmissionScrap of(String yy, String signNm, int gasEnisnAmnt, int gasReductAmnt, int crbnReductAmnt,
                                      int reductBizReductAmnt, BigDecimal gasReductRt, int stdEmisnAmnt) {

        return GasEmissionScrap.builder()
                .yy(yy)
                .signNm(signNm)
                .gasEnisnAmnt(gasEnisnAmnt)
                .gasReductAmnt(gasReductAmnt)
                .crbnReductAmnt(crbnReductAmnt)
                .reductBizReductAmnt(reductBizReductAmnt)
                .gasReductRt(gasReductRt)
                .stdEmisnAmnt(stdEmisnAmnt)
                .build();
    }
}
