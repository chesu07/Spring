package com.lsj.spring;

import java.sql.SQLException;

import com.lsj.model.BoardVO;

public interface WriteBoardService {
	void write(BoardVO vo) throws ClassNotFoundException, SQLException;
}
