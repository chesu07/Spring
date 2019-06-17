package board.service;

import board.model.BoardVO;

//글쓰기를 제공하는 서비스
public interface WriteService {
	void insertWriting(BoardVO boardVo);
}
