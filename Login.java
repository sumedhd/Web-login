/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sumedh
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      public Login(){
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
          PreparedStatement st;
        ResultSet rs;
          String username= request.getParameter("uname");
          String password = request.getParameter("pass");
        
          
          String query= "SELECT * FROM loginform WHERE username = ? AND password = ?";
          
          try {
              
            st = Myconnection.getConnection().prepareStatement(query);
            
            st.setString(1, username);
            st.setString(2, password);
            
            rs = st.executeQuery();
             
              
              if(rs.next()){
                  HttpSession session=request.getSession();
                  session.setAttribute("username", username);
                  response.sendRedirect("welcome.jsp?username="+username+"");
              }
              else{
                  System.out.println("Invalid username or password");
              }
          } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }

    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
