import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

/**
 * AlarmClock class that implements Runnable to run in a separate thread.
 * It waits until the specified alarm time and then plays a sound.
 */

public class AlarmClock implements Runnable {
    private final LocalTime alarmTime; //final to not allow it to chnage
    private final String fileName;

    AlarmClock(LocalTime alarmTime, String fileName) {
        this.alarmTime = alarmTime;
        this.fileName = fileName;
    } // constructor

    @Override
    public void run() {
        while (LocalTime.now().isBefore(alarmTime)) { //is the time right now is befor time
            LocalTime now = LocalTime.now();

            try {
                Thread.sleep(1000);
                //System.out.println(hours + ":" + minutes + ":" + seconds);
                System.out.printf("\r%02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond()); // \r is used to get the cursor at same place. i dont want to print 1000 lines of data as time chanegs evry second
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread was interrupted due to " + e);
            }
        }
        System.out.println("Alarm Noises");
//        Toolkit.getDefaultToolkit().beep(); //to play beeep in java
        playsound(fileName);
    }

    private void playsound(String fileName) {
        File file = new File(fileName);
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(10000); // yha hmne time define krdiya ki itni der alarm bjade ..tbb tkk thread sleep mode me jayega or clip puri,
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            System.out.println("Audio file is not supported");
        } catch (LineUnavailableException e) {
            System.out.println("Line unavailable");
        } catch (IOException e) {
            System.out.println("IO exception: Error Reading file");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
