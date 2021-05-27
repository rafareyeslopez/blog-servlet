package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import model.Comment;
import model.Post;

public class BlogDAOJDBCimpl implements BlogDAO {

	@Override
	public List<Blog> getUsersBlogs(String email) {
		List<Blog> blogs = new ArrayList<>();

		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from blog where user_email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				blogs.add(new Blog(rs.getInt("id"), rs.getString("name"), rs.getString("url"),
						rs.getString("user_email"), rs.getString("categories").trim().split(","), null));
			}

			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return blogs;
	}

	@Override
	public void create(Blog blog) {
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("insert into blog (name,url, user_email,categories) values (?,?,?,?)");
			ps.setString(1, blog.getName());
			ps.setString(2, blog.getUrl());
			ps.setString(3, blog.getUserEmail());

			String categoriesCsv = "";

			for (int i = 0; i < blog.getCategories().length; i++) {
				categoriesCsv += blog.getCategories()[i] + ", ";
			}
			categoriesCsv = categoriesCsv.substring(0, categoriesCsv.length() - 2);

			ps.setString(4, categoriesCsv);
			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	@Override
	public void addPost(Post post) {
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"insert into posts (title,content, blog_id,created_at,updated_at) values (?,?,?,?,?)");
			ps.setString(1, post.getTitle());
			ps.setString(2, post.getContent());
			ps.setInt(3, post.getBlogId());
			ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	@Override
	public List<Blog> getAllBlogs() {
		List<Blog> blogs = new ArrayList<>();

		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from blog");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				blogs.add(new Blog(rs.getInt("id"), rs.getString("name"), rs.getString("url"),
						rs.getString("user_email"), null, null));
			}

			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return blogs;
	}

	@Override
	public Blog getBlogById(String blogId) {
		List<Blog> blogs = new ArrayList<>();

		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from blog where id=?");
			ps.setString(1, blogId);
			ResultSet rs = ps.executeQuery();
			Blog blog;
			List<Post> posts = new ArrayList<>();
			while (rs.next()) {

				PreparedStatement ps2 = conn.prepareStatement("select * from posts where blog_id=?");
				ps2.setString(1, blogId);
				ResultSet rs2 = ps2.executeQuery();

				while (rs2.next()) {
					List<Comment> comments = new ArrayList<>();
					int postId = rs2.getInt("id");

					PreparedStatement ps3 = conn.prepareStatement("select * from comment where post_id=?");
					ps3.setInt(1, postId);
					ResultSet rs3 = ps3.executeQuery();
					while (rs3.next()) {
						comments.add(
								new Comment(rs3.getInt("id"), rs3.getString("content"), rs3.getTimestamp("created_at"),
										rs3.getBoolean("published"), rs3.getString("user_email"), postId));

					}
					posts.add(new Post(rs2.getInt("id"), rs2.getString("title"), rs2.getString("content"),
							rs2.getTimestamp("created_at"), rs2.getTimestamp("updated_at"), rs2.getInt("blog_id"),
							comments, rs2.getString("attachment_path")));
					ps3.close();

				}

				blog = new Blog(rs.getInt("id"), rs.getString("name"), rs.getString("url"), rs.getString("user_email"),
						null, posts);

				blogs.add(blog);

				ps2.close();
			}

			ps.close();
		} catch (

		SQLException throwables) {
			throwables.printStackTrace();
		}
		return blogs.get(0);
	}

	@Override
	public Post getPostById(Integer postId) {

		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from posts where id=?");
			ps.setInt(1, postId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return new Post(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getTimestamp("created_at"), rs.getTimestamp("updated_at"), rs.getInt("blog_id"), null,
						rs.getString("attachment_path"));
			}

			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return null;
	}

	@Override
	public void updatePost(Post post) {
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("update posts set title=?,content=?,updated_at=? where id=?");
			ps.setString(1, post.getTitle());
			ps.setString(2, post.getContent());
			ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			ps.setInt(4, post.getId());

			ps.execute();
			ps.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	@Override
	public void deletePostById(Integer postId) {
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from comment where post_id=?");

			ps.setInt(1, postId);

			ps.execute();

			ps = conn.prepareStatement("delete from posts where id=?");
			ps.setInt(1, postId);

			ps.execute();

			ps.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	@Override
	public void createComment(Comment comment) {
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"insert into comment (content,created_at, published,user_email,post_id) values (?,?,?,?,?)");
			ps.setString(1, comment.getContent());
			ps.setTimestamp(2, comment.getCreatedAt());
			ps.setBoolean(3, comment.isPublished());
			ps.setString(4, comment.getUserEmail());
			ps.setInt(5, comment.getPostId());
			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	@Override
	public void deleteCommentById(Integer commentId) {
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from comment where id=?");

			ps.setInt(1, commentId);

			ps.execute();

			ps.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	@Override
	public void publishComment(Integer commentId) {
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("update comment set published=1 where id=?");
			ps.setInt(1, commentId);

			ps.execute();
			ps.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	@Override
	public void addAttachmentPost(String postId, String filePath) {
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("update posts set attachment_path=? where id=?");
			ps.setString(1, filePath);
			ps.setString(2, postId);

			ps.execute();
			ps.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

}
