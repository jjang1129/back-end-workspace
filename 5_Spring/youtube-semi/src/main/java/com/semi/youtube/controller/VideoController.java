package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.youtube.config.TokenProvider;
import com.semi.youtube.model.vo.Member;
import com.semi.youtube.model.vo.VideoLike;
import com.semi.youtube.service.VideoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class VideoController {
	
	@Autowired
	private TokenProvider Tp;
	
	@Autowired
	private VideoService video;
	
  


	 // 댓글 작성 
	  
     // 댓글 수정 
	
	 //댓글 삭제 
	 
	 // 좋아요
	

	@PostMapping("/like")
	public void like() {
		//HttpSession session = request.getSession();
	// 	Member member = (Member) session.getAttribute("vo");
	//	 Member member =Tp.validate(token);
	//	System.out.println(member);
	//	System.out.println(code);
	//	System.out.println(token);
	//	VideoLike data = VideoLike.builder()
	//			.id(member.getId())
	//			.videoCode(Integer.parseInt(code))
	//			.build();
		
		System.out.println("접속 !");
	//	video.like(data);		
		
	}
	
	
	
		
	 // 좋아요 취소 
	
	@ResponseBody
	@PostMapping("/unlike")
   public void unlike(int code) {
		video.unlike(code);
		
	}
	
	
	 // 구독 
	 
	 // 구독 취소 
	
	
	
	
	
}
