package board.service;

import board.model.BoardVO;

//글 내용을 가져오는 서비스
public interface GetArticleService {
	BoardVO getArticle(Integer num);
}