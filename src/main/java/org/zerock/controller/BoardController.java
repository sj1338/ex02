package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	private BoardService service;
	
	/*
	public BoardController(BoardService service) {
		super();
		this.service = service;
	}
	*/

	// 211 page 표
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list") 
	// handler 메소드의 return type이 void인 경우
	//   요청경로가 view(jsp)의 이름이 됨 
	//   이 메소드는 (/board/list) -> /board/list.jsp
	public void list(Model model) {
		log.info("--------------------------- list --------------------------");
		List<BoardVO> list = service.getList();
		model.addAttribute("list", list);
		
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		/*
		BoardVO board = new BoardVO();
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));
		*/
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}
	
	// 표: /board/read, 코드: /board/get
	@GetMapping("/get")
	public void get() {
		
	}
	
	@PostMapping("/modify")
	public String modify() {
		return null;
	}
	
	@PostMapping("/remove")
	public String remove() {
		return null;
	}
}

// servlet/jsp
// ControllerUsingURI(Servlet) ....properties
//   /list.do -> ListHandler 