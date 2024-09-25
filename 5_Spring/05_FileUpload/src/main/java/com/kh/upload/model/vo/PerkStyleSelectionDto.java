package com.kh.upload.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerkStyleSelectionDto {
    private int perk; // 특성
    private int var1; // 변수 1
    private int var2; // 변수 2
    private int var3; // 변수 3
}