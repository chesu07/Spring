package board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.model.BoardVO;
import board.service.UpdateArticleService;

//글 내용을 수정하는 컨트롤러
@Controller
public class UpdateArticleController {
	private UpdateArticleService updateArticleService;
	
	public void setUpdateArticleService(UpdateArticleService updateArticleService){
		this.updateArticleService = updateArticleService;
	}
	
	@RequestMapping
	public ModelAndView setView(Integer num){
		BoardVO boardVo = this.updateArticleService.getArticle(num);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vo", boardVo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/updateForm.jsp");
		mav.addAllObjects(model);
		return mav;
	}
	
	@RequestMapping(method=RequestResult.POST)
	public ModelAndView onSubmit(HttpServletRequest request, BoardVO boardVo, BindingResult bindingaResult) throws Exception{
		String pass = this.updateArticleService.getPass(boardVo.getNum());
		if(boardVo.getPass().equals(pass)){
			this.updateArticleService.updateArticle(boardVo);
			return new ModelAndView("redirect:/board/list.do");
		}else{
			boardVo = this.updateArticleService.getArticle(boardVo.getNum());
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("vo", boardVo);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/board/UpdateForm.jsp");
			mav.addAllObject(model);
			return mav;			
		}
	}
	
	
	
	
	
	
	
}
