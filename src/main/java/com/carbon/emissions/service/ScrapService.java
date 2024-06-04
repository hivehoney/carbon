package com.carbon.emissions.service;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 외부 API를 통해 사용자의 데이터를 스크래핑 합니다.
 */
public interface ScrapService {

    /**
     * 사용자 데이터를 스크래핑 합니다.
     *
     * @param member   사용자 정보
     */
    void scrapData() throws JsonProcessingException;
    void scrapData2() throws JsonProcessingException;
}
