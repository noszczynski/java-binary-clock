import java.time.LocalTime;

public class Hour {

	LocalTime localTime;
	private String hoursStr;
	private String minutesStr;
	private String secondsStr;
	private int hours;
	private int minutes;
	private int seconds;

	public Hour() {
		super();
		this.localTime = LocalTime.now();

		this.hours = Integer.parseInt(Integer.toBinaryString(localTime.getHour()));
		this.minutes = Integer.parseInt(Integer.toBinaryString(localTime.getMinute()));
		this.seconds = Integer.parseInt(Integer.toBinaryString(localTime.getSecond()));

		this.hoursStr = Integer.toBinaryString(localTime.getHour());
		this.minutesStr = Integer.toBinaryString(localTime.getMinute());
		this.secondsStr = Integer.toBinaryString(localTime.getSecond());
	}

	public void tick() {

		this.localTime = LocalTime.now();

		this.hours = Integer.parseInt(Integer.toBinaryString(localTime.getHour()));
		this.minutes = Integer.parseInt(Integer.toBinaryString(localTime.getMinute()));
		this.seconds = Integer.parseInt(Integer.toBinaryString(localTime.getSecond()));

		this.hoursStr = Integer.toBinaryString(localTime.getHour());
		this.minutesStr = Integer.toBinaryString(localTime.getMinute());
		this.secondsStr = Integer.toBinaryString(localTime.getSecond());

	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	public String getHoursStr() {
		return hoursStr;
	}

	public String getMinutesStr() {
		return minutesStr;
	}

	public String getSecondsStr() {
		return secondsStr;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

}
