package com.jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Movie {

	@Id // primary key 명시 
	private int id;
	
	@Column // 컬럼 명시 
	private String title;
	
	@Column
	private String genre;
	
	@Column
	private String actor;
}
