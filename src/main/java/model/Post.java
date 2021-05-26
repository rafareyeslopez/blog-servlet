package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;
	private String content;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Integer blogId;
	private List<Comment> comments;

	/**
	 * @param id
	 * @param title
	 * @param content
	 * @param createdAt
	 * @param updatedAt
	 * @param blogId
	 * @param comments
	 */
	public Post(Integer id, String title, String content, Timestamp createdAt, Timestamp updatedAt, Integer blogId,
			List<Comment> comments) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.blogId = blogId;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
