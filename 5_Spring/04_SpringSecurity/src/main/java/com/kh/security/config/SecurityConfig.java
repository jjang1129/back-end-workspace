package com.kh.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration   
@EnableWebSecurity    // config 지정 
// 기본적으로 씨큐리티는 클라이언트의 요청을 막는다 
// 에러는 throw
public class SecurityConfig {
     // 특정 http 요청에 대한 웹 기반 보안 구성. 인증/인가 및 로그아웃 설정       
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		return http
				.csrf(csrf->csrf.disable())    // post일때 csrf를 차단시켜야 가능
				.authorizeHttpRequests(authorize ->
				 authorize		                                               // .requestMatchers("/register").authenticated()  => 레지스터에는 인증된 사람만 올수있어 
				         .anyRequest().permitAll()                    //   그외에는 authorize.anyRequest().permitAll()    전체 허용 열쇠없어도 ok 
				  )							
				.build();
	}
}
