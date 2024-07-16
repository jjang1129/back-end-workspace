package com.kh.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattClient {
	
	
	/*
	 *  키보드로 입력받은 데이터를 읽어서 서버로 보낸다 
	 *  다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔창에 출력한다
	 *  
	 *  클라이언트 측 로직 
	 *  1. 소켓 생성 
	 *  2. 스트림 
	 * 
	 * */
	

	public static void main(String[] args) {
		

		  try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			
			// 1. 소켓 생성  - IP 주소 , 포트번호
			Socket s = new Socket(ip,610);
			System.out.println("Client1 Socket Creating..");
			
			//2. 스트림 생성 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 입력한 텍스트를 읽는 행위? 
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true); // 입력받은 값을 한줄씩 소켓의 아웃풋으로 넘김
			System.out.println("Client1 Stream Creating..");
			
			
			// 다시 서버가 보낸 메시지를 받아서 자신의 콘솔창에 출력
		   BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
		   
			
		
			while(true) {
				String line = br.readLine();
				pw.println(line);
				
				String serverMsg= br2.readLine();
				System.out.println("내가 보낸 메시지 : "+ serverMsg);
			} // 한줄씩 집어넣음 
			
		} catch (IOException e) {
			
			System.out.println("서버와의 연결에 실패했습니다..");
		}

		
              
	}

}
