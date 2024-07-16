package com.kh.socket3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {
	
	Socket socket; //누가 보냈는지
	Scanner sc = new Scanner(System.in);
	
	// 센드쓰레드 생성시 소켓을 받는다
	public SendThread(Socket socket) {
		this.socket= socket;
	}
	
	public void run() {
		
		try {
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			
			while(true) {
				ps.println(sc.nextLine());
				ps.flush();
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	

}
