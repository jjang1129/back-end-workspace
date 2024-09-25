package com.kh.upload.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private List<BanDto> bans; // 금지 챔피언 목록
    private ObjectivesDto objectives; // 목표
    private int teamId; // 팀 ID
    private boolean win; // 승리 여부
}