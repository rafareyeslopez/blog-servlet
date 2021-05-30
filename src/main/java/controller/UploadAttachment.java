package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import service.BlogService;
import service.BlogServiceImpl;

@WebServlet(value = "/uploadfile")
public class UploadAttachment extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private BlogService blogService;

	public UploadAttachment() {
		super();
		blogService = new BlogServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		// req es la HttpServletRequest que recibimos del formulario.
		// Los items obtenidos serán cada uno de los campos del formulario,
		// tanto campos normales como ficheros subidos.
		try {
			List items = upload.parseRequest((new ServletRequestContext(req)));
			// Se recorren todos los items, que son de tipo FileItem
			String path = null;
			File fichero = null;
			FileItem uploaded = null;
			String blogId = null;
			String postId = null;
			FileItem fileToUpload = null;
			for (Object item : items) {

				uploaded = (FileItem) item;

				// Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el
				// fichero
				// subido donde nos interese
				if (!uploaded.isFormField()) {
					// No es campo de formulario, guardamos el fichero en algún sitio

					fileToUpload = uploaded;

				} else {
					// es un campo de formulario, podemos obtener clave y valor
					String key = uploaded.getFieldName();
					String valor = uploaded.getString();
					if (key.equals("blogId")) {
						blogId = valor;
					} else if (key.equals("postId")) {
						postId = valor;
					}

				}
			}

			path = "C:\\Users\\rafar\\eclipse-workspace\\blog-servlet\\uploads";

			String fileName = blogId + "_" + postId + "_" + fileToUpload.getName();
			fichero = new File(path, fileName);
			uploaded.write(fichero);

			blogService.addAttachmentPost(postId, path + "\\" + fileName);

			req.setAttribute("blog", blogService.getBlogDetail(blogId));
			RequestDispatcher rdObj = req.getRequestDispatcher("/jsp/blogDetail.jsp");
			rdObj.include(req, resp);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}