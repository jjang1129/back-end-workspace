package com.kh.upload.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class MatchResultDto {
	
	private String riotIdGameName;
	private int teamId;
	private boolean win;

}
