package io.spring.boot.employee.jdbc.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.spring.boot.employee.jdbc.impl.CommentDAOImpl;
import io.spring.boot.employee.jdbc.model.Comment;


@Controller
public class CommentController {
	@Autowired
	CommentDAOImpl commentDAOImpl;
	
	@GetMapping("/addComment")
	public ModelAndView viewCommentForm() {
		ModelAndView mv=new ModelAndView("comment");
		return mv;
	}
	
	@PostMapping("/addComment")
	public ModelAndView addComment(@RequestParam("commentId") String commentId, @RequestParam("comment") String comment) {
		Comment commentl=new Comment(commentId, new Date(), comment);
		ModelAndView mv=new ModelAndView("viewComment");
		mv.addObject("comment", commentl);
		return mv;
	}
	
	@GetMapping("/viewComment")
	public ModelAndView getAllComments(){
		List<Comment> list=commentDAOImpl.getAllComment();
		ModelAndView mv=new ModelAndView("viewComment");
		mv.addObject("commentList", list);
		return mv;
	}
	
	@GetMapping("/editComment")
	public ModelAndView editComment(@RequestParam("id") String id) {
		ModelAndView mv=new ModelAndView("editComment");
		Comment c = commentDAOImpl.getCommentById(id);
		mv.addObject("comment", c);
		return mv;
	}
	
	@PostMapping("/editComment")
	public ModelAndView editCommentSave() {
		ModelAndView mv=new ModelAndView();
		Comment c=new Comment();
		int update = commentDAOImpl.updateComment(c);
		if(update == 1) {
			mv.setViewName("viewComment");
		}else {
				mv.setViewName("redirect:editComment");
		}
		return mv;
	}
	
	@GetMapping("/deleteComment")
	public ModelAndView deleteComment(@RequestParam("id") String id) {
		ModelAndView mv=new ModelAndView();
		int deleted = commentDAOImpl.deleteComment(id);
		if(deleted == 1) {
			System.out.println("Successfully deleted");;
		}else {
				mv.setViewName("redirect:viewComment");
		}
		return mv;
	}
	
	@GetMapping("/showComment")
	public ModelAndView CommentForm() {
		ModelAndView mv=new ModelAndView("comment");
		return mv;
	}
	
	@PostMapping("/showComment")
	public ModelAndView showComment(@RequestParam Map<String, String> requestmap){
		Comment commentl=new Comment(requestmap.get("commentId"), new Date(), requestmap.get("comment"));
		ModelAndView mv=new ModelAndView("successComment");
		mv.addObject("comment", commentl);
		return mv;
	}
	
	@GetMapping("/completeComment")
	public ModelAndView fillCommentForm() {
		ModelAndView mv=new ModelAndView("comment");
		return mv;
	}
	
	@PostMapping("/completeComment")
	public ModelAndView completeComment(HttpServletRequest request, HttpServletResponse response){
		String commentId= request.getParameter("commentId");
		String comment= request.getParameter("comment");
		Comment commentl=new Comment(commentId, new Date(),comment );
		ModelAndView mv=new ModelAndView("successComment");
		mv.addObject("comment", commentl);
		return mv;
	}
}
