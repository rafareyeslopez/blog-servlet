package model;

import java.io.Serializable;
import java.util.List;

public class Blog implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String url;
	private String userEmail;
	private List<Categories> categories;
	private List<Post> posts;

	/**
	 * @param id
	 * @param name
	 * @param url
	 * @param userEmail
	 * @param categories
	 * @param posts
	 */
	public Blog(Integer id, String name, String url, String userEmail, List<Categories> categories, List<Post> posts) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.userEmail = userEmail;
		this.categories = categories;
		this.posts = posts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
