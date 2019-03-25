package com.lsj.spring;

import java.sql.SQLException;

import com.lsj.model.BoardDAO;
import com.lsj.model.BoardVO;

public class WriteBoardServiceImpl implements WriteBoardService{
	private BoardDAO myDao;
	
	public WriteBoardServiceImpl(BoardDAO myDAO){
		this.myDao = myDAO;
	}
	
	@Override
	public void write(BoardVO vo) throws ClassNotFoundException, SQLException{
		System.out.println("WriteBoardServiceImpl.write() 완료");
		myDao.insert(vo);
	}
}
