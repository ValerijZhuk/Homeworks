package web.servlet;

import core.dto.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "Choice", urlPatterns = "/choice")

public class ChoiceFlightServlet extends HttpServlet {
    private Connection connect;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            connect = new ConnectionBase().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Airports> allAirports = AllAirports.getAllAirports(connect);
        req.setAttribute("listB",allAirports);

        req.getRequestDispatcher("/choice.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        String scheduledDeparture = req.getParameter("scheduledDeparture");
        String scheduledArrival = req.getParameter("scheduledArrival");


        Flights flights = AllFlights.ListOfTitlesForFlightsWhithAllParam(connect);

        req.setAttribute("title", flights);
        req.setAttribute("conn", connect);
        req.setAttribute("departureAirport", departureAirport);
        req.setAttribute("arrivalAirport", arrivalAirport);
        req.setAttribute("scheduledDeparture", scheduledDeparture);
        req.setAttribute("scheduledArrival", scheduledArrival);
        List<Flights> choiceFlights = AllFlights.getChoiceFlights(connect, departureAirport, arrivalAirport, scheduledDeparture, scheduledArrival);

        if ((scheduledDeparture.equals("2017-01-01")) && (scheduledArrival.equals("2017-01-01"))) {
            final HttpSession session = req.getSession();
            session.setAttribute("page",1);
            session.setAttribute("title", flights);
            session.setAttribute("conn", connect);
            session.setAttribute("departureAirport", departureAirport);
            session.setAttribute("arrivalAirport", arrivalAirport);
            int ceil = (int)Math.ceil(choiceFlights.size() / 25.0);

            session.setAttribute("sizelist",ceil);

            req.getRequestDispatcher("/flightArport.jsp").forward(req, resp);
        } else {

            req.setAttribute("list", choiceFlights);
            req.getRequestDispatcher("/flight.jsp").forward(req, resp);
        }

    }
}