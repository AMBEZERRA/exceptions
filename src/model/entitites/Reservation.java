package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainExceptions{
		if(!checkout.after(checkin)) {
			 throw new DomainExceptions("Erro in reservation: Check-out date must be after check-in date");
		}
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
	
	public void updateDates(Date checkin, Date checkout) throws DomainExceptions {
		
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainExceptions("Error in reservation: Reservation dates for update must be future dates");
		}
		 if(!checkout.after(checkin)) {
			 throw new DomainExceptions("Erro in reservation: Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
		
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
