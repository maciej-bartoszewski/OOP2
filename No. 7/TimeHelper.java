import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TimeHelper {
    public LocalTime readTime(Scanner scanner) throws MyWrongTimeException{
        try {
            LocalDateTime currentDate = LocalDateTime.now();
            String input = scanner.nextLine();
            LocalTime userTime = LocalTime.parse(input);
            LocalDateTime userDateTime = LocalDateTime.of(currentDate.toLocalDate(), userTime);

            int result = currentDate.compareTo(userDateTime);
            if (result >= 0) {
                throw new MyWrongTimeException("The provided time is earlier or the same as the current one.");
            }

            return userTime;
        } catch (DateTimeParseException e){
            throw new MyWrongTimeException("Wrong format");
        }
    }
    public long calculateMillisToSleep(LocalTime currentTime, LocalTime desiredTime) {
        long currentMillis = currentTime.toNanoOfDay() / 1_000_000;
        long desiredMillis = desiredTime.toNanoOfDay() / 1_000_000;

        return desiredMillis - currentMillis;
    }
}
