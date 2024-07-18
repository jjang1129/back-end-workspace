package com.kh.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private char gender;
	private String address;
	private String phone;
	private Date enrollDate;

}

