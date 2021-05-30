package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import service.BlogService;
import service.BlogServiceImpl;

@WebServlet(value = "/downloadfile")
public class DownloadAttachment extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private BlogService blogService;

	public DownloadAttachment() {
		super();
		blogService = new BlogServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Integer postId = Integer.parseInt(req.getParameter("postId"));

		Post post = blogService.getPost(postId);

		res.setContentType("APPLICATION/OCTET-STREAM");
		res.setHeader("Content-Disposition", "attachment; filename=\""
				+ post.getAttachmentPath().substring(post.getAttachmentPath().lastIndexOf("\\")) + "\"");

		FileInputStream fileInputStream = new FileInputStream(post.getAttachmentPath());

		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}

}