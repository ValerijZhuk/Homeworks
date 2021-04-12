package web.servlet;

import core.dto.Airports;
import core.dto.AllAirports;
import core.dto.ConnectionBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "Air", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {
    private Connection connect;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            connect = new ConnectionBase().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Airports> allAirports = AllAirports.getAllAirports(connect);
        Airports airports = AllAirports.titlesAirports(connect);
        req.setAttribute("title",airports);
        req.setAttribute("list",allAirports );
        req.getRequestDispatcher("/airop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            connect.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}