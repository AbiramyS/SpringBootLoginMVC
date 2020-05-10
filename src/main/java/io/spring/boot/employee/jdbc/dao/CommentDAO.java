package io.spring.boot.employee.jdbc.dao;

import java.util.List;

import io.spring.boot.employee.jdbc.model.Comment;

public interface CommentDAO {
	public List<Comment> getAllComment();
	public Comment getCommentById(String commentId);
	public int saveComment(Comment c);
	public int deleteComment(String commentId);
	public int updateComment(Comment c);

}
