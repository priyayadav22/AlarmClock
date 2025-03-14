import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        // HH:mm:ss is 24 hrs clock while hh:mm:ss is 12 hrs with am pm
        LocalTime alarmTime = null;
        String fileName = "AlarmCountDown.wav"; //java doesnt support mp3 file
        while (alarmTime == null) {
            try {
                System.out.println("Enter alarm time (HH:MM:SS): ");
                String time = sc.nextLine();
                alarmTime = LocalTime.parse(time, dtf);
                System.out.println("Alarm Set for: " + alarmTime);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format");
            }
        }
        AlarmClock alarmClock = new AlarmClock(alarmTime, fileName);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
        sc.close();
    }
}
