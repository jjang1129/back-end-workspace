package com.kh.upload.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerkStatsDto {
    private int defense; // 방어 특성
    private int flex; // 유연한 특성
    private int offense; // 공격 특성
}