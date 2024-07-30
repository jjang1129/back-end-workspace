package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.vo.Member;

// 매퍼 역할을 할꺼고 어노테이션이 필요하다 
// Mapper에 매칭되는 xml필요함?

@Mapper
public interface MemberMapper {
	
    void register(Member member);
	
    Member search(String id);
   
	
}


