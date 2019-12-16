package birthday;

import java.time.LocalDateTime;

public class Date {
    private int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /* Format => "1998-03-24" */
    Date(String date) {
        this.day = Integer.parseInt(date.substring(8, 10));
        this.month = Integer.parseInt(date.substring(5, 7));
        this.year = Integer.parseInt(date.substring(0, 4));
    };;

    boolean isSameDay() {
        LocalDateTime now = LocalDateTime.now();
        return this.day == now.getDayOfMonth() && this.month == now.getMonthValue();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
