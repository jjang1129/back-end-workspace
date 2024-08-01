package com.kh.mybatis.model.dto;

import jakarta.annotation.Generated;
import lombok.Getter;
import lombok.Setter;

// DTO(Data Transfer object) : 데이터 전송 객체

@Getter @Setter
public class SearchDTO {
     private String keyword;
     private String select;
}
