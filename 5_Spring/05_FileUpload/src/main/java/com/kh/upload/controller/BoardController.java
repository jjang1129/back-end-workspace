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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;
import com.kh.upload.service.boardService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {

	@Autowired
	private boardService service;
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("컨트롤러까지옴 upload!");
		System.out.println("파일 이름 : "+ file.getOriginalFilename()); //file 자체가 null 출력시 form에서 누락된게 있음 
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());
		 
		fileUpload(file);
	
		return "redirect:/";
	}
	
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		
		
	
				
				
				
				for(int i=0; i<files.size(); i++) {
				
					
					fileUpload(files.get(i));
					
				}
				
				
		
		
		
		return "redirect:/";
		
	}
	
	public String fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		
		UUID uuid= UUID.randomUUID();
		
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
			
		File copyFile = new File("D:\\upload\\" + fileName);  
		
		file.transferTo(copyFile); 
		
	
		
		
		
		
		return fileName;
		
		
	}
	
	@GetMapping("/list")
	public String list(Model model , Paging paging) {
		
		List<Board> list = service.list(paging);
		
		for( Board b : list) {
			LocalDateTime date = b.getDate();
			Date formatDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
			b.setFormatDate(formatDate);
		}
		
	
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(paging.getPage(), service.total()));
		
		
		return "list";
	}
	
	@GetMapping("/write")
	public String write() {
		
		return "write";
	}
	
	@PostMapping("/write")
	public String write(Board board) throws IllegalStateException, IOException {
		//1 . 파일 업로드 처리 
		//2. 해당 파일 URL과 함께 title, content DB에 저장 
	    
	    System.out.println(board.getFile().getOriginalFilename());
		System.out.println(!board.getFile().getOriginalFilename().equals(""));
	    if( !board.getFile().getOriginalFilename().equals("")) {
		
	       UUID uuid= UUID.randomUUID();
		
		String fileName = uuid.toString() + "_" + board.getFile().getOriginalFilename();
			
		File copyFile = new File("\\\\192.168.10.51\\damoim\\sungil\\" + fileName);  
			
	
		
		
         board.getFile().transferTo(copyFile); 	
		
	     board.setUrl("http://192.168.10.51:8081/sungil/" + fileName);
	      
		}	
	    
	    System.out.println(board.getUrl());
	    
		service.upload1(board);

		
		return "redirect:/one?no=" + board.getNo();
	}
	
	
	
	@GetMapping("/one")
	public String page(int no, Model model) {
		System.out.println("하나씩 출력!");
		model.addAttribute("no", service.one(no));
		
		return "one";
	}
	
	@GetMapping("/update")
    public String update(int no, Model model) {
		
		System.out.println(no);
		model.addAttribute("no1", service.one(no));
		
		return "/update";
	}
	
	@PostMapping("/update")
	public String update(Board board) throws IllegalStateException, IOException {
		  System.out.println("업데이트 보드 " + board);
		  
		  
                      // 수정전 해당 보드의 url 
			 String url = service.one(board.getNo()).getUrl();
			 // 수정전 해당 보드의 url이 존재 할 경우 삭제 
		if(url != null) {	 
			 System.out.println("url 후 ");
			 	 
			   String newPath = "\\\\192.168.10.51\\damoim\\sungil\\";
		        
		        // URL에서 파일 이름 부분 추출
		        String fileName = url.substring(url.lastIndexOf('/') + 1);
		        
		        System.out.println("fileNmaㄷ 후 ");
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
			  UUID uuid= UUID.randomUUID();
			  
			  String fileName2 = uuid.toString() + "_" +
			  board.getFile().getOriginalFilename();
			  
			  
			  
			  File copyFile2 = new File("\\\\192.168.10.51\\damoim\\sungil\\" + fileName2);
			  
			  board.getFile().transferTo(copyFile2);
			  
		 
			  
			  board.setUrl("http://192.168.10.51:8081/sungil/" + fileName2);
			  
		}  
			  
			  service.update(board);
			 
	   
	   return "redirect:/list";
		
		
	}
	
	@GetMapping("/delete")
	public String remove(int no) {
		
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
			 
			 
		
		return "redirect:/list";
	}
	
}
