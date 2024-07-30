package com.kh.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mapper") // MyBatis 매퍼 인터페이스 위치 패키지 // 패키지 자체를 mapper로 한다 ? 스캔 시작 위치
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}