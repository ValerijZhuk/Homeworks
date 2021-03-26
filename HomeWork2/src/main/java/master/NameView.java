package master;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class NameView {

    String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return sdf.format(new Date());
    }

    private final List<String> names = new LinkedList<>();

    public void add(String name) {
        this.names.add(getFormattedDate() + " " + name);
    }

    public List<String> getAll() {
        return this.names;
    }
}
