package com.kh.upload.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BanDto {
    private int championId; // 금지된 챔피언 ID
    private int pickTurn; // 픽 턴
}