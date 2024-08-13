package com.kh.security.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.kh.security.model.vo.Member;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service // 토큰 생성기는 서비스로 등록함
public class TokenProvider {

	
	private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512); // 시크릿 키 등록 
	
	public String create(Member member) {
		
		return Jwts.builder()
				.signWith(secretKey)  // 시크릿 키로 지정 
				.setClaims(Map.of(
				"id",member.getId(),
				"name",member.getName(),
				"role",member.getRole()
				))
				.setIssuedAt(new Date()) // 토큰 생성 날짜
				.setExpiration(Date.from(Instant.now().plus(1,ChronoUnit.DAYS))) // 토큰의 유효기간 지정 현재날짜에서 1일
				.compact();
		
		
		
		
	}
	
}
