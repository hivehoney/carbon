--경기도 시군별 온실가스 배출량 정보
CREATE TABLE IF NOT EXISTS `GAS_EMISSION` (
    yy VARCHAR(4) NOT NULL,                -- 년도
    sign_nm VARCHAR(50) NOT NULL,          -- 시군명
    gas_enisn_amnt INT,                    -- 온실가스배출량(tonCO2-eq)
    gas_reduct_amnt INT,                   -- 온실가스감축량(tonCO2-eq)
    crbn_reduct_amnt INT,                  -- 탄소포인트감축량(tonCO2-eq)
    reduct_biz_reduct_amnt INT,            -- 외부감축사업감축량(tonCO2-eq)
    gas_reduct_rt DECIMAL(10, 2),          -- 온실가스감축률(%)
    std_emisn_amnt INT,                    -- 기준배출량(tonCO2-eq)
    PRIMARY KEY (yy, sign_nm)  -- 중복을 방지하기 위해 UNIQUE 제약조건을 설정합니다.
);

--사업장별 온실가스 배출량∙에너지 사용량 정보
CREATE TABLE IF NOT EXISTS ENERGY_CONSUMPTION (
    yy VARCHAR(4) NOT NULL,           -- 대상연도
    corp_nm VARCHAR(50) NOT NULL,     -- 법인명
    adres VARCHAR(100),               -- 주소
    dsgn_inds VARCHAR(20),            -- 지정업종
    tst BIGINT,                          -- 매출액(원)
    vrfct_agncy VARCHAR(50),          -- 검증수행기관
    eng_cnsm BIGINT,                     -- 에너지 사용량
    eng_unit VARCHAR(10),             -- 에너지 사용량 단위
    ghg_ems BIGINT,                      -- 온실가스 배출량
    ghg_unit VARCHAR(10),             -- 온실가스 배출량 단위
    dprtm_chrg VARCHAR(20),           -- 소관부처
    dsgn_clsf VARCHAR(10),            -- 지정구분
    PRIMARY KEY (yy, corp_nm),         -- 대상연도와 법인명을 키로 설정
    PRIMARY KEY (yy, corp_nm),
    CONSTRAINT fk_energy_consumption_yy FOREIGN KEY (yy) REFERENCES GAS_EMISSION(yy)
);
