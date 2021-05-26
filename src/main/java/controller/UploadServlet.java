package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

@WebServlet(value = "/uploadfile")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		// req es la HttpServletRequest que recibimos del formulario.
		// Los items obtenidos serán cada uno de los campos del formulario,
		// tanto campos normales como ficheros subidos.
		try {

			List items = upload.parseRequest((new ServletRequestContext(req)));

			// Se recorren todos los items, que son de tipo FileItem
			for (Object item : items) {
				FileItem uploaded = (FileItem) item;

				// Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el
				// fichero
				// subido donde nos interese
				if (!uploaded.isFormField()) {
					// No es campo de formulario, guardamos el fichero en algún sitio
					File fichero = new File("C:\\Users\\rafar\\eclipse-workspace\\blog-servlet\\uploads",
							uploaded.getName());
					uploaded.write(fichero);
				} else {
					// es un campo de formulario, podemos obtener clave y valor
					String key = uploaded.getFieldName();
					String valor = uploaded.getString();
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}