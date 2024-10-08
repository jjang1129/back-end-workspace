package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration   
@EnableWebSecurity    // config 지정 
// 기본적으로 씨큐리티는 클라이언트의 요청을 막는다 
// 에러는 throw
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter; // config에 만들어 놓은 필터 와이어링 
     // 특정 http 요청에 대한 웹 기반 보안 구성. 인증/인가 및 로그아웃 설정       
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		return http
				.csrf(csrf->csrf.disable())    // post일때 csrf를 차단시켜야 가능
				.httpBasic(basic -> basic.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize ->
				 authorize		                                            // .requestMatchers("/register").authenticated()  => 레지스터에는 인증된 사람만 올수있어 
				       .requestMatchers("/member").authenticated() // /member 요청에는 인증된 사람만 들어올수있다       
				       .requestMatchers("/admin").hasRole("ADMIN") // 권한이 ROLE_ADMIN인 경우만 접근이 가능
				         .anyRequest().permitAll()                    //   그외에는 authorize.anyRequest().permitAll()    전체 허용 열쇠없어도 ok 
				  )	
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) //필터 사용
				.build();
	}
}
