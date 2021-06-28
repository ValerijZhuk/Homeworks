package by.it_academy.jd2.hw.example.airports.storage;

import by.it_academy.jd2.hw.example.airports.model.Flying;
import by.it_academy.jd2.hw.example.airports.model.Singleton;
import by.it_academy.jd2.hw.example.airports.storage.api.IFlyingsDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FlyingsDAODB implements IFlyingsDAO {
    private static final FlyingsDAODB instance = new FlyingsDAODB();
    private final SessionFactory sf;

    public FlyingsDAODB() {
        this.sf = (SessionFactory) Singleton.HIBERNATE.getInstance();
    }

    @Override
    public long count(String airportOut, String airportIn, int count, int page) {
        try(Session session = sf.openSession()){
            String sql = "select count(flightId) FROM Flying a";
            if(airportIn != null || airportOut != null){
                sql += " WHERE";
                int defaultLength = sql.length(); //Для проверки добавления условия в sql

                if(airportOut != null){
                    sql += " arrivalAirport = :arrival_airport";
                }

                if(airportIn != null){
                    if(defaultLength != sql.length()){
                        sql += " OR ";
                    }
                    sql += " departureAirport = :departure_airport";
                }
            }

            Query<Long> query = session.createQuery(sql, Long.class);

            if(airportIn != null || airportOut != null){
                if(airportOut != null){
                    query.setParameter("arrival_airport", airportOut);
                }

                if(airportIn != null){
                    query.setParameter("departure_airport", airportIn);
                }
            }

            return query.uniqueResult();
        }
    }

    @Override
    public List<Flying> getList(String airportOut, String airportIn, int count, int page) {
        try(Session session = sf.openSession()){
            String sql = "FROM Flying a";
            if(airportIn != null || airportOut != null){
                sql += " WHERE";
                int defaultLength = sql.length(); //Для проверки добавления условия в sql

                if(airportOut != null){
                    sql += " arrivalAirport = :arrival_airport";
                }

                if(airportIn != null){
                    if(defaultLength != sql.length()){
                        sql += " OR ";
                    }
                    sql += " departureAirport = :departure_airport";
                }
            }

            Query<Flying> query = session.createQuery(sql, Flying.class);

            if(airportIn != null || airportOut != null){
                if(airportOut != null){
                    query.setParameter("arrival_airport", airportOut);
                }

                if(airportIn != null){
                    query.setParameter("departure_airport", airportIn);
                }
            }

            query.setMaxResults(count > 0 ? count : 25);
            query.setFirstResult(page > 0 ? count * (page - 1) : 0);
            return query.getResultList();
        }
    }

    @Override
    public Flying get(Integer key) {
//        Session session = sf.openSession();
//        Query<Airport> query = session.createQuery("FROM Airport a", Airport.class);
//        return query.getResultList();
        return null;
    }

    public static FlyingsDAODB getInstance() {
        return instance;
    }
}
