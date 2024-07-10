package com.kh.list.practice2.model;

import java.util.ArrayList;



public class MusicList extends Music {
        
	

private ArrayList<Music> musicList = new ArrayList<Music>();

public MusicList() {
	super();
	// TODO Auto-generated constructor stub
}

public MusicList(String title, String name) {
	super(title, name);
	// TODO Auto-generated constructor stub
}






public ArrayList<Music> getMusicList() {
	return musicList;
}

public void setMusicList(ArrayList<Music> musicList) {
	this.musicList = musicList;
}

@Override
public String toString() {
	return "MusicList [musicList=" + musicList + "]";
}
   
    



}