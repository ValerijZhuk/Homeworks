package by.it_academy.jd2.hw.example.airports.storage.api;

import by.it_academy.jd2.hw.example.airports.model.Airport;

import java.util.List;

public interface IAirportsDAO {
    List<Airport> getAll();
}
