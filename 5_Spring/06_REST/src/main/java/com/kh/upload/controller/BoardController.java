package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.boardService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * REST(Representational State Transfer)
 * : API를 설계하는 아키텍처 
 * RESTful : REST 원칙을 준수하는 방식 
 * RESTful API (Application Programming Interface)
 *  : 서로 다른 애플리케이션들이 서로 데이터를 주고 받을 수 있게 하는 도구  
 * 
 * */
@RestController
@RequestMapping("/api/*") // http://localhost:8080/api/ 기본주소 
public class BoardController {

	@Autowired
	private boardService service;
	
	
	// CRUD : Create - Post , Read - Get, Update - Put , Delete - Delete
	
	
	// Create - Post 
	@PostMapping("/board")
	public ResponseEntity write(Board board) throws IllegalStateException, IOException {
		
		
		
	    
		if( !board.getFile().getOriginalFilename().equals("")) {			
			System.out.println("사용자가 파일을 업로드 하였습니다 ");
			  board.setUrl("http://192.168.10.51:8081/sungil/" + fileUpload(board.getFile()));	
			  System.out.println("사용자의 파일을 업로드 완료 하였습니다" + "경로 : " +  board.getUrl());
		}  else {
			System.out.println("사용자가 파일을 올리지 않았습니다");
		}
		service.upload1(board);

		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
	public String fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		
		UUID uuid= UUID.randomUUID();
		
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
			
		File copyFile = new File("\\\\192.168.10.51\\damoim\\sungil\\" + fileName);   // 파일 저장 경로 
		
		file.transferTo(copyFile); 
		
		
		return fileName;
		
		
	}
	
	// Read - Get : 전체 목록 보기
	
	@GetMapping("/board")
	public ResponseEntity list(Paging paging) {
		
		List<Board> list = service.list(paging);
		
		for( Board b : list) {
			LocalDateTime date = b.getDate();
			Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
			b.setFormatDate(formatDate);
		}
		
		
		//모델로 보내던것 body로 보내는데 1개의 객체만가능 여러개면 dTO로 포장해야함 
		return ResponseEntity.status(HttpStatus.OK).body(new BoardDTO(list, new Paging(paging.getPage(), service.total())));
	}
	
	// Read - Get : 1개 가져오기 
	@GetMapping("/board/{no}")
	public ResponseEntity page(@PathVariable int no) {
		System.out.println("하나씩 출력!");
	
		Board board =service.one(no);
		System.out.println(board);
		
		if(board != null) {
			return ResponseEntity.status(HttpStatus.OK).body(service.one(no));
		} else {
			String error = "아무것도 없어용 ";
			return ResponseEntity.status(HttpStatus.OK).body(error);
		}
		
	}
	
	
	
	
	
	
	@GetMapping("/update")
    public String update(int no, Model model) {
		
		System.out.println(no);
		model.addAttribute("no1", service.one(no));
		
		return "/update";
	}
	
	// Update - Put 방식으로 보낸다 
	@PutMapping("/board")
	public ResponseEntity update(Board board) throws IllegalStateException, IOException {
		  System.out.println("업데이트 보드 " + board);
		  
		  
                      // 수정전 해당 보드의 url 
			 String url = service.one(board.getNo()).getUrl();
			 // 수정전 해당 보드의 url이 존재 할 경우 삭제 
		if(url != null) {	 
		
			   String newPath = "\\\\192.168.10.51\\damoim\\sungil\\";
		        
		        // URL에서 파일 이름 부분 추출
		        String fileName = url.substring(url.lastIndexOf('/') + 1);
		        
		
		        // 새로운 전체 경로 생성
		        String newFilePath = newPath + fileName;
		        File copyFile = new File(newFilePath);
		       
				
				
				if (copyFile.exists()) {
					boolean deleted = copyFile.delete();
					if (deleted) {
						System.out.println("파일이 성공적으로 삭제되었습니다.");
					} else {
						System.out.println("파일 삭제 실패.");
					}
				} else {
					System.out.println("파일이 존재하지 않습니다.");
				}
				  
		  
		}
	
		 // 사용자가 수정시 업로드한 파일이 존재 할 경우 
		  
		if( !board.getFile().getOriginalFilename().equals("")) {			
			  board.setUrl("http://192.168.10.51:8081/sungil/" + fileUpload(board.getFile()));	  	  
		}  
			  
			  service.update(board);
			 
	   
	   return ResponseEntity.status(HttpStatus.OK).build();
		
		
	}
	
	// Delete - Delete
	@DeleteMapping("/board/{no}")
	public ResponseEntity remove(@PathVariable int no) {
		
		System.out.println("삭제??"); 
		
		 String url = service.one(no).getUrl();
		
		 if ( url != null ) {
		 
		   String newPath = "\\\\192.168.10.51\\damoim\\sungil\\";
	        // URL에서 파일 이름 부분 추출
	        String fileName = url.substring(url.lastIndexOf('/') + 1);
	        
	        // 새로운 전체 경로 생성
	        String newFilePath = newPath + fileName;
	        File copyFile = new File(newFilePath);
	       
			
			
			if (copyFile.exists()) {
				boolean deleted = copyFile.delete();
				if (deleted) {
					System.out.println("파일이 성공적으로 삭제되었습니다.");
				} else {
					System.out.println("파일 삭제 실패.");
				}
			} else {
				System.out.println("파일이 존재하지 않습니다.");
			}
			
		 }  
			  service.remove(no);
			 
			 
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	
}
