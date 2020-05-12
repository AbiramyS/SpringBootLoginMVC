package io.spring.boot.employee.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.spring.boot.employee.jdbc.impl.PostDAOImpl;
import io.spring.boot.employee.jdbc.model.Post;

@RestController
public class PostTitleController {
	
	@Autowired
	PostDAOImpl postDaoImpl;
	
	@GetMapping("/postTitle")
	public ModelAndView  getAllPostList(){
		List<Post>p=postDaoImpl.getAllPost();
		ModelAndView mv=new ModelAndView();
		mv.addObject("postTitle", p);
		mv.setViewName("postTitle");
		return mv;
	
	}
	
	@GetMapping("/postBody")
	public ModelAndView  getPostByforId(String postId) {
		Post singlePost=postDaoImpl.getPostById(postId);
		ModelAndView mv=new ModelAndView();
		mv.addObject("postBody", singlePost);
		mv.setViewName("postBody");
		return mv;
	
	}
	

}
