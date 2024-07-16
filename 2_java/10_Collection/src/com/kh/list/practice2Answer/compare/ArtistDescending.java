package com.kh.list.practice2Answer.compare;

import java.util.Comparator;

import com.kh.list.practice2Answer.model.Music;

public class ArtistDescending implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		
		return  o2.getArtist().compareTo(o1.getArtist());
	}

}
