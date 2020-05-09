package io.spring.boot.employee.jdbc.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.spring.boot.employee.jdbc.impl.PostDAOImpl;
import io.spring.boot.employee.jdbc.model.Post;

@Controller
@RequestMapping("/posts")
public class PostController {
	@Autowired
	PostDAOImpl postDaoImpl;
	
	@GetMapping("/addPost")
	public ModelAndView createPost() {
		ModelAndView mv=new ModelAndView("post");
		return mv;
	}
	
	//RequestParam has an attribute required 
	//RequestParam has an attribute defaultvalue="18"--for age 
	//We can use RequestParam Map is the best way instead of usi
	@PostMapping("/addPost")
	public ModelAndView addPost(@RequestParam("postId") String postId, @RequestParam(required=false,name="postTitle") String postTitle, @RequestParam("postBody") String postBody){
		Post post=new Post(postId, new Date(), postTitle, postBody);
		System.out.println("Inside addpost(): " + post);
		int status=postDaoImpl.savePost(post);
		System.out.println(status);
		ModelAndView mv=new ModelAndView();
		if(status>0) {
			System.out.println("successfully inserted");
			mv.addObject("post", post);
			mv.setViewName("successPost");
		}else {
			mv.setViewName("post");
		}
		return mv;	
	}
	

	
	/*Instead of multiple @RequestParam annotation we can use @RequestParam Map<String, String> requestMap
	 * 	@PostMapping("/addPost")
		public ModelAndView addPost(@RequestParam Map<String, String> requestMap)
		//@RequestParam("postId") String postId, @RequestParam(required=false,name="postTitle") String postTitle, @RequestParam("postBody") String postBody){
		//Post post=new Post(postId, new Date(), postTitle, postBody);
		 * Post post=new Post(requestMap.get("postId"), new Date(),requestMap.get("postTitle"), requestMap.get("postBody"));
		//If there is an age taken from form that is in String we need to convert to Interger age=Integer.parseInt(requestMap.get("age"))
		System.out.println("Inside addpost(): " + post);
		int status=postDaoImpl.savePost(post);
		System.out.println(status);
		ModelAndView mv=new ModelAndView();
		if(status>0) {
			System.out.println("successfully inserted");
			mv.addObject("post", post);
			mv.setViewName("successPost");
		}else {
			mv.setViewName("post");
		}
		return mv;	
	}
	 * 
	 */
	@PostMapping("/addAPost")
	public ModelAndView addAPost(@RequestParam Map<String, String> requestMap) {
		Post post=new Post(requestMap.get("postId"), new Date(),requestMap.get("postTitle"), requestMap.get("postBody"));
		System.out.println("Inside addpost(): " + post);
		int status=postDaoImpl.savePost(post);
		System.out.println(status);
		ModelAndView mv=new ModelAndView();
		if(status>0) {
		System.out.println("successfully inserted");
		mv.addObject("post", post);
		mv.setViewName("redirect:viewPost");
	}else {
		mv.setViewName("post");
	}
	return mv;	
}	
	@GetMapping("/successPost")
	public ModelAndView successPost() {
		ModelAndView mv=new ModelAndView("successPost");
		return mv;
	}
	@GetMapping("/viewPost")
	public ModelAndView getAllPost(){
		List<Post> list= postDaoImpl.getAllPost();
		ModelAndView mv=new ModelAndView("viewPost");
		mv.addObject("postList", list);
		return mv;
	}
	


}
