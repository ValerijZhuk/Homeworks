package master;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormRequest extends HttpServlet {
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException {
        performTask(req, resp);
    }
    private void performTask(HttpServletRequest req,
                             HttpServletResponse resp) {
        by.it_academy.jd2.web.servlets.chat.RequestOutput.generate(resp, req);
    }
}