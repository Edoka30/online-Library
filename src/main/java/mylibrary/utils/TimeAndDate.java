package mylibrary.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class TimeAndDate {
	
	public void findDuration() {
	// TODO Auto-generated method stub
	LocalDateTime startTime = LocalDateTime.now();
	// do some operation
	LocalDateTime endTime = LocalDateTime.now();
	
	
	Duration duration = Duration.between(startTime, endTime);
	if (duration.toMinutes() >= 60) {
	    // 60 minutes have passed
	} else {
	    // 60 minutes have not passed
	}
	System.out.println("Time Start"+startTime);
	System.out.println("End Start"+endTime);
	System.out.println("Duration"+duration);
	}
	public void futureDate() {
	Calendar c = Calendar.getInstance();

	c.setTime(new Date()); // Now use today date.

	c.add(Calendar.DATE, 15); // Adds 15 days
	
	System.out.println(c);
	
	Calendar cal = Calendar.getInstance();
	System.out.println("current date: " + cal.getTime());
	cal.add(Calendar.DATE, 10);
	
}

}
