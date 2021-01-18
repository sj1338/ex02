package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		log.info("******************** list *******************");
		List<BoardVO> list = service.getList();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/register")
	public void register() {
		
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
		
//		return "board/list";
		return "redirect:/board/list";
	}
	
	// 표: /board/read, 코드: /board/get
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		/** 예전 코드 (스프링 없이) 
		String boardNum = request.getParameter("num");
		int num = Integer.parseInt(boardNum);
		
		BoardVO vo = service.get((long) num);
		
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher(".jsp").forward();
		*/
		
		log.info("get method - bno: " + bno);
		BoardVO vo = service.get(bno);
		model.addAttribute("board", vo);
	}
	
	/*
	@GetMapping("/modify")
	public void modify(Long bno, Model model) {
		BoardVO vo = service.get(bno);
		model.addAttribute("board", vo);
	}
	*/
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		/** 스프링 없이
		BoardVO board = new BoardVO();
		board.setBno(request.getParameter("bno"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		*/
		
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify2")
	public String modify2(BoardVO board, RedirectAttributes rttr) {
		/** 스프링 없이
		BoardVO board = new BoardVO();
		board.setBno(request.getParameter("bno"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		*/
		
		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addAttribute("bno", board.getBno());
			rttr.addAttribute("a", "a");
			rttr.addFlashAttribute("b", "b");
		}
		
		return "redirect:/board/get";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	
}

// servlet/jsp
// ControllerUsingURI(Servlet) ....properties
//   /list.do -> ListHandler 