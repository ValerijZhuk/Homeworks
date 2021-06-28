package by.it_academy.jd2.hw.example.airports.view;

import by.it_academy.jd2.hw.example.airports.model.Airport;
import by.it_academy.jd2.hw.example.airports.model.Singleton;
import by.it_academy.jd2.hw.example.airports.storage.api.IAirportsDAO;
import by.it_academy.jd2.hw.example.airports.view.api.IAirportsView;

import java.util.List;

public class AirportsView implements IAirportsView {

    private final static AirportsView instance = new AirportsView();
    private final IAirportsDAO dao;

    public AirportsView() {
        this.dao = (IAirportsDAO) Singleton.AIRPORT_DAO.getInstance();
    }

    @Override
    public List<Airport> getAll() {
        return this.dao.getAll();
    }

    public static AirportsView getInstance() {
        return instance;
    }
}
