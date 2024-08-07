package com.kh.socket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattServer {

		//클라이언트가 보낸 메시지를 받아서 콘솔창에, 받은 메세지를 출력 
	
	public static void main(String[] args) {
		
		//1. ServerSocket 생성 - 포트번호 : 60000
		
		try {
			
			ServerSocket server = new ServerSocket(60001);
			System.out.println("Server Ready..");
			
			// 2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket을 하나 리턴합니다 
			Socket s= server.accept();
			System.out.println("Client Socket..");
			
			
			// 3. 소켓으로부터 스트림 리턴 
	BufferedReader	br	=new BufferedReader(new InputStreamReader(s.getInputStream()));
	String line = null;
	while((line = br.readLine())!=null) {
		System.out.println("client가 보낸 메시지 : "+line);
	}
		} catch (IOException e) {
			
			System.out.println("Client와의 연결이 끊어졌습니다..");
		}
		

	
		
		
	}

	
	
	
	
	
}
