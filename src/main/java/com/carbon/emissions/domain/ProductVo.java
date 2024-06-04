package com.carbon.emissions.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductVo {
    private Long id;
    private String name;
    private String description;
    private int status;

    @Builder
    public ProductVo(Long id, String name, String description, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }
}