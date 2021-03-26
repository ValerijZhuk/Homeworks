package master;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;


public class CheckUser extends Dispatcher {
    public String getServletInfo(){
        return "Registration servlet";
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = UserList.findUser(request.getParameter("user"));
        if (user == null){
            this.forward("/registration.jsp", request, response);
        } else {
            if
            (!user.getPassword().equals(request.getParameter("password"))){
                this.forward("/registration.jsp", request, response);
            } else {
                this.forward("/successLogin.jsp", request, response);
            }
        }
    }
}