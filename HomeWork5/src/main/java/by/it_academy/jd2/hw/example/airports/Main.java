package by.it_academy.jd2.hw.example.airports;

import by.it_academy.jd2.hw.example.airports.model.Airport;
import by.it_academy.jd2.hw.example.airports.model.Singleton;
import by.it_academy.jd2.hw.example.airports.storage.api.IAirportsDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IAirportsDAO airportDao = (IAirportsDAO) Singleton.AIRPORT_DAO.getInstance();
        List<Airport> all = airportDao.getAll();

        for (Airport airport : all) {
            System.out.println(airport);
        }
    }
}
