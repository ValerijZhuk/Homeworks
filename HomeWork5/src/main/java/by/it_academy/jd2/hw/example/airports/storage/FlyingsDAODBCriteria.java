package by.it_academy.jd2.hw.example.airports.storage;

import by.it_academy.jd2.hw.example.airports.model.Flying;
import by.it_academy.jd2.hw.example.airports.model.Singleton;
import by.it_academy.jd2.hw.example.airports.storage.api.IFlyingsDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class FlyingsDAODBCriteria implements IFlyingsDAO {
    private static final FlyingsDAODBCriteria instance = new FlyingsDAODBCriteria();
    private final SessionFactory sf;

    public FlyingsDAODBCriteria() {
        this.sf = (SessionFactory) Singleton.HIBERNATE.getInstance();
    }

    @Override
    public long count(String airportOut, String airportIn, int count, int page) {
        try(Session session = sf.openSession()){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
            Root<Flying> from = query.from(Flying.class);
            query.select(criteriaBuilder.count(from.get("flightId")));
            if(airportIn != null || airportOut != null){
                List<Expression> expressionsOr = new ArrayList<>();

                if(airportOut != null){
                    expressionsOr.add(criteriaBuilder.equal(from.get("arrivalAirport"), airportOut));
                }

                if(airportIn != null){
                    expressionsOr.add(criteriaBuilder.equal(from.get("departureAirport"), airportIn));
                }

                query.where(criteriaBuilder.or(expressionsOr.toArray(new Predicate[0])));
            }

            return session.createQuery(query).uniqueResult();
        }
    }

    @Override
    public List<Flying> getList(String airportOut, String airportIn, int count, int page) {
        try(Session session = sf.openSession()){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Flying> query = criteriaBuilder.createQuery(Flying.class);
            Root<Flying> from = query.from(Flying.class);
            query.select(from);
            if(airportIn != null || airportOut != null){
                List<Expression> expressionsOr = new ArrayList<>();

                if(airportOut != null){
                    expressionsOr.add(criteriaBuilder.equal(from.get("arrivalAirport"), airportOut));
                }

                if(airportIn != null){
                    expressionsOr.add(criteriaBuilder.equal(from.get("departureAirport"), airportIn));
                }

                query.where(criteriaBuilder.or(expressionsOr.toArray(new Predicate[0])));
            }
            query.orderBy(criteriaBuilder.asc(from.get("flightId")));

            Query<Flying> resultQuery = session.createQuery(query);

            resultQuery.setMaxResults(count > 0 ? count : 25);
            resultQuery.setFirstResult(page > 0 ? count * (page - 1) : 0);
            return resultQuery.getResultList();
        }
    }

    @Override
    public Flying get(Integer key) {
//        Session session = sf.openSession();
//        Query<Airport> query = session.createQuery("FROM Airport a", Airport.class);
//        return query.getResultList();
        return null;
    }

    public static FlyingsDAODBCriteria getInstance() {
        return instance;
    }
}
