package application;
import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.nextLine(), formatter);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.nextLine(), formatter);

        if (!checkOut.isAfter(checkIn)){
            System.out.print("Error! Check-out date must be after check-in date.");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter date do update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.nextLine(), formatter);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.nextLine(), formatter);
            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

        }
        sc.close();
    }
}