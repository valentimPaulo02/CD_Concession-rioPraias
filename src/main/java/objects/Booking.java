package objects;

import java.io.Serializable;

public class Booking implements Serializable{
	
	private int Id;
	private int UserId;
	private String ServiceId;
	private String BeachId;
	private String Date;
	private int StartTime;
	private int EndingTime;
	
	
	public Booking(int Id, int UserId, String ServiceId, String BeachId, String Date, int StartTime, int EndingTime) {
		this.Id = Id;
		this.UserId = UserId;
		this.ServiceId = ServiceId;
		this.BeachId = BeachId;
		this.Date = Date;
		this.StartTime = StartTime;
		this.EndingTime = EndingTime;
	}
	public Booking(int Id, String ServiceId, String Date, int StartTime, int EndingTime) {
		this.Id = Id;
		this.ServiceId = ServiceId;
		this.Date = Date;
		this.StartTime = StartTime;
		this.EndingTime = EndingTime;
	}
	public Booking() {
		
	}
	
	
	public int getId() {
		return Id;
	}
	
	public int getUserId() {
		return UserId;
	}
	
	public String getServiceId() {
		return ServiceId;
	}
	
	public String getBeachId() {
		return BeachId;
	}
	
	public String getDate() {
		return Date;
	}
	
	public int getStartTime() {
		return StartTime;
	}
	
	public int getEndingTime() {
		return EndingTime;
	}
	
	
	public String BookingToString() {
		return "BookingId: "+Id+" | ServiceId: "+ServiceId+" | Date: "+Date+" | StartTime: "+StartTime+" | EndingTime: "+EndingTime;
	}
	

}
