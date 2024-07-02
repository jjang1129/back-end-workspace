package com.kh.practice;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConditionPractice {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ConditionPractice a = new ConditionPractice();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.method5();
//		a.method6();
//		a.method7();
//    	a.method8();
//		a.method9();
//		a.method10();
		a.method11();

	}

    /*
       입력 받은 정수가 양수이면서 짝수일 때만 "짝수다"를 출력하고 짝수가 아니면 "홀수다"를 출력하세요.
       양수가 아니면 "양수만 입력해주세요."를 출력하세요.
    
       숫자를 한 개 입력하세요 : -8
       양수만 입력해주세요.
     */
    public void method1() {
    	
    	System.out.print("숫자를 한 개 입력하세요 : ");
    	int num = sc.nextInt();
    	if( num > 0 && num%2 == 0) {
    		System.out.println("짝수다");
    	} else if(num > 0 && num%2 == 1) {
    		System.out.println("홀수다");
    	} else System.out.println("양수만 입력해주세요.");
    	
    	
    	
    	
    }

    /*
        정수 num1과 num2를 입력 받아서 두 수가 같으면 1 다르면 -1을 출력하세요.

        num1 : 2
        num2 : 3
        -1

        num1 : 11
        num2 : 11
        1
     */
    public void method2() {
    	
    	System.out.print("num1 : ");
    	int num1 = sc.nextInt();
    	System.out.print("num2 : ");
    	int num2 = sc.nextInt();
    	if(num1 == num2) {
    		System.out.println("1");
    	} else System.out.println("-1");
    }

    /*
        A 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라준다.
        피자 조각 수와 피자를 먹는 사람의 수를 입력받아 한 사람 당 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지 출력하세요.

        피자 조각 수 : 7
        피자 먹는 사람 수 : 10
        2
       

     */
    public void method3() {
        System.out.print("피자 조각 수 : ");
        int pizza = sc.nextInt();
        System.out.print("피자 먹는 사람 수 : ");
        int people = sc.nextInt();
        if(people%pizza == 0) {
        	System.out.println(people/pizza);
        } else {
        	System.out.println(people/pizza+1);
        }
    }

    /*
        국어, 영어, 수학 세 과목의 점수를 입력 받고 합계와 평균을 계산하고 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
        (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
        합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”를 출력하고 불합격인 경우에는 “불합격입니다.”를 출력하세요.
    
        국어점수 : 88 
        수학점수 : 50 
        영어점수 : 40 
        불합격입니다.

        국어점수 : 88
        수학점수 : 50
        영어점수 : 45
        합계 : 183
        평균 : 61.0
        축하합니다, 합격입니다!
     */
    public void method4() {
    	System.out.print("국어점수 : ");
    	int score1 = Integer.parseInt(sc.nextLine());
    	System.out.print("수학점수 : ");
    	int score2 = Integer.parseInt(sc.nextLine());
    	System.out.print("영어점수 : ");
    	int score3 = Integer.parseInt(sc.nextLine());
    	double avg =(double)(score1+score2+score3)/3;
    	if( (score1 >=40 && score2 >=40 && score3 >=40)&& (score1+score2+score3)/3 >=60  ) {
    		System.out.println("국어 점수 : "+score1);
    		System.out.println("수학 점수 : "+score2);
    		System.out.println("영어 점수 : "+score3);
    		System.out.println("합계 : "+(score1+score2+score3));
    		System.out.printf("평균 : %.1f\n ",avg); 
    		System.out.println("평균 : "+String.format("%.1f", avg)); // 소수점 자리 표현방식 prinf를 쓰거나 prtinln에서 string format 쓰거나
    		
    		System.out.println("축하합니다, 합격입니다!");
    	} else {
    		System.out.println("불합격입니다");
    	}

    }

    /*
        B 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만원 이상 사면 20%를 할인해준다.
        구매한 옷의 가격을 입력했을 때, 지불해야 할 금액을 출력하세요.
        
        구매한 옷 가격 : 580000 
        464000
     */                   // 처음에는 if 문 마다 일일히 system.out.printl(가격)을 사용했는데 그냥 
                          // if문 마다 price 값을 변화 시키고 마지막에 그 값만 출력하게끔 했다 
    public void method5() {
    	
    	System.out.print("구매한 옷 가격 : ");
    	int price = sc.nextInt();   
    	if ( price >= 500000) {
    		price = (int) (price*0.8);  	
    	} else if  ( price >= 300000) {
    		price = (int) (price*0.9);
    	} else if (price >=100000) {
    		price = (int) (price*0.95);
    	}  
    	DecimalFormat df = new DecimalFormat("###,###"); // 가격에 콤마 넣는법! 
    	
    	System.out.println(df.format(price)); 
    		
    	
    	
    	
    	
    	
    	

    }


    /*
        각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류한다.
        입력받은 각에 따라 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 출력하세요.
     */
    public void method6() {
// 0<* < 90 = 1
// 90 = 2    	
// 90<*<180 = 3
 // 180 = 4   	
    	
    	System.out.print("각을 입력하세요 : ");
    	int num = sc.nextInt();
    	if(num == 180) {
    		System.out.println("4");
    	} else if (num > 90) {
    		System.out.println("3");
    	} else if( num == 90) {
    		System.out.println("2");
    	}else if (num <90)
    		System.out.println("1");
    }


    /*
       아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요.
       로그인 성공 시 "로그인 성공", 
       아이디가 틀렸을 시 "아이디가 틀렸습니다.",
       비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다.",
       아이디와 비밀번호 둘 다 틀렸을 시 "로그인 실패" 를 출력하세요.

       아이디 : happy
       비밀번호 : 1234
       로그인 성공!

       아이디 : happy
       비밀번호 : 23467
       비밀번호가 틀렸습니다.

       아이디 : happy222
       비밀번호 : 1234
       아이디가 틀렸습니다.

       아이디 : happy222
       비밀번호 : 23456
       로그인 실패
    */
    public void method7() {

    	System.out.print("아이디 : ");
    	
    	String id = sc.nextLine();
    	System.out.print("비밀번호 : ");
    	int pass = Integer.parseInt(sc.nextLine());
    	if(id.equals("happy") && pass == 1234 ) {
    		System.out.println("로그인 성공");
    	} else if(id.equals("happy") && pass != 1234 ){
    		System.out.println("비밀번호가 틀렸습니다");
    	} else if ( id.equals("happy") == false && pass == 1234) {
    		System.out.println("아이디가 틀렸습니다");
    	} else System.out.println("로그인 실패");
    	
    //  선생님 풀이 	
    	System.out.println("아이디 : ");
    	String id1 = sc.nextLine();
    	System.out.println("비밀번호 : ");
    	String pass1 = sc.nextLine();
    	
    	String id1Check = "happy";
    	String pass1Check = "1234";
    	
    	if(id1.equals(id1Check) && pass1.equals(pass1Check)) {
    		System.out.println("로그인 성공!");
    	} else if (!id1.equals(id1Check) && !pass1.equals(pass1Check)) {
    		System.out.println("로그인 실패");
    	} else if (!id1.equals(id1Check)) {
    		System.out.println("아이디가 틀렸습니다. ");
    	} else {
    		System.out.println("비밀번호가 틀렸습니다. ");
    	}
    	
    }

    /*
        키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라 저체중 / 정상체중 / 과체중 / 비만을 출력하세요.
        BMI = 몸무게 / (키(cm) * 키(cm)) * 10000 
        BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
        BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
        BMI가 30이상일 경우 고도 비만

        키(cm)를 입력해 주세요 : 162
        몸무게(kg)를 입력해 주세요 : 46
        BMI 지수 : 17.527815881725342
        저체중

     */
     
    public void method8() {

    	System.out.print("키(cm)를 입력해주세요");
    	double height = Double.parseDouble(sc.nextLine());
    	System.out.print("몸무게(kg)을 입력해주세요");
    	double weight = Double.parseDouble(sc.nextLine());
    	
    	double bmi = weight/(height*height)*10000;
    	System.out.println("BMI 지수 : "+bmi);
    	if(bmi >= 30) {
    		System.out.println("고도비만");
    	} else if (bmi >=25) {
    		System.out.println("비만");
    	} else if( bmi >=23) {
    		System.out.println("과체중");
    	} else if( bmi >= 18.5) {
    		System.out.println("정상체중");
    	} else if ( bmi < 18.5) {
    		System.out.println("저체중");
    	}
    	
    	
    	
    }

    /*
        두 개의 양수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력하세요.
        (단, 양수가 아닌 값을 입력하거나 제시되어 있지 않은 연산 기호를 입력 했을 시 
        "잘못 입력하셨습니다. 프로그램을 종료합니다." 출력)

        숫자 입력 : 15
        숫자 입력 : 4
        연산자를 입력(+,-,*,/,%) : /
        15 / 4 = 3

     */
    public void method9() {
    
    	System.out.print("숫자 입력 : ");
    	int num =Integer.parseInt(sc.nextLine());
    
    
    	System.out.print("숫자 입력 : ");
    	int num2 =Integer.parseInt(sc.nextLine());
    	if(num <= 0 || num2 <=0) {
    		System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
    		return;
    	}
    	
    	
    	System.out.println("연산자 입력(+,-,*,/,%)");
    	String num3 =sc.nextLine();
    	
    	
    	
    	switch (num3) {
    	case "+" :
    		System.out.println(num +"+"+num2+"="+(num+num2));
    		break;
    	case "-" :
    		System.out.println(num +"-"+num2+"="+(num-num2));
    		break;
    	case "*" :
    		System.out.println(num +"*"+num2+"="+(num*num2));	
    		break;
    	case "/" :
    		System.out.println(num +"/"+num2+"="+(num/num2));
    		break;
    	case "%" :
    		System.out.println(num +"%"+num2+"="+(num%num2));	
    		break;
    	 default :
    		System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다." );
    	}
    	
    }

    /*
      아래 예시와 같이 메뉴를 출력하고 메뉴 번호를 누르면 “OO메뉴입니다“를, 종료 번호를 누르면 “프로그램이 종료됩니다.”를 출력하세요

        1. 입력
        2. 수정
        3. 조회
        4. 삭제
        9. 종료
        메뉴 번호를 입력하세요 : 3
        조회 메뉴입니다.
     */
    public void method10() {
        System.out.println("1. 입력");
        System.out.println("2. 수정");
        System.out.println("3. 조회");
        System.out.println("4. 삭제");
        System.out.println("9. 종료");
    	
    	System.out.print("메뉴 번호를 눌러주세요 : ");
    	int num = sc.nextInt();
    	switch (num) {
    	case 1 : 
    		System.out.println("입력메뉴입니다");
    		break;
    	case 2 : 
    		System.out.println("수정메뉴입니다");
    		break;
    	case 3 : 
    		System.out.println("조회메뉴입니다");
    		break;
    	case 4 : 
    		System.out.println("삭제메뉴입니다");
    		break;
    	case 9 : 
    		System.out.println("프로그램을 종료합니다");
    		break;
    	default :
    	  System.out.println("잘못된 번호 입니다.");
    		
    	
    	
    	
    	}
    	
    	
    	

    }

    /*
        중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
        총점 100점 중 배점으로는 다음과 같다.
        중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)

        이때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 입력

        총점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass,
        아니면 Fail을 출력하세요.

        중간 고사 점수 : 80
        기말 고사 점수 : 90
        과제 점수 : 50
        출석 횟수 : 15
        ===========결과==========
        중간 고사 점수(20) : 16.0
        기말 고사 점수(30) : 27.0
        과제 점수 (30) : 15.0
        출석 점수 (20) : 15.0
        총점 : 73.0
        PASS

        중간 고사 점수 : 80
        기말 고사 점수 : 30
        과제 점수 : 60
        출석 횟수 : 18
        ===========결과==========
        FAIL [점수 미달] (총점 61.0)

        중간 고사 점수 : 90
        기말 고사 점수 : 100
        과제 점수 : 80
        출석 횟수 : 13
        ===========결과==========
        FAIL [출석 횟수 부족] (13/20)

        중간 고사 점수 : 100
        기말 고사 점수 : 80
        과제 점수 : 40
        출석 횟수 : 10
        ===========결과==========
        FAIL [출석 횟수 부족] (10/20)
        FAIL [점수 미달] (총점 66.0)

     */
    public void method11() {
    	System.out.print("중간 고사 점수 : ");
    	int num1 = sc.nextInt();
    	System.out.print("기말 고사 점수 : ");
    	int num2 = sc.nextInt();
    	System.out.print("과제  점수 : ");
    	int num3 = sc.nextInt();
    	System.out.print("출석  점수 : ");
    	int num4 = sc.nextInt();
    	if ( num4 > 20) {
    		System.out.println("출석 점수는 최대 20점 입니다");
    		return;
    	}
    	/* 중간 고사 점수(20) : 16.0
        기말 고사 점수(30) : 27.0
        과제 점수 (30) : 15.0
        출석 점수 (20) : 15.0
        총점 : 73.0
        PASS
    	 * */
    	System.out.println("===========결과==========");
    	double num11 = (double)num1*20/100;
    	double num22 = (double)num2*30/100;
    	double num33 =(double)num3*30/100;
    	
    	double sum =num11+num22+num33+(double)num4;
    	System.out.println("중간 고사 점수(20) : "+num11);
    	System.out.println("기말 고사 점수(30) : "+num22);
    	System.out.println(" 과제 점수 (30) : "+num33);
    	System.out.println(" 출석 점수 (20) : "+ num4);
    	System.out.println(" 총점 : "+ sum );
    	
    	if(sum >= 70 && num4 >=14) {
    		System.out.println("PASS");
    	} else if (sum < 70 && num4 >= 14) {
    		System.out.println("FAIL [점수 미달]"+ "총점("+sum+")");
    	} else if (sum > 70 && num4 < 14) {
    		System.out.println("FAIL [출석 횟수 부족 ]"+ "("+num4+"/20)");
    	} else {
    		System.out.println("FAIL [점수 미달]"+ "총점("+sum+")");
    		System.out.println("FAIL [출석 횟수 부족 ]"+ "("+num4+"/20)");
    	}
    	
    }
    
}