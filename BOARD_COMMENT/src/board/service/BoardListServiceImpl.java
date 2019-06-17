package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.model.BoardVO;

//구현클래스
public class BoardListServiceImpl implements BoardListService{
	private BoardDao boardDao;
	public void setBoardDao(BoardDao boardDao){
		this.boardDao = boardDao;
	}
	
	@Override
	public List<BoardVO> getBoradList(Object obj){
		return this.boardDao.getList(obj);
	}

	@Override
	public Integer getListCount(Object obj){
		return this.boardDao.getListCount(obj);
	}
}
