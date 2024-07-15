package com.kh.list.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.kh.list.practice2.controller.MusicController;
import com.kh.list.practice2.model.Music;
import com.kh.list.practice2.model.TitleSort;


public class Application {
	
	Music music =new Music();
	
	ArrayList<Music> list = new ArrayList<Music>();
	ArrayList<Music> list2 = new ArrayList<Music>();
	ArrayList<Music> list3 = new ArrayList<Music>();
	
	MusicController mc = new MusicController();

	 Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
           		
		Application app = new Application();
		app.mainMenu();
		
		
		
              
	}
	public void mainMenu() {
		boolean check = true;
	 while (check) {
		System.out.println("====메인 메뉴 ====");
		System.out.println("1.마지막 위치에 곡 추가");
		System.out.println("2.첫 위치에 곡 추가");
		System.out.println("3.전체 곡 목록 출력");
		System.out.println("4.특정 곡 검색");
		System.out.println("5.특정 곡 삭제");
		System.out.println("6.특정 곡 수정");
		System.out.println("7.가수 명 내림차순 정렬");
		System.out.println("8.곡 명 오름차순 정렬");
		System.out.println("9.종료");
		System.out.print("메뉴번호 입력 : ");
		try {
			int number = Integer.parseInt(sc.nextLine());
			switch (number) {
			  case 1 : lastMusic();
			  break;
			  case 2 :firstMusic();
			  break;
			  case 3 : allMusic(); 
			  break;
			  case 4 : searchMusic();
				 
			  break;
			  case 5 : deleteMusic();
			  break;
			  case 6 : updateMusic();
			  break;
			  case 7 : nameDown();
			  break;
			  case 8 : mc.titleUp();
			  break;
			  case 9 : check =false;
			  System.out.println("프로그램을 종료합니다");
			  break;
			  default :
				  System.out.println("잘못입력하셨습니다 다시입력해주세요");
			}
		
			
		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다 다시입력해주세요 ");
		}
	
			  
	 }  
	  
		
	}
	
	public void firstMusic() {
		System.out.println("****첫번째 위치에 곡 추가****");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수명 : ");
		String name = sc.nextLine();
		 list.add(0,new Music(title,name));
		 list2.add(0,new Music(title,name));
		 list3.add(0,new Music(title,name));
		
		 System.out.println("추가 성공 !");
	}
	
	
	public void lastMusic() {
		System.out.println("****마지막 위치에 곡 추가****");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수명 : ");
		String name = sc.nextLine();
		 list.add(list.size(),new Music(title,name));
		 list2.add(list2.size(),new Music(title,name));
		 list3.add(list3.size(),new Music(title,name));
		 System.out.println("추가 성공 !");
		
	}
	public void searchMusic() {
		System.out.println("****특정 곡 검색****");
		System.out.print("검색할 곡 명 : ");
	String title = sc.nextLine();
		
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getTitle().contains(title)) {
				System.out.println(list.get(i)+"을 검색 했습니다.");
			}
		} 
		
		
	}
	
	public void deleteMusic() {
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				System.out.println(list.get(i)+"을 삭제 했습니다");
						list.remove(i);
			}else {
				System.out.println("삭제할 곡이 없습니다");
			}
		} 
		
		
		
	}
	public void updateMusic() {
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String title2 = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String name = sc.nextLine();
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				System.out.println(list.get(i)+"의 값이 변경되었습니다");
				list.remove(i);
				list.add(i,new Music(title2,name));			
				break;				
			} else {System.out.println("수정할 곡을 찾지 못했습니다.");
			        break;
			}
				
			
			
		} 
		
		
	}
	public void allMusic () {
		System.out.println("*****전체 곡 목록 출력 ******");
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public void nameDown() {          // 가수명 내림 차순 A,B,C = > C,B,A
		Collections.sort(list2);
		Collections.reverse(list2);
		for(int i = 0; i <list2.size(); i++) {
			System.out.println(list2.get(i));
		}
	}
//	public void titleUp() {          // 곡명 오름 차순  C,B,A = > A,B,C
//		Collections.sort(list3, new TitleSort());
//		for(int i = 0; i <list3.size(); i++) {
//			System.out.println(list3.get(i));
//		}
		
//	}

}
