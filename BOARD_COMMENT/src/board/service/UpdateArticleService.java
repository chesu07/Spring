package board.service;

import board.model.BoardVO;

//글 수정을 제공하는 서비스
public interface UpdateArticleService {
	BoardVO getArticle(Integer num);
	String getPass(Integer num);
	void updateArticle(BoardVO boardVo);
}
