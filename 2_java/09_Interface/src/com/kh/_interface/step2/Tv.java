package com.kh._interface.step2;

public class Tv implements RemoteControl {

	   private int volume;
	      
		@Override
		public void setVolume(int volume) {
			if (volume > RemoteControl.max_volume) {
				this.volume = RemoteControl.max_volume;
			} else if (volume < RemoteControl.min_volume) {
				this.volume = RemoteControl.min_volume;
			} else {
				this.volume = volume;
			}
			System.out.println("현재 Tv 볼륨 : " + this.volume);
		}

		@Override
		public void search(String url) {
			System.out.println(url + "을 검색합니다 .");
			
		}

		@Override
		public void turnOn() {
			System.out.println("TV를 켭니다. ");
			
		}

		@Override
		public void turnOff() {
			System.out.println("TV를 끕니다. ");
			
		}
		
		
}
