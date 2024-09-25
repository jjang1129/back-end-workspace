package com.kh.upload.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerkStyleDto {
    private String description; // 설명
    private List<PerkStyleSelectionDto> selections; // 선택 목록
    private int style; // 스타일
}