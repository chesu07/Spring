package board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import board.model.BoardVO;
import board.service.WriteService;

//글쓰기 기능을 제공하는 컨트롤러
@Controller
public class WriteController {
	private WriteService writeService;
	public void setWriteService(WriteService writeService){
		this.writeService = writeService;
	}
	@RequestMapping
	public String setView(){
		return "/board/writeForm.jsp";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(HttpServletRequest request, BoardVO boardVo, BindingResult bindingResult) throws Exception{
		//글쓰기 DB에 저장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		this.writeService.insertWriting(boardVo);
		return new ModelAndView("redirect:/board/list.do");
	}
	
}
