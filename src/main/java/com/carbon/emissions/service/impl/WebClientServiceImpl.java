package com.carbon.emissions.service.impl;

import com.carbon.emissions.service.WebClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@RequiredArgsConstructor
public class WebClientServiceImpl implements WebClientService {

    private final WebClient webClient;

    /**
     * 사용자 정보를 기반으로 스크랩 데이터를 가져옵니다.
     *
     * @param profile 가져올 데이터를 스크랩할 프로필 정보
     * @return 스크랩된 데이터를 담은 응답 객체
     */
    public List<Map<String, Object>> getScrapData() throws JsonProcessingException {

        String response = webClient.post()
//                .uri("https://openapi.gg.go.kr/GGSIGUNGREENGASEMSTM?Type=json")
                .uri("https://openapi.gg.go.kr/GGSIGUNGREENGASEMSTM?Type=json&KEY=0451acb05727406da82e8ef6518b7aae")
                .contentType(MediaType.TEXT_HTML)
                .retrieve()
                .bodyToMono(String.class).block();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> rootMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {});

        // 최상위 키를 동적으로 탐색
        List<Map<String, Object>> topLevelList = (List<Map<String, Object>>) rootMap.values().iterator().next();
        List<Map<String, Object>> rowList = (List<Map<String, Object>>) topLevelList.get(1).get("row");

        return rowList;
    }

    /**
     * 사용자 정보를 기반으로 스크랩 데이터를 가져옵니다.
     *
     * @param profile 가져올 데이터를 스크랩할 프로필 정보
     * @return 스크랩된 데이터를 담은 응답 객체
     */
    public List<Map<String, Object>> getScrapData2() throws JsonProcessingException {

//        String response = webClient.post()
//                .uri("https://www.bigdata-environment.kr/user/openapi/api.call.do?apiKey=0F7B37892E4847998C64C911DD138096&display=100&start=72")
//                .contentType(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(String.class).block();

        List<String> responses = new ArrayList<>();
        for (int start = 28; start <= 73; start++) {
            int finalStart = start;
            String response = webClient.post()
                    .uri(uriBuilder -> uriBuilder
                            .scheme("https")
                            .host("www.bigdata-environment.kr")
                            .path("/user/openapi/api.call.do")
                            .queryParam("apiKey", "0F7B37892E4847998C64C911DD138096")
                            .queryParam("display", 100)
                            .queryParam("start", finalStart)
                            .build())
                    .contentType(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            responses.add(response);
        }

        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Object> rootMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {});

        // 최상위 키를 동적으로 탐색
//        List<Map<String, Object>> data = (List<Map<String, Object>>) rootMap.get("data");
//
//        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> combinedData = new ArrayList<>();

        for (String response : responses) {
            Map<String, Object> rootMap = objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {});
            List<Map<String, Object>> data = (List<Map<String, Object>>) rootMap.get("data");
            if (data != null) {
                combinedData.addAll(data);
            }
        }
        return combinedData;
    }
}
