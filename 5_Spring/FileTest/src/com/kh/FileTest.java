package com.kh;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileTest {

	public static void main(String[] args) throws IOException {
		
		// 기존 파일 리스트 출력
		String directory = "\\\\192.168.10.51\\damoim\\profile\\";
		File dir = new File(directory);
		String[] files = dir.list();
		
		for(String file : files) {
			// 기존 파일 
			
			File f = new File(directory + file);
			
			// 새로 들어가야 하는 폴더 및 파일
			String path = "\\\\192.168.10.51\\damoim\\member\\";
			path += f.getName().substring(0, f.getName().lastIndexOf("."));
			File folder = new File(path);
			File newFile = new File(path + File.separator + f.getName());

			if(!folder.exists()) {
				folder.mkdir();
				Files.copy(f.toPath(), newFile.toPath());
				System.out.println(f.getName());
			}
		}

	}

}
