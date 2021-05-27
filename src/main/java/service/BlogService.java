package service;

import java.util.List;

import model.Blog;
import model.Post;

public interface BlogService {

	List<Blog> getUserBlogs(String email);

	void create(String name, String url, String userEmail, String[] strings);

	/**
	 * @param parameter
	 * @param parameter2
	 * @param parameter3
	 */
	void addPost(String title, String content, Integer blogId);

	List<Blog> getAllBlogs();

	Blog getBlogDetail(String blogId);

	/**
	 * @param postId
	 * @return
	 */
	Post getPost(Integer postId);

	/**
	 * @param id
	 * @param parameter2
	 * @param parameter3
	 */
	void updatePost(int id, String title, String content);

	/**
	 * @param postId
	 */
	void deletePost(Integer postId);

	/**
	 * @param parseInt
	 * @param parameter
	 * @param parameter2
	 */
	void addComment(int postId, String content, String user);

	/**
	 * @param commentId
	 */
	void deleteComment(Integer commentId);

	/**
	 * @param commentId
	 */
	void publishComment(Integer commentId);

	/**
	 * @param postId
	 * @param string
	 */
	void addAttachmentPost(String postId, String filePath);

}
