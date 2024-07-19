package com.kh.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor @AllArgsConstructor @Data
public class Member {
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private char gender;
	private String address;
	private String phone;
	private char status;
	private Date enrollDate;
	

}
