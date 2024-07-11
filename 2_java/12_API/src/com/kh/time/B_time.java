package com.kh.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
 * java.time 패키지 
 * - Date 와 Calendar의 단점을 개선한 새로운 클래스들을 제공 (JDK 1.8) 8버전 이후 부터 
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 클래스 포함 
 * - 날짜와 시간에 대한 다양한 메서드를 제공 
 * 
 * 
 * */

public class B_time {

	public void method1() {

		/*
		 * LocalDateTime - 날짜와 시간 정보를 모두 저장
		 * 
		 */

		LocalDateTime now = LocalDateTime.now();
		System.out.println("now : " + now);

		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2024, 7, 12, 17, 50, 0);
		System.out.println("when : " + when);

		// zonedDateTime : LocalDateTime + 시간대
		System.out.println("ZonedDateTime : " + ZonedDateTime.now());

		// 년,월,일,요일,시,분,초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonth()); // 영어로 7월 JULY
		System.out.println(now.getMonthValue() + "월"); // 그냥 7월
		System.out.println(now.getDayOfMonth() + "일"); // 월기준 며칠인지
		System.out.println(now.getDayOfYear() + "일"); // 365일 기준 며칠인지
		System.out.println(now.getDayOfWeek()); // 무슨요일 영어로
		System.out.println(now.getHour() + "시"); // 24시간 단위 시간
		System.out.println(now.getMinute() + "분"); // 분
		System.out.println(now.getSecond() + "초"); // 초

		System.out.println();

		// 날짜 조작
		LocalDateTime plusDays = now.plusDays(1).plusMonths(2).plusYears(1); // 1일 , 2달 후의 날짜 , 1년 후의 날짜
		System.out.println(plusDays);

		LocalDateTime minusDays = now.minusYears(1).minusMonths(1).minusDays(1); // 1년 1개월 1일 전의 날짜
		System.out.println(minusDays);

		LocalDateTime withDays = now.withYear(2025).withMonth(8).withDayOfMonth(10); // 2025년 8월 10일로 조작
		System.out.println("with : " + withDays);

		System.out.println("isAfter : " + now.isAfter(withDays)); // now가 withDays 보다 이후의 날짜인가? false

		System.out.println("isBefor : " + now.isBefore(withDays)); // now가 with days 보다 이전의 날짜인가? true

		// LocalDate : 날짜 정보를 저장
		LocalDate localDate = LocalDate.now();
		System.out.println("LocalDate : " + localDate);
		localDate = LocalDate.of(2024, 11, 13);
		System.out.println("LocalDate 2 : " + localDate);

		// LocalTime : 시간 정보만 저장

		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime : " + localTime);
		localTime = LocalTime.of(17, 49, 49);
		System.out.println("LocalTime2 : " + localTime);

	}
	/*
	 * Period와 Duration - 날짜와 시간 간격을 표현하기 위한 클래스 - Period : 두 날짜 간의 차이 - Duration :
	 * 시간의 차이
	 */

	public void method2() {

		LocalDate date1 = LocalDate.of(2024, 1, 1);
		LocalDate date2 = LocalDate.of(2025, 12, 31);

		Period pe = Period.between(date1, date2);
		System.out.println("pe : " + pe);
		System.out.println("years : " + pe.getYears());
		System.out.println("months : " + pe.getMonths());
		System.out.println("days : " + pe.getDays());

		System.out.println();

		System.out.println("years : " + pe.get(ChronoUnit.YEARS));
		System.out.println("months : " + pe.get(ChronoUnit.MONTHS));
		System.out.println("days : " + pe.get(ChronoUnit.DAYS));

		// duration 시간의 차이

		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(11, 23, 55);
		Duration du = Duration.between(time1, time2);
		System.out.println(du);

		System.out.println("hours : " + du.toHours());
		System.out.println("minutes : " + du.toMinutes());
		System.out.println("seconds : " + du.toSeconds());

		// 문자열을 LocalDate 객체로 파싱
		LocalDate date = LocalDate.parse("2024-11-13");
		System.out.println(date);

		// DateTimeFormatter
		// 날짜와 시간을 포맷팅(Formatting)된 문자열로 변환하는 메서드를 제공하는 클래스
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String formatDate = today.format(dtf);
		System.out.println(formatDate);
		System.out.println(today);

	}

	/*
	 * D-Day 계산기 : 년월일 입력하여 디데이 계산 ChronoUnit.DAYS.between (날짜, 날짜 ) 또는 날짜.
	 * 날짜.until(날짜, ChronoUnit.DAYS) > 날짜와 날짜 사이의 일수를 계산함  Long 타입 
	 *  
	 */
	public void method3() {

		Scanner sc = new Scanner(System.in);
		System.out.println("==== D-Day계산기 ====");
		System.out.println("년,월,일을 각각 입력해주세요 ");
		System.out.print("년 : ");
		int year = Integer.parseInt(sc.nextLine()); // int로 입력받음
		System.out.print("월 : ");
		int month = Integer.parseInt(sc.nextLine());
		System.out.print("일 : ");
		int day = Integer.parseInt(sc.nextLine());
		LocalDate today = LocalDate.now(); // 오늘 날짜로 부터 계산을 해야 해서 오늘날짜를 담은 today 생성

		try {
			LocalDate dDay = LocalDate.of(year, month, day); // 입력받은 년월일로 이루어진 Dday 생성
			
			System.out.println("오늘 날짜 : " + today);
			
			System.out.println("입력 받은 날짜 : " + dDay);
			
			Period pe = Period.between(today, dDay); // 두 날짜간의 차이를 담은 pe
			
			int days = pe.getDays(); // pe.getDays pe.getYears가 if문에 적용이 안되서 days, years 값에 담음
			
			int years = pe.getYears(); //
			
			// 날짜.until(날짜, ChronoUnit.DAYS) > 날짜와 날짜 사이의 일수를 계산함  Long 타입 -> if문 안써도 가능 
			// today.until(dDay, ChronoUnit.DAYS); 
			
			if (years >= 1 ) {
				days = (years * 365) + days; // 1년이상일시 Dday계산
				System.out.println("D-Day : " + days);
			} else if(days ==0) {
				System.out.println("오늘이 D-Day입니다");
			} else if(years < 1) {
				System.out.println("D-Day : " + days);
			} 
			
		} catch (Exception e) {
			
			System.out.println("유효한 날짜가 아닙니다. 다시 입력해주세요");
			method3();
			
		}

	}

	public static void main(String[] args) {

		B_time b = new B_time();
		// b.method1();
		// b.method2();
		b.method3();

	}

}
