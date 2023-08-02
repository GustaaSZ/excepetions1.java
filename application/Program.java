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
        Date dateCheckin = sdf.parse(ler.next());

        System.out.print("Check-out Date (dd/MM/yyy): ");
        Date dateCheckout = sdf.parse(ler.next());

        if(!dateCheckout.after(dateCheckin)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, dateCheckin, dateCheckout);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");

            System.out.print("Check-in Date (dd/MM/yyy): ");
            dateCheckin = sdf.parse(ler.next());

            System.out.print("Check-out Date (dd/MM/yyy): ");
            dateCheckout = sdf.parse(ler.next());

            // Validação da data de att, onde as novas datas não podem ser menores que as já cadastradas anteriormente
            Date now = new Date();
            if(dateCheckin.before(now) || dateCheckout.before(now)){
                System.out.println("Reservation dates for update must be future dates");

            } else if(!dateCheckout.after(dateCheckout)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                // Att
                reservation.updateDates(dateCheckin, dateCheckout);
                System.out.println(reservation);
            }
            
        }

        ler.close();
    }
}
