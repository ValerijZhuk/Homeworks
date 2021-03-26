package master;

public class User {
    private String user;
    private String password;
    private String fio;
    private String date;

    public User() {
    }
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getFio() {
        return fio;
    }

    public String getDate() {
        return date;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User(String user, String password, String fio, String date) {
        this.user = user;
        this.password = password;
        this.fio = fio;
        this.date = date;
    }
}