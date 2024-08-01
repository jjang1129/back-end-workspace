package mapper;



import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

// 매퍼 역할을 할꺼고 어노테이션이 필요하다 
// Mapper에 매칭되는 xml필요함?

@Mapper
public interface MemberMapper {
	
    void register(Member member);
	 
    List<Member> allMember();
    
    Member login(Member member);
    
    void update(Member member);
    
    List<Member> search(SearchDTO dto);
    
    void delete(List<String> idList);
   
   
   
}


