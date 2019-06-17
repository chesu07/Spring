package board.service;

import board.dao.BoardDao;
import board.model.BoardVO;

//구현클래스
public class UpdateArticleServiceImpl implements UpdateArticleService {
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	@Override
	public void updateArticle(BoardVO boardVo){
		this.boardDao.updateArticle(boardVo);
	}
	
	@Override
	public BoardVO getArticle(Integer num){
		return this.boardDao.getArticle(num);
	}
	
	@Override
	public String getPass(Integer num){
		return this.boardDao.getPass(num);
	}
}
