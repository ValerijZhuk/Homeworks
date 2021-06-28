package by.it_academy.jd2.hw.example.airports.storage.api;

import by.it_academy.jd2.hw.example.airports.model.Flying;
import by.it_academy.jd2.hw.example.airports.view.api.IFlyingsView;

import java.util.List;

public interface IFlyingsDAO {
    long count(String airportOut, String airportIn, int count, int page);
    List<Flying> getList(String airportOut, String airportIn, int count, int page);
    Flying get(Integer key);
}
