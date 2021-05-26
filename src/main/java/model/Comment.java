package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String content;
	private Timestamp createdAt;
	private boolean published;
	private String userEmail;
	private Integer postId;

	/**
	 * @param id
	 * @param content
	 * @param createdAt
	 * @param published
	 * @param userEmail
	 * @param postId
	 */
	public Comment(Integer id, String content, Timestamp createdAt, boolean published, String userEmail,
			Integer postId) {
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.published = published;
		this.userEmail = userEmail;
		this.postId = postId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

}
