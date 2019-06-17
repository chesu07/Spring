package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.model.BoardVO;

public class BoardDaoImpl implements BoardDao{
	private SqlSessionTemplate sqlSession;
	public void setSqlSession(SqlSessionTemplate sqlSession){
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<BoardVO> getList(Object obj){
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) obj;
		
		if(map.get("seqrch_type").equals("all")){
			return sqlSession.selectList("board.dao.board.getAllList", obj);
		} else if(map.get("seqrch_type").equals("writer")){
			return sqlSession.selectList("board.dao.board.getWriterList", obj);
		} else if(map.get("seqrch_type").equals("subject")){
			return sqlSession.selectList("board.dao.board.getAllList", obj);
		} else if(map.get("seqrch_type").equals("content")){
			return sqlSession.selectList("board.dao.board.getContentList", obj);
		} else{
			return sqlSession.selectList("board.dao.board.getList", obj);
		}		
	}
	
	@Override
	public int getListCount(Object obj){
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) obj;
		
		if(map.get("seqrch_type").equals("writer")){
			return sqlSession.selectOne("board.dao.board.getWriterCount", obj);
		} else if(map.get("seqrch_type").equals("subject")){
			return sqlSession.selectOne("board.dao.board.getSubjectCount", obj);
		} else if(map.get("seqrch_type").equals("content")){
			return sqlSession.selectOne("board.dao.board.getContentCount", obj);
		} else{
			return sqlSession.selectOne("board.dao.board.getAllList", obj);
		}		
	}
	
	//글쓰기 
	@Override
	public void insertArticle(BoardVO boardVo){
		sqlSession.insert("board.dao.board.insertArticle", boardVo);
	}
	
	//글보기 
	@Override
	public void getArticle(Integer num){
		sqlSession.update("board.dao.board.upReadcount", num);
	}
	
	//글수정
	@Override	
	public void updateArticle(BoardVO boardVo){
		sqlSession.update("board.dao.board.updateArticle", boardVo);
	}
	
	//비밀번호 가져오기 
	@Override
	public String getPass(Integer num){
		return sqlSession.selectOne("board.dao.board.getPass", num);
	}
	
	//글삭제 
	@Override
	public void deleteArticle(Integer num){
		sqlSession.delete("board.dao.board.deleteArticle", num);
	}
}
