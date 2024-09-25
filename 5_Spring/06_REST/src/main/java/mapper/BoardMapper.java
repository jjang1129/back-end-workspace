package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

@Mapper
public interface BoardMapper {

	
	 void upload1 (Board board);
	 
	 List<Board> list(Paging paging);
	 
	 Board one(int no);
	 
	 void update (Board board);
	 
	 void remove(int no);
	 
	 public int total();
}
