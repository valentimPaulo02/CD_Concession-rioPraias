package objects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Booking")
public class Booking implements Serializable{
	
	private int Id;
	private int UserId;
	private String ServiceId;
	private String BeachId;
	private String Date;
	private int StartTime;
	private int EndingTime;
	
	//used for RESERVAR_SOMBRINHA
	public Booking(int UserId, String ServiceId, String BeachId, String Date, int StartTime, int EndingTime) {
		this.UserId = UserId;
		this.ServiceId = ServiceId;
		this.BeachId = BeachId;
		this.Date = Date;
		this.StartTime = StartTime;
		this.EndingTime = EndingTime;
	}
	//used for return of LISTAR_RESERVAS
	public Booking(int Id, String ServiceId, String Date, int StartTime, int EndingTime) {
		this.Id = Id;
		this.ServiceId = ServiceId;
		this.Date = Date;
		this.StartTime = StartTime;
		this.EndingTime = EndingTime;
	}
	//used for LISTAR_SOMBRINHAS
	public Booking (String BeachId, String Date, int StartTime, int EndingTime) {
		this.BeachId = BeachId;
		this.Date = Date;
		this.StartTime = StartTime;
		this.EndingTime = EndingTime;
	}
	//Used for CANCELAR_RESERVA
	public Booking(int Id) {
		this.Id = Id;
	}
	public Booking() {
		
	}
	
	
	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int UserId) {
		this.UserId = UserId;
	}

	public String getServiceId() {
		return ServiceId;
	}

	public void setServiceId(String ServiceId) {
		this.ServiceId = ServiceId;
	}

	public String getBeachId() {
		return BeachId;
	}

	public void setBeachId(String BeachId) {
		this.BeachId = BeachId;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	public int getStartTime() {
		return StartTime;
	}

	public void setStartTime(int StartTime) {
		this.StartTime = StartTime;
	}

	public int getEndingTime() {
		return EndingTime;
	}

	public void setEndingTime(int EndingTime) {
		this.EndingTime = EndingTime;
	}
	
	public String toString() {
		return "BookingId: "+Id+" | ServiceId: "+ServiceId+" | Date: "+Date+" | StartTime: "+StartTime+" | EndingTime: "+EndingTime;
	}
	

}
