package com.kh.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest {
	
	/*
	 * 바이트기반 스트림
	 * */
	 
	
	
	

	public static void main(String[] args) {
		
		
		FileInputStream fis =null; 
		FileOutputStream fos = null;
		DataInputStream  dis = null;
		DataOutputStream  dos = null;
		
		
	
		
		
		
		
		try {
			//1 .먼저 기반 스트림 생성 
			//FileInputStream.FileOutputStream : 파일에 입출력을 하기 위해 
		 fis = new FileInputStream("src/bird.jpg");
		 fos = new FileOutputStream("src/bird_output3.jpg");
			
			
			
			
		  // 2. 기반 스트림을 이용해서 보조 스트림을 생성한다.
		  // DataInputTsteam, DataOutPutStream : 기본형타입으로 읽고 쓰는 보조 스트림 
			
			 dis = new DataInputStream(fis);
			 dos = new DataOutputStream(fos);
			
		 // 3. 데이터 찍어서 출력
			int data = 0;
			while((data = dis.read()) != -1){				
				dos.write(data);
				
			}  
				
		} catch (Exception e) {
						
		  e.printStackTrace();
		  
		 
		
	} finally {
		try {
			// 4. 자원반납 
			fis.close();
			fos.close();
			dis.close();
			dos.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		
		}
	
	}

		
		
}
}
