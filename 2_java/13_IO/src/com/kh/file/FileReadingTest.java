package com.kh.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 문자 기반 스트림 
 * - 문자 데이터를 읽고 출력할 때 사용 
 * - Reader, Writer : 문자 기반 입출력 스트림의 최상위 클래스
 * 
 * */

public class FileReadingTest {
	
	String fileName = "src/test.txt";
	String outfileName= "src/result.txt";

	public static void main(String[] args) {
		
		FileReadingTest f = new FileReadingTest();
	//	f.filesave();
	//	f.fileRead();
	//	f.fileRead2();
		f.fileReadTosave();
		

	}
	
	public void filesave() {
		// FileWriter를 사용해서 파일을 생성하고 데이터를 문자 단위로 저장 
	     
	   // try-with-resource 문을 통해서 사용한 리소스를 자동으로 close()
	   // catch() 안에 여러개가 있지만 가장 상위인 IOException 써도됨 
		try(FileWriter fw = new FileWriter(fileName,false)) {
			
		// true - 이어서 쓰기, false - 다 날리고 새로 씀  	
			fw.write("IO\n");
			fw.write("Thread\n");
			fw.write("Network\n");
			
			fw.flush(); // 강제로 자료 출력 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public void fileRead() {
		// FileReaer를 사용해서 파일에서 데이터를 문자 단위로 읽어온다 
		
		try(FileReader fr = new FileReader(fileName)) {
			
			int data = 0;
			while((data =fr.read())!= -1) {
				System.out.print((char)data);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 보조 스트림을 사용해서 파일에 있는 내용을 읽어서 한 줄 단위로 콘솔에 출력하는 로직 
	// 보조 스트림 BufferedReader : 버퍼(char[])에 데이터가 쌓이기를 기다렸다가 꽉 차게 될 시 한꺼번에 보냄 
	// close(자원반납) 해야 되는것들을 전부 try ()안에 넣어야하고 ;로 구분 
	public void fileRead2() {
		try(FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr)) {
			String line = "";
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
				
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 파일에 있는 내용 읽어서 또다른 파일로 출력하는 로직 
	public void fileReadTosave() {
		/*
		 * BufferedReader, BuffueredWriter 
		 *  : 입출력 효율을 높이기 위해 버퍼(char[])를 사용하는 보조 스트림 
		 *  --> 라인(line) 단위로 입출력이 편리하다 
		 * 	  읽어오고 읽은 내용을 새로운 파일로 넣고 그걸 다시  출력
		 * 
		 * PrintWriter : 프린터와 유사하게 출력하는 
		 * 				print(),println() 메서드를 가지고 있는 보조 스트림 
		 * 
		 * */
		try (
				
				BufferedReader br = new BufferedReader(new FileReader(fileName));	
				PrintWriter pw = new PrintWriter(new FileWriter(outfileName,false));
				//BufferedWriter bw = new BufferedWriter(new FileWriter(outfileName,true))
						) {
			
			
			
			
			
			
			String line = "";
			while((line=br.readLine()) != null) {
			//	bw.write(line);	
			//	bw.newLine(); // 라인 구분자 (개행문자)를 출력
				pw.println(line);
				
			}
		
				
			
				
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
