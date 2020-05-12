package io.spring.boot.employee.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import io.spring.boot.employee.jdbc.dao.PostDAO;
import io.spring.boot.employee.jdbc.model.Post;

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
	public int savePost(Post p) {
		String sql="insert into post values(?,?,?,?) ";
		System.out.println(p);
		return jdbcTemaplate.update(sql, p.getPostId(), new java.sql.Timestamp(p.getPostCreated().getTime()) ,p.getPostTitle(), p.getPostBody());
	}
	@Override
	public List<Post> getAllPost() {
		String sql="select * from post";
		return jdbcTemaplate.query(sql, new PostRowMapper());
	}

	@Override
	public Post getPostById(String postId) {
		String sql = "select * from post where postId=?";
		return jdbcTemaplate.queryForObject(sql, new PostRowMapper(), postId);
	}
	

	@Override
	public int deletePost(String postId) {
		String sql="delete from post where postId=?";
		return jdbcTemaplate.update(sql);
	}

	@Override
	public int updatePost(Post p) {
		String sql= "update post set  postTitle=?, postBody=? where postId =?";	
		return jdbcTemaplate.update(sql);
	}

	
}

class PostRowMapper implements RowMapper<Post>{

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		Post post=new Post();
		post.setPostId(rs.getString("postId"));
		post.setPostCreated(rs.getDate("postCreated"));
		post.setPostTitle(rs.getString("postTitle"));
		post.setPostBody(rs.getString("postBody"));
		return post;
	}
	
}
