package Interview.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Java8Dates {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("Today's Local date : " + today);
        LocalDate dateOfBirth = LocalDate.of(1980, 01, 12);
        System.out.println("Your Date of birth is : " + dateOfBirth);

        //comparing two dates
        LocalDate date1 = LocalDate.of(2021, 10, 07);
        if(date1.equals(today)){
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        }

        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);

        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);

        LocalDateTime arrivalDate  = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM yyyy dd hh:mm a");
        String landing = arrivalDate.format(format);
        System.out.printf("Arriving at :  %s %n", landing);
    }
}
