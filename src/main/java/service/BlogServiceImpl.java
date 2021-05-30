package service;

import java.sql.Timestamp;
import java.util.List;

import dao.BlogDAO;
import dao.BlogDAOJDBCimpl;
import model.Blog;
import model.Comment;
import model.Post;

public class BlogServiceImpl implements BlogService {

	private BlogDAO dao;

	public BlogServiceImpl() {
		dao = new BlogDAOJDBCimpl();
	}

	@Override
	public List<Blog> getUserBlogs(String email) {
		return dao.getUsersBlogs(email);
	}

	@Override
	public void create(String name, String url, String userEmail, String[] categories) {
		Blog blog = new Blog(null, name, url, userEmail, categories, null);

		dao.create(blog);

	}

	@Override
	public void addPost(String title, String content, Integer blogId) {
		Post post = new Post(null, title, content, null, null, blogId, null);

		dao.addPost(post);

	}

	@Override
	public List<Blog> getAllBlogs() {
		return dao.getAllBlogs();
	}

	@Override
	public Blog getBlogDetail(String blogId) {
		return dao.getBlogById(blogId);
	}

	@Override
	public Post getPost(Integer postId) {
		return dao.getPostById(postId);
	}

	@Override
	public void updatePost(int id, String title, String content) {
		Post postById = dao.getPostById(id);

		postById.setTitle(title);
		postById.setContent(content);

		dao.updatePost(postById);

	}

	@Override
	public void deletePost(Integer postId) {
		dao.deletePostById(postId);

	}

	@Override
	public void addComment(int postId, String content, String user) {
		Comment comment = new Comment(null, content, new Timestamp(System.currentTimeMillis()), false, null, postId);

		if (user != null && user.length() > 0) {
			comment.setUserEmail(user);
			comment.setPublished(true);
		}

		dao.createComment(comment);

	}

	@Override
	public void deleteComment(Integer commentId) {
		dao.deleteCommentById(commentId);

	}

	@Override
	public void publishComment(Integer commentId) {
		dao.publishComment(commentId);

	}

	@Override
	public void addAttachmentPost(String postId, String filePath) {
		dao.addAttachmentPost(postId, filePath);

	}

}
