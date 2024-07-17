package person.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @NoArgsConstructor  기본 생성자 

// @Data : 기본생성자자나 @AllArgsConstructor 제외 나머지들 한꺼번에 만들어줌
// @AllArgsConstructor 모든 필드값 파라미터로 받는 생성자
// @Getter @Setter 겟터 셋터 
// @ToString 투스트링 

@Data @NoArgsConstructor @AllArgsConstructor
public class Person {
	
	
	private int id ;
	private String name;
	private int age;
	private String addr;

	
	
	

}
