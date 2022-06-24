package controller;

import java.sql.Date;

public class ToDo {

    public String description;
    public Boolean isDone;
    public int daysToFinish;


    public ToDo( String description, Boolean isDone, int daysToFinish) {

        this.description = description;
        this.isDone = isDone;
        this.daysToFinish = daysToFinish;
    }

    public ToDo() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public int getDaysToFinish() {
        return daysToFinish;
    }

    public void setDaysToFinish(int daysToFinish) {
        this.daysToFinish = daysToFinish;
    }

    @Override
    public String toString() {
        return "ToDo: " +
                "Description='" + description + '\'' +
                ", isDone=" + isDone +
                ", daysToFinish='" + daysToFinish + "'"
                ;
    }
}
