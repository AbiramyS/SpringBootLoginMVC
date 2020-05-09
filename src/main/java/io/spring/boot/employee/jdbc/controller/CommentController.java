package io.spring.boot.employee.jdbc.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.spring.boot.employee.jdbc.model.Comment;

@Controller
public class CommentController {
	
	@GetMapping("/addComment")
	public ModelAndView viewCommentForm() {
		ModelAndView mv=new ModelAndView("comment");
		return mv;
	}
	
	@PostMapping("/addComment")
	public ModelAndView addComment(@RequestParam("commentId") String commentId, @RequestParam("comment") String comment) {
		Comment commentl=new Comment(commentId, new Date(), comment);
		ModelAndView mv=new ModelAndView("successComment");
		mv.addObject("comment", commentl);
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
