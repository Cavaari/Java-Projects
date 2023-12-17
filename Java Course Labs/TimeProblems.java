import java.time.*;

public class TimeProblems {
    
    public static int countFridayThirteens(LocalDate start, LocalDate end){
        int fCount = 0;

        for(LocalDate i = start; !i.isAfter(end) ; i = i.plusDays(1)){
            if(i.getDayOfWeek() == DayOfWeek.FRIDAY && i.getDayOfMonth() == 13){
                fCount++;
            }  
        }
        return fCount;
    }

    public static int whatHourIsItThere(LocalDateTime timeHere, String here, String there){
        ZonedDateTime current = timeHere.atZone(ZoneId.of(here));
        ZonedDateTime abroad = current.withZoneSameInstant(ZoneId.of(there));

        return abroad.getHour();
    }

    public static String dayAfterSeconds(LocalDateTime now, long seconds) {
        LocalDateTime forwardInTime = now.plusSeconds(seconds);
        return forwardInTime.getDayOfWeek().name();
    }
}
