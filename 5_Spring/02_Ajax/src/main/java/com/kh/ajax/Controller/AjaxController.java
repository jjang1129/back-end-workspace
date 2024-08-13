package com.kh.ajax.Controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.service.MemberService;
import com.kh.model.Member;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AjaxController {

	   private int count = 0;
	   @Autowired
	  public MemberService service; 
	   
	 @ResponseBody
	 @GetMapping("/count")
	 public int count() {
		 
		 System.out.println("ajax로 요청이 들어옴!");
		 return ++count;
	 }
	 
	 @ResponseBody
	 @GetMapping("/encoding")
	 public String nick(String nickname) {
	
		 System.out.println("ajax2로 요청이 들어옴!");
		 return nickname;
		 
	 }
	 
	 @ResponseBody
	 @PostMapping("/check")
	 public boolean check(Member member) {
	
		 boolean check= true;
		 System.out.println("ajax3로 요청이 들어옴!");
		
		 
		System.out.println(service.idCheck(member));
		
		if(service.idCheck(member) != null ) {
		   check=false;
		   return check;
		} else {
			return check ;
		}
		
		 
	 }
	 
	 
	 
	 @ResponseBody
	 @PostMapping("/serial")
	 public Member signUp(Member member) {
	 	
		
		 
		 
	 
	 	
	 	if( service.idCheck(member) == null) {
	 		   
	 		service.signUp(member); 
	 		
	 		return /*"아이디 : "+ member.getId() + 
	 				" 비밀번호 :"+ member.getPassword()+
	 				" 이름 : "+member.getName() +" 가입 완료되었습니다";*/
	 				member;
	 		
	 	} else {
	 		
	 		return //"가입실패 ㅠㅠ ";
	 				null;
	 	}
	 	 
	 	 
	 	
	 }
	 
	 
}
