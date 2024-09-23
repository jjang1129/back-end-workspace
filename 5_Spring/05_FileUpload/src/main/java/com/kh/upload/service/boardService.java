package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

import mapper.BoardMapper;

@Service
public class boardService {
	
	
	@Autowired
	private BoardMapper mapper;
	
	
	public void upload1(Board board) {
		
		mapper.upload1(board);
	}
	
	public List<Board> list(Paging paging){
		
		/*  
		 *  limit가 10인 경우 
		 *  page = 1 - > offset = 0 
		 *  page = 2 - > offset = 10 
		 *  page = 3 - > offset = 20 ....
		 * 
		 * 
		 * */
		paging.setOffset(paging.getLimit() * (paging.getPage()-1));
			
		return mapper.list(paging);
	}
	
	public Board one(int no){
		
		return mapper.one(no);
	}

	public void update(Board board) {
		mapper.update(board);
	}
	
	public void remove(int no) {
		mapper.remove(no);
	}
	
	public int total() {
		
		return mapper.total();
	}
}
