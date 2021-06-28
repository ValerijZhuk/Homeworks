package by.it_academy.jd2.hw.example.airports.controller.web;

import by.it_academy.jd2.hw.example.airports.model.Airport;
import by.it_academy.jd2.hw.example.airports.model.Singleton;
import by.it_academy.jd2.hw.example.airports.view.api.IAirportsView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {

    private final IAirportsView airportView;

    public AirportsServlet() {
        this.airportView = (IAirportsView) Singleton.AIRPORT_VIEW.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> airports = this.airportView.getAll();

        req.setAttribute("airports", airports);
        req.getRequestDispatcher("/views/airports.jsp").forward(req, resp);
    }
}
