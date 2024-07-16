package com.kh.list.practice2Answer.compare;

import java.util.Comparator;

import com.kh.list.practice2Answer.model.Music;

public class SongAscending implements Comparator<Music> {

	  


	@Override
	public int compare(Music o1, Music o2) {
		// TODO Auto-generated method stub
		return o1.getSong().compareTo(o2.getSong());
	}}
