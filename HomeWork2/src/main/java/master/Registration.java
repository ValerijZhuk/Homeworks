package master;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class Registration extends by.it_academy.jd2.web.servlets.chat.Dispatcher {

    public String getServletInfo(){
        return "Registration servlet";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        if (request.getParameter("login")!=null){
            this.forward("/CheckUser", request, response);
        } else if (request.getParameter("registration")!=null) {
            this.forward("/registration.jsp", request, response);
        }
    }
}