package Chapter8;

import java.time.Year;

public class DateAndTime{
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // any year
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59
    private String meridiem;
    private int timeFormat;

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // constructor: confirm proper value for month and day given the year
    public DateAndTime(int month, int day, int year, int hour, int minute, int second) {
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

        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("hour must be 0-23");
        }

        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("minute must be 0-59");
        }

        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("second must be 0-59");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;

        System.out.printf("Date object constructor for date %s%n", this);
    }

    public DateAndTime (int hour, int minute, int second, String meridiem){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.meridiem = meridiem;
        this.timeFormat = 3;
        System.out.println(displayTime());
    }

    // return a String of the form month/day/year
    public String toString() {
        return String.format("%d/%d/%d Time: %02d:%02d:%02d",year ,month, day , hour, minute, second);
    }

    public void nextDay(){
        if(day==daysPerMonth[12]){
            year++;
            month = 1;
            day = 1;
            System.out.printf("%s\n",this);
        }
        else if (day!=daysPerMonth[month]){
            day++;
            System.out.printf("%s\n",this);
        }
        else {
            month++;
            day=1;
            System.out.printf("%s\n",this);
        }
    }
    public void incrementHour (int hours){
        if (hour+hours<24){
            hour+=hours;
            System.out.printf("%s\n",this);
        } else if (hour+hours>=24) {
            hour=hour+hours-24;
            this.nextDay();
        }
    }
    public String toStandardTime() {
        return String.format("%d/%d/%d %d:%02d:%02d %s",year ,month, day ,
                ((hour == 0 || hour == 12) ? 12 : hour % 12),
                minute, second, (hour < 12 ? "AM" : "PM"));
    }
    public String secondsWithMeridiem(){
        return String.format(" %d:%02d:%02d %s",((hour == 0 || hour == 12) ? 12 : hour % 12),
        minute, second, (hour < 12 ? "AM" : "PM"));
    }
    public String displayTime(){
        if (timeFormat==3){
            if (meridiem.equals("AM")){
                return String.format(" %02d:%02d:%02d %s",((hour == 0 || hour == 12) ? 12 : hour % 12),
                        minute, second,"AM");
            } else if (meridiem.equals("PM")) {
                return String.format(" %d:%02d:%02d %s",((hour == 0 || hour == 12) ? 12 : hour % 12),
                        minute, second, "PM");
            }
            else {
                return "empty";
        }
        }
        return null;
    }
}