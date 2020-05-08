package io.spring.boot.employee.jdbc;

import java.util.Date;

public class Post {
	
	private String postId;
	private Date postCreated;
	private String postTitle;
	private String postBody;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(String postId, Date postCreated, String postTitle, String postBody) {
		super();
		this.postId = postId;
		this.postCreated = postCreated;
		this.postTitle = postTitle;
		this.postBody = postBody;
	}
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public Date getPostCreated() {
		return postCreated;
	}
	public void setPostCreated(Date postCreated) {
		this.postCreated = postCreated;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostBody() {
		return postBody;
	}
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postCreated=" + postCreated + ", postTitle=" + postTitle + ", postBody="
				+ postBody + "]";
	}
	
	

}
