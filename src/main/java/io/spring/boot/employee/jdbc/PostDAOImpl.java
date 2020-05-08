package io.spring.boot.employee.jdbc;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PostDAOImpl implements PostDAO{
	@Autowired
	private JdbcTemplate jdbcTemaplate;
	
	public JdbcTemplate getJdbcTemaplate() {
		return jdbcTemaplate;
	}

	public void setJdbcTemaplate(JdbcTemplate jdbcTemaplate) {
		this.jdbcTemaplate = jdbcTemaplate;
	}

	@Override
	public List<Post> getAllPost() {
		return null;
	}

	@Override
	public Post getPostById(String postId) {
		return null;
	}

	@Override
	public int savePost(Post p) {
		String sql="insert into post values(?,?,?,?) ";
		System.out.println(p);
		return jdbcTemaplate.update(sql, p.getPostId(), new java.sql.Timestamp(p.getPostCreated().getTime()) ,p.getPostTitle(), p.getPostBody());
	}

	@Override
	public int deletePost(String postId) {
		return 0;
	}

	@Override
	public int updatePost(Post p) {
		return 0;
	}

}
