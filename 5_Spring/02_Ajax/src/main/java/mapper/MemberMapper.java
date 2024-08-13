package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.model.Member;

@Mapper
public interface MemberMapper {
	
	  Member idCheck (Member member);
	  void signUp (Member member);	


}
