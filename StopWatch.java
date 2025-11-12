import java.util.Calendar;

/**
 * Write a description of class StopWatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StopWatch
{
    private boolean isInReset;
    private long initialTime;
    private long currentTime;

    public StopWatch()
    {
        reset();
    }

    public void reset()
    {
        isInReset = true;
        initialTime = 0;
        currentTime = 0;
    }

    public void set(long seconds){
	currentTime = Calendar.getInstance().getTimeInMillis();
        initialTime = currentTime - (seconds*1000);
    }
    
    public void startStop()
    {
        currentTime = Calendar.getInstance().getTimeInMillis();
        if (isInReset){
            initialTime = currentTime;
            isInReset = false;
        }
    }

    public long elapsedTime()
    {
        return currentTime-initialTime;
    }

    public String toString()
    {
        long elapsedSecs = elapsedTime()/1000;
        long elapsedHours = elapsedSecs/3600;
        elapsedSecs -= (elapsedHours*3600);
        long elapsedMins = elapsedSecs/60;
        elapsedSecs -= (elapsedMins*60);
        return elapsedHours + "h " + elapsedMins + "m " + elapsedSecs + "s";
    }
}
