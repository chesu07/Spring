package board.controller;

import java.util.HashMap;
import java.util.Map;

import board.model.BoardVO;
import board.service.GetArticleService;

public class GetArticleController {
	private GetArticleService getArticleService;
	public void setGetArticleService(GetArticleService getArticleServic){
		this.getArticleService = getArticleService;
	}
	@RequestMapping
	public ModelAndView getArticle(Integer num){
		BoardVO boardVo = this.getArticleService.getArticle(num);
		Map<String,Object> model = new HashMap<String, Object>();
		model.put("vo", boardVo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/content.jsp");
		mav.addAllObject(model);
		return mav;
	}
}
