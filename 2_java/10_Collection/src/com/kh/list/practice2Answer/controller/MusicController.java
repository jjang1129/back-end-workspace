package com.kh.list.practice2Answer.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.list.practice2Answer.compare.ArtistDescending;
import com.kh.list.practice2Answer.compare.SongAscending;
import com.kh.list.practice2Answer.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();

	// 1. 마지막 위치에 곡 추가
	public boolean addLastList(Music music) {
		
		
	if(!music.getArtist().equals("") && !music.getSong().equals("")) {
		list.add(music);
		return true;
	}
     return false;
	}

	// 2.첫 위치에 곡 추가
	public boolean addFirstList(Music music) {
		if(!music.getArtist().equals("") && !music.getSong().equals("")) {
		   list.add(0, music );
		   return true;
		} else {
			return false;
		} 
		
	}

	// 3.전체 곡 목록 출력
	public ArrayList<Music>  printAll() {
		
	return list;

	}

	// 4. 특정 곡 검색
	public Music searchMusic(String song) {
		for(Music music : list) {
			if(music.getSong().contains(song)) {
				return music;
			}
		}
         return null;
	}

	// 5. 특정 곡 삭제
	
	public Music removeMusic(String song) {
		
		for(Music music : list) {
			if(music.getSong().equals(song)) {
				
				return list.remove(list.indexOf(music));
				
			}
		}
         return null;
	}

	// 6. 특정 곡 수정
	public Music updateMusic(String search, Music update) {

		// search에 따라 정확하게 입력했을 경우만 수정되게끔!
      for(Music music : list) {
    	  if(music.getSong().equals(search)) {
    		 return list.set(list.indexOf(music),update );
    	  }
    	 
      }
	return null;
		
	}

	// 7. 가수명 내림 차순 정렬
	public ArrayList<Music> descArtist() {
		ArrayList<Music> cloneList=(ArrayList<Music>) list.clone();
		Collections.sort(cloneList,new ArtistDescending());
		return cloneList;

	}

	// 8. 곡명 오름차순 정렬
	public  ArrayList<Music> ascSong() {
		ArrayList<Music> cloneList=(ArrayList<Music>) list.clone();
		Collections.sort(cloneList, new SongAscending());
		
		return cloneList;


	}
	
}