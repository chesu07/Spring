package board.service;

import board.dao.BoardDao;
import board.model.BoardVO;

//구현클래스
public class GetArticleServiceImpl implements GetArticleService {
	private BoardDao boardDao;
	
	public BoardDao getBoardDao(){
		return boardDao;
	}
	
	public void setBoardDao(BoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	@Override
	public BoardVO getArticle(Integer num){
		return this.boardDao.getArticle(num);
	}
}
