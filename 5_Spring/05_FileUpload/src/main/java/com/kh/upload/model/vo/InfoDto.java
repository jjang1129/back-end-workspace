package com.kh.upload.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class InfoDto {
	private String endOfGameResult;
	private List<TeamDto> teams;
}
