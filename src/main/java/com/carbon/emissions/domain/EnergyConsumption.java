package com.carbon.emissions.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class EnergyConsumption {
    private String yy;
    private String adres;
    private String corpNm;
    private Long engCnsm;
    private String engUnit;
    private Long tst;
    private String dprtmChrg;
    private String dsgnClsf;
    private String dsgnInds;
    private Long ghgEms;
    private String ghgUnit;
    private String vrfctAgncy;

    @Builder
    public EnergyConsumption(String adres, String corpNm, Long engCnsm, String engUnit,
                             Long tst, String yy, String dprtmChrg, String dsgnClsf, String dsgnInds,
                             Long ghgEms, String ghgUnit, String vrfctAgncy) {
        this.yy = yy;
        this.corpNm = corpNm;
        this.adres = adres;
        this.dsgnInds = dsgnInds;
        this.tst = tst;
        this.vrfctAgncy = vrfctAgncy;
        this.engCnsm = engCnsm;
        this.engUnit = engUnit;
        this.ghgEms = ghgEms;
        this.ghgUnit = ghgUnit;
        this.dprtmChrg = dprtmChrg;
        this.dsgnClsf = dsgnClsf;
    }

    public static EnergyConsumption of(String yy, String corpNm, String adres, String dsgnInds, Long tst,
                                       String vrfctAgncy, Long engCnsm, String engUnit, Long ghgEms,
                                       String ghgUnit, String dprtmChrg, String dsgnClsf) {

        return EnergyConsumption.builder()
                .yy(yy)
                .corpNm(corpNm)
                .adres(adres)
                .dsgnInds(dsgnInds)
                .tst(tst)
                .vrfctAgncy(vrfctAgncy)
                .engCnsm(engCnsm)
                .engUnit(engUnit)
                .ghgEms(ghgEms)
                .ghgUnit(ghgUnit)
                .dprtmChrg(dprtmChrg)
                .dsgnClsf(dsgnClsf)
                .build();
    }
}
