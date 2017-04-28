package com.cgi.learning.PDF;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cgi.learning.common.DBUtils;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/pdfgenerator")
public class PdfGenerator extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String OWNER_PASSWORD = "manish";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("userName");

		Document doc = new Document();
		resp.setContentType("application/pdf");
		Connection con = DBUtils.getConnection();
		try {
			Statement stmnt = con.createStatement();
			ResultSet rst = stmnt.executeQuery("select * from registration where email='" + email + "'");
			while (rst.next()) {
				/* String name = rst.getString("name"); */
				/* String contact = rst.getString("contact"); */

				try {
					  PdfWriter writer = PdfWriter.getInstance(doc,resp.getOutputStream());
					 writer.setEncryption(rst.getString("password").getBytes(),
				                OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING,
				                PdfWriter.ENCRYPTION_AES_128);
					doc.open();
					Paragraph prefa = new Paragraph("Your details");
					prefa.setAlignment(Element.ALIGN_CENTER);

					doc.add(prefa);
					Paragraph paragraph = new Paragraph();
					Chunk ch_email = new Chunk("Email: " + email + "\n");
					paragraph.add(ch_email);

					Chunk ch_name = new Chunk("Name: " + rst.getString("name") + "\n");
					paragraph.add(ch_name);
					Chunk ch_contact = new Chunk("Contact:" + rst.getString("contact")+"\n");

					paragraph.add(ch_contact);
					Chunk ch_bloodgroup=new Chunk("BloodGroup: "+ rst.getString("bloodgroup")+"\n");
					paragraph.add(ch_bloodgroup);
					Chunk ch_city=new Chunk("City: "+rst.getString("city")+"\n");
					paragraph.add(ch_city);
					
					doc.add(paragraph);

					doc.add(new Paragraph("Generated on " + new Date().toString()));
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		doc.close();
	}

}
