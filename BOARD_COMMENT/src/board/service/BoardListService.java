package board.service;

import java.util.List;

import board.model.BoardVO;

//글 목록을 가져오는 서비스
public interface BoardListService {
	Integer getListCount(Object obj);
	List<BoardVO> getBoradList(Object obj);
}
