/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author sumedh
 */
@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet {

   public Register(){
       super();
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("server at ").append(request.getContextPath());
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
          String username= request.getParameter("uname");
          String password = request.getParameter("pass");
           
          String email= request.getParameter("email");
          
          if(username.equals("") || password.equals("")|| email.equals("")){
            JOptionPane.showMessageDialog(null, "somethings missing");
           
           }
         PreparedStatement st;
     String query = "INSERT INTO loginform (username, password, email) VALUES (?,?,?)";
     
        try {
            st = Myconnection.getConnection().prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, email);
            
            if(st.executeUpdate() > 0)
            {
               
                response.sendRedirect("login.jsp");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
          
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
