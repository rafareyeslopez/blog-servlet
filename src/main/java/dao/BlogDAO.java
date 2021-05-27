package dao;

import java.util.List;

import model.Blog;
import model.Comment;
import model.Post;

public interface BlogDAO {

	List<Blog> getUsersBlogs(String email);

	void create(Blog blog);

	void addPost(Post post);

	List<Blog> getAllBlogs();

	Blog getBlogById(String blogId);

	Post getPostById(Integer postId);

	void updatePost(Post postById);

	void deletePostById(Integer postId);

	void createComment(Comment comment);

	void deleteCommentById(Integer commentId);

	void publishComment(Integer commentId);

	void addAttachmentPost(String postId, String filePath);
}
