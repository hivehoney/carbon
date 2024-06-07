package com.carbon.emissions.domain.excel;

import com.carbon.emissions.domain.EnergyConsumption;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class EnergyConsumptionDto {
    @ExcelColumn(headerName = "대상연도")
    private String yy;
    @ExcelColumn(headerName = "주소")
    private String adres;
    @ExcelColumn(headerName = "법인명")
    private String corpNm;
    @ExcelColumn(headerName = "에너지 사용량")
    private Long engCnsm;
    @ExcelColumn(headerName = "에너지 사용량 단위")
    private String engUnit;
    @ExcelColumn(headerName = "매출액(원)")
    private Long tst;
    @ExcelColumn(headerName = "소관부처")
    private String dprtmChrg;
    @ExcelColumn(headerName = "지정구분")
    private String dsgnClsf;
    @ExcelColumn(headerName = "지정업종")
    private String dsgnInds;
    @ExcelColumn(headerName = "온실가스 배출량")
    private Long ghgEms;
    @ExcelColumn(headerName = "온실가스 배출량 단위")
    private String ghgUnit;
    @ExcelColumn(headerName = "검증수행기관")
    private String vrfctAgncy;

    @Builder
    public EnergyConsumptionDto(String adres, String corpNm, Long engCnsm, String engUnit,
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

    public static EnergyConsumptionDto of(EnergyConsumption val) {

        return EnergyConsumptionDto.builder()
                .yy(val.getYy())
                .corpNm(val.getCorpNm())
                .adres(val.getAdres())
                .dsgnInds(val.getDsgnInds())
                .tst(val.getTst())
                .vrfctAgncy(val.getVrfctAgncy())
                .engCnsm(val.getEngCnsm())
                .engUnit(val.getEngUnit())
                .ghgEms(val.getGhgEms())
                .ghgUnit(val.getGhgUnit())
                .dprtmChrg(val.getDprtmChrg())
                .dsgnClsf(val.getDsgnClsf())
                .build();
    }
}
