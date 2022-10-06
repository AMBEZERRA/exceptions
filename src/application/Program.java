package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy)");
		Date checkin = sdf.parse(sc.next()); // aqui como pode dar erro ele pede throws ParseException
		System.out.print("Check-out date (dd/MM/yyyy)");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Erro in reservation: Check-out date must be after check-in date");

		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to uptade the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy)");
			checkin = sdf.parse(sc.next()); // aqui como pode dar erro ele pede throws ParseException
			System.out.print("Check-out date (dd/MM/yyyy)");
			checkout = sdf.parse(sc.next());

			// criei uma string erro para receber o metodo update que retorna uma Sting tb
			// caso retorne null ele faz o uptade.
			// case retorne diferente de null ele informará o erro estabelecido no método
			String erro = reservation.updateDates(checkin, checkout);
			if (erro != null) {
				System.out.println("Erro in reservation:" + erro);
			} else {
				System.out.println("Reservation: " + reservation);
			}

		}

		sc.close();
	}

}
