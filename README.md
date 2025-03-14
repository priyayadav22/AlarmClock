# ⏰ Java Alarm Clock

## *Overview*

This is a simple Java-based Alarm Clock that allows users to set an alarm time in the 24-hour format (HH:mm:ss). When the alarm time is reached, the program plays a sound and displays a notification.

---

## *Features*  

✅ Allows users to input the alarm time in HH:mm:ss format.  
✅ Continuously updates the current time display without printing multiple lines (uses \r for inline updates).  
✅ Plays an alarm sound when the set time is reached.  
✅ Uses multithreading to keep the main thread responsive while waiting for the alarm.  

---

## *How It Works*  

1. *User Input:* The user enters an alarm time in 24-hour format.  
2. *Separate Thread:* The program starts a separate thread to monitor the current time.  
3. *Real-Time Update:* The current time updates in-place every second.  
4. *Alarm Trigger:* When the alarm time matches the system time:  
   - ✅ Plays a sound (WAV format supported).  
   - ✅ Displays a notification.  

---

## *Technologies Used*  

- *Java 8+* – For LocalTime and DateTimeFormatter API.  
- *Java Sound API* – For playing the alarm sound.  
- *Multithreading* – To run the alarm logic without blocking the main thread.  

---

## *Prerequisites*  

- Java 8 or higher installed.
