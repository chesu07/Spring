package board.controller;

import board.model.BoardVO;
import board.service.DeleteArticleService;

//글삭제를 수행하는 컨트롤러
@Controller
public class DeleteArticleController {
	private DeleteArticleService deleteArticleService;
	public void setDeleteArticleService(DeleteArticleService deleteArticleService){
		this.deleteArticleService = deleteArticleService;
	}
	@RequestMapping
	public ModelAndView setView(Integer num){
		ModelAndView mav = new ModelAndView("/board/deleteForm.jsp");
		mav.addObject("num", num);
		return mav;		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(Integer num, BoardVO boardVo){
		String dbpass = this.deleteArticleService.getPass(num);
		
		if(boardVo.getPass().equals(dbpass)){
			this.deleteArticleService.deleteArticle(boardVo.getNum());
			ModelAndView mav = new ModelAndView("/board/deleteForm.jsp");
			mav.addObject("num", num);
			mav.addObject("value", "successDelete");
			return mav;
		}else{
			ModelAndView mav = new ModelAndView("/board/deleteForm.jsp");
			mav.addObject("num", num);
			mav.addObject("value", "passerror");
			return mav;
		}
	}
}
