package by.it_academy.jd2.hw.example.airports.view;

import by.it_academy.jd2.hw.example.airports.model.Flying;
import by.it_academy.jd2.hw.example.airports.model.Singleton;
import by.it_academy.jd2.hw.example.airports.storage.api.IFlyingsDAO;
import by.it_academy.jd2.hw.example.airports.view.api.IFlyingsView;

import java.util.List;

public class FlyingsView implements IFlyingsView {
    private static final FlyingsView instance = new FlyingsView();
    private final IFlyingsDAO flyingsDAO;

    public FlyingsView() {
        this.flyingsDAO = (IFlyingsDAO) Singleton.FLYING_DAO.getInstance();
    }

    @Override
    public long count(FlyingFilter filter){
        return this.flyingsDAO.count(
                filter.getAirportOut(),
                filter.getAirportIn(),
                20,
                filter.getPage()
        );
    }

    @Override
    public List<Flying> getList(FlyingFilter filter) {
        return this.flyingsDAO.getList(
                filter.getAirportOut(),
                filter.getAirportIn(),
                20,
                filter.getPage()
        );
    }

    @Override
    public Flying get(Integer key) {
        return null;
    }

    public static FlyingsView getInstance() {
        return instance;
    }
}
