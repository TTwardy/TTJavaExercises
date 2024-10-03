package Chapter8;
// Fig. 8.7: Date.java
// Date class declaration.

import java.time.Year;

public class Date {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // any year

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // constructor: confirm proper value for month and day given the year
    public Date(int month, int day, int year) {
        // check if month in range
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                    "month (" + month + ") must be 1-12");
        }

        // check if day in range for month
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("day (" + day +
                    ") out-of-range for the specified month and year");
        }

        // check for leap year if month is 2 and day is 29
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException("day (" + day +
                    ") out-of-range for the specified month and year");
        }

        if (year < 0 || year > Year.now().getValue()){
            throw new IllegalArgumentException("year cannot be lower than 0 or higher than current year");
        }

        this.month = month;
        this.day = day;
        this.year = year;

        System.out.printf("Date object constructor for date %s%n", this);
    }

    // return a String of the form month/day/year
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    public void nextDay(){
        if(day==daysPerMonth[12]){
            year++;
            month = 1;
            day = 1;
            System.out.print("Year"+year+" Month:"+month+" Day:"+ day+"\n");
        }
        else if (day!=daysPerMonth[month]){
            day++;
            System.out.print("Month:"+month+" Day:"+ day+"\n");
        }
        else {
            month++;
            day=1;
            System.out.print("Month:"+month+" Day:"+ day+"\n");
        }

    }
}
