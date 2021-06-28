package by.it_academy.jd2.hw.example.airports.controller.web;

import by.it_academy.jd2.hw.example.airports.model.Airport;
import by.it_academy.jd2.hw.example.airports.model.Flying;
import by.it_academy.jd2.hw.example.airports.model.Singleton;
import by.it_academy.jd2.hw.example.airports.view.api.IAirportsView;
import by.it_academy.jd2.hw.example.airports.view.api.IFlyingsView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FiltersServlet", urlPatterns = "/filters")
public class FiltersServlet extends HttpServlet {

    private final IAirportsView airportView;
    private final IFlyingsView flyingsView;

    public FiltersServlet() {
        this.airportView = (IAirportsView) Singleton.AIRPORT_VIEW.getInstance();
        this.flyingsView = (IFlyingsView) Singleton.FLYING_VIEW.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> airports = this.airportView.getAll();

        req.setAttribute("airports", airports);
        req.getRequestDispatcher("/views/filters.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String airportOut = req.getParameter("airport_out");
        String airportIn = req.getParameter("airport_in");
        String pageRaw = req.getParameter("page");
        int currentPage = pageRaw != null ? Integer.parseInt(pageRaw) : 1;

        IFlyingsView.FlyingFilter filter = new IFlyingsView.FlyingFilter(
                airportOut.isBlank() ? null : airportOut,
                airportIn.isBlank() ? null : airportIn,
                currentPage
        );

        List<Flying> flying = this.flyingsView.getList(filter);
        req.setAttribute("flying", flying);

        long maxCountFlying = this.flyingsView.count(filter);
        req.setAttribute("maxCountFlying", maxCountFlying);
        req.setAttribute("currentPage", currentPage);

        List<Airport> airports = this.airportView.getAll();
        req.setAttribute("airports", airports);


        req.setAttribute("currentAirportIn", airportIn);
        req.setAttribute("currentAirportOut", airportOut);



        req.getRequestDispatcher("/views/filters.jsp").forward(req, resp);
    }
}
