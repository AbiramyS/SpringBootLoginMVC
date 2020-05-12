package io.spring.boot.employee.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import io.spring.boot.employee.jdbc.dao.CommentDAO;
import io.spring.boot.employee.jdbc.model.Comment;

@Service
public class CommentDAOImpl implements CommentDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemaplate;
	
	public JdbcTemplate getJdbcTemaplate() {
		return jdbcTemaplate;
	}

	public void setJdbcTemaplate(JdbcTemplate jdbcTemaplate) {
		this.jdbcTemaplate = jdbcTemaplate;
	}
	@Override
	public int saveComment(Comment c) {
		String sql="insert into comment values(?,?,?)";
		System.out.println(c);
		return jdbcTemaplate.update(sql, c.getCommentId(), new java.sql.Timestamp(c.getCommentDate().getTime()), c.getComment());
	}
	@Override
	public List<Comment> getAllComment() {
		String sql="select * from comment";
		return jdbcTemaplate.query(sql, new CommentRowMapper());
	}

	@Override
	public Comment getCommentById(String commentId) {
		String sql = "select * from comment where commentId=?";
		return jdbcTemaplate.queryForObject(sql, new CommentRowMapper(), commentId);
	}


	@Override
	public int deleteComment(String commentId) {
		String sql="delete from comment where commentId=?";
		return jdbcTemaplate.update(sql);
	}

	@Override
	public int updateComment(Comment c) {
		String sql= "update comment set  comment=? where commentId =?";	
		return jdbcTemaplate.update(sql);
	}
}

class CommentRowMapper implements RowMapper<Comment>{

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment comment=new Comment();
		comment.setCommentId(rs.getString("commentId"));
		comment.setCommentDate(rs.getDate("commentDate"));
		comment.setComment(rs.getString("comment"));
		return comment;
	}

}
