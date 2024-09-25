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
public class MetadataDto {
	private String dataVersion; // 데이터 버전
	private String matchId; // 매치 ID
	private List<String> participants; // 참가자 ID 목록
}


