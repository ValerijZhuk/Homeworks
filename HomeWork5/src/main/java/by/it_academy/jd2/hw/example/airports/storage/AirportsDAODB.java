package by.it_academy.jd2.hw.example.airports.storage;

import by.it_academy.jd2.hw.example.airports.model.Airport;
import by.it_academy.jd2.hw.example.airports.model.Singleton;
import by.it_academy.jd2.hw.example.airports.storage.api.IAirportsDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AirportsDAODB implements IAirportsDAO {

    private final static AirportsDAODB instance = new AirportsDAODB();
    private final SessionFactory sf;

    public AirportsDAODB() {
        this.sf = (SessionFactory) Singleton.HIBERNATE.getInstance();
    }

    @Override
    public List<Airport> getAll() {
        try(Session session = sf.openSession()){
            Query<Airport> query = session.createQuery("FROM Airport a", Airport.class);
            return query.getResultList();
        }
    }

    public static AirportsDAODB getInstance() {
        return instance;
    }
}
