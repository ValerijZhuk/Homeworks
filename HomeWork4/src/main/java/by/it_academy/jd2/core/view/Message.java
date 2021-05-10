package by.it_academy.jd2.core.view;


import by.it_academy.jd2.core.Constants;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import by.it_academy.jd2.core.view.User;

public class Message implements Serializable {

    private User sender;
    private User receiver;
    private String message;
    private String date;
    private LocalDateTime dateTime;


    public Message() {
    }

    public Message(User sender, User receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.FORMAT_DATE);
        this.date = dateTime.format(formatter);

    }

    public String getSender() {
        return sender.getLogin();
    }

    public String getReceiver() {
        return receiver.getLogin();
    }

    public String getDate() {
        return date;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public String toString() {
        return date+ " От: " + sender.getName() +" Cообщениe: " + message + "\n";
    }
}
