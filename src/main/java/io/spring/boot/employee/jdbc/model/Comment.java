package io.spring.boot.employee.jdbc.model;

import java.util.Date;

public class Comment {
	
	private String commentId;
	private Date commentDate;
	private String comment;

	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(String commentId, Date commentDate, String comment) {
		super();
		this.commentId = commentId;
		this.commentDate = commentDate;
		this.comment = comment;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentDate=" + commentDate + ", comment=" + comment
				+ "]";
	}

	
	
	
	
	
	

}
