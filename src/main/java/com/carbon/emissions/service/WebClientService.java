package com.carbon.emissions.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface WebClientService {
    List<Map<String, Object>> getScrapData() throws JsonProcessingException;

    List<Map<String, Object>> getScrapData2() throws JsonProcessingException;
}
