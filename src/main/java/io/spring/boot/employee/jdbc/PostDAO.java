package io.spring.boot.employee.jdbc;

import java.util.List;

public interface PostDAO {
	
	public List<Post> getAllPost();
	public Post getPostById(String postId);
	public int savePost(Post p);
	public int deletePost(String postId);
	public int updatePost(Post p);
}
