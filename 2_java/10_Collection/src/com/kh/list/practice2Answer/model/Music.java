package com.kh.list.practice2Answer.model;

public class Music {
	
	
	private String artist;
	private String song;
	public Music(String artist, String song) {
		super();
		this.artist = artist;
		this.song = song;
	}
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	@Override
	public String toString() {
		return artist + "-"+song;
	}
	
	
	
	

}
