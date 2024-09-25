package com.kh.upload.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObjectivesDto {
    private ObjectiveDto baron; // 바론 목표
    private ObjectiveDto champion; // 챔피언 목표
    private ObjectiveDto dragon; // 드래곤 목표
    private ObjectiveDto horde; // 호드 목표
    private ObjectiveDto inhibitor; // 억제기 목표
    private ObjectiveDto riftHerald; // 리프트 헤럴드 목표
    private ObjectiveDto tower; // 포탑 목표
}