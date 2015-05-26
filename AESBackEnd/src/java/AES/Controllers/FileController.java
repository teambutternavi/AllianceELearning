/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asi
 */
@RestController
@RequestMapping(value = "/file", method = RequestMethod.POST)
public class FileController {
    
    @RequestMapping(value = "/upload", method=RequestMethod.GET)
    public void upload(HttpServletResponse response,HttpServletRequest request,@RequestParam Map<String,String> requestParams) throws IOException{
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("Hello<br/>");

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			out.println("You are not trying to upload<br/>");
			return;
		}
		out.println("You are trying to upload<br/>");

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			out.println("Number of fields: " + fields.size() + "<br/><br/>");
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				out.println("No fields found");
				return;
			}
			out.println("<table border=\"1\">");
			while (it.hasNext()) {
				out.println("<tr>");
				FileItem fileItem = it.next();
                                boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					out.println("<td>regular form field</td><td>FIELD NAME: " + fileItem.getFieldName() + 
							"<br/>STRING: " + fileItem.getString()
							);
					out.println("</td>");
				} else {
					out.println("<td>file form field</td><td>FIELD NAME: " + fileItem.getFieldName() +
							"<br/>STRING: " + fileItem.getString() +
							"<br/>NAME: " + fileItem.getName() +
							"<br/>CONTENT TYPE: " + fileItem.getContentType() +
							"<br/>SIZE (BYTES): " + fileItem.getSize() +
							"<br/>TO STRING: " + fileItem.toString()
							);
					out.println("</td>");
                                      String path = request.getSession().getServletContext().getRealPath("")+"\\uploads\\";
                                      //System.out.println(request.getSession().getServletContext().getRealPath(""));
                                      File f = new File(path +fileItem.getName());
                                      if(!f.exists())
                                          f.createNewFile();
                                      fileItem.write(f);
				}
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception ex) {
                  Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
                }
	}
       
    
}
