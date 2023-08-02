package exceptions.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptions.model.entities.Reservation;

public class Program {
    
    public static void main(String[] args) throws ParseException{

        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Input the number of room: ");
        Integer roomNumber = ler.nextInt();

        System.out.print("Check-in Date (dd/MM/yyy): ");
        Date checkin = sdf.parse(ler.next());

        System.out.print("Check-out Date (dd/MM/yyy): ");
        Date checkout = sdf.parse(ler.next());

        if(!checkout.after(checkin)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");

            System.out.print("Check-in Date (dd/MM/yyy): ");
            checkin = sdf.parse(ler.next());

            System.out.print("Check-out Date (dd/MM/yyy): ");
            checkout = sdf.parse(ler.next());

            // Att
            String error = reservation.updateDates(checkin, checkout);
            
            if(error != null){
                System.out.println("Error in reservation: "+error);
            } else {
                System.out.println("\n---- Reservation ----"+reservation);
            }
            
        }

        ler.close();
    }
}
