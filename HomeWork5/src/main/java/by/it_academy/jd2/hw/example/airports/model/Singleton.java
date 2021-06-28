package by.it_academy.jd2.hw.example.airports.model;

import by.it_academy.jd2.hw.example.airports.storage.AirportsDAODB;
import by.it_academy.jd2.hw.example.airports.storage.FlyingsDAODB;
import by.it_academy.jd2.hw.example.airports.storage.FlyingsDAODBCriteria;
import by.it_academy.jd2.hw.example.airports.storage.utils.HibernateCreator;
import by.it_academy.jd2.hw.example.airports.view.AirportsView;
import by.it_academy.jd2.hw.example.airports.view.FlyingsView;

public enum Singleton {
    HIBERNATE(HibernateCreator.getInstance()),
    AIRPORT_DAO(AirportsDAODB.getInstance()),
    AIRPORT_VIEW(AirportsView.getInstance()),
    FLYING_DAO(FlyingsDAODBCriteria.getInstance()),
    FLYING_VIEW(FlyingsView.getInstance()),
    ;

    private Object instance;

    Singleton(Object instance) {
        this.instance = instance;
    }

    public Object getInstance() {
        return instance;
    }
}
