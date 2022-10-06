package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	
	public Date getCheckout() {
		return checkout;
	}

	// jeito padrão de calcular data no java(calculo em milisegundo)
	public long duration() {
		long diff =  (checkin.getTime() - checkout.getTime()) *-1;
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkin, Date checkout) {
		
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		 if(!checkout.after(checkin)) {
			return "Erro in reservation: Check-out date must be after check-in date";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}

	@Override
	public String toString() {
		// padrão pra formatar a data sair como solicitada // chamanos o metodo no to String tb
		return "Room"
				+ roomNumber
				+ ", Check-in: "
				+ sdf.format(checkin)
				+ ", Chek-out: "
				+ sdf.format(checkout)
				+ " , "
				+ duration()
				+ " nigths"
				;
	}

}
