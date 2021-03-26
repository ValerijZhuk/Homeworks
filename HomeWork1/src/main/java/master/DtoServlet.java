package master;

import master.Person;
import master.HeaderName;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "DtoServlet", urlPatterns = "/cookss")
public class DtoServlet extends HttpServlet {

    ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = "firstName";
        String lastName = "lastName";
        String age = "age";

        Person person = new Person();
        String header = req.getHeader("My-header");

        try {
            if (HeaderName.COOKIE == HeaderName.valueOf(header)) {
                person.setFirstName(getParameterC(req, resp, firstName));
                person.setLastName(getParameterC(req, resp,lastName));
                person.setAge(Integer.parseInt(getParameterC(req, resp, age)));

            } else if (HeaderName.SESSIA == HeaderName.valueOf(header)) {
                person.setFirstName(getParameterS(req, firstName));
                person.setLastName(getParameterS(req, lastName));
                person.setAge(Integer.parseInt(getParameterS(req, age)));
            }

            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.write("<p><span style='color: red;'>Hello, " + person.getLastName() + " " + person.getFirstName()
                    + person.getAge() + "age!<p>");

        } catch (Exception e) {

            PrintWriter writer = resp.getWriter();
            writer.println("No one or two parametrs");


        }
    }

    private String getParameterC(HttpServletRequest req, HttpServletResponse resp, String name) throws Exception {
        String value = req.getParameter(name);

        if (value != null) {

            Cookie cookie = new Cookie(name, value);
            cookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
            resp.addCookie(cookie);

            return value;
        } else {

            Cookie[] cookies = req.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    value = cookie.getValue();

                    return value;
                }
            }
        }
        throw new Exception();
    }

    private String getParameterS(HttpServletRequest req, String name) throws Exception {
        HttpSession sessia = req.getSession();
        String value = req.getParameter(name);

        if (value != null) {

            sessia.setAttribute(name, value);

            return value;
        } else if (!sessia.isNew()) {

            value = sessia.getAttribute(name).toString();

            return value;
        }


        throw new Exception();
    }
}