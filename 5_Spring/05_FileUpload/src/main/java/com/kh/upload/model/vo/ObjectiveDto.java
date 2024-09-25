package com.kh.upload.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectiveDto {
    private boolean first; // 첫 번째 목표 여부
    private int kills; // 처치 수
}