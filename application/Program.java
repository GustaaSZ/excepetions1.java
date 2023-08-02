package exceptions.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptions.model.entities.Reservation;
import exceptions.model.exception.DomainException;

public class Program {
    
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            // Leitura dos primeiros dados
            System.out.print("Input the number of room: ");
            Integer roomNumber = ler.nextInt();
            System.out.print("Check-in Date (dd/MM/yyy): ");
            Date checkin = sdf.parse(ler.next());
            System.out.print("Check-out Date (dd/MM/yyy): ");
            Date checkout = sdf.parse(ler.next());

            // Instância do obj reserva, passando os dados lidos
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println(reservation);

            // Leitura dos dados de att da reserva
            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in Date (dd/MM/yyy): ");
            checkin = sdf.parse(ler.next());
            System.out.print("Check-out Date (dd/MM/yyy): ");
            checkout = sdf.parse(ler.next());

            // Att
            reservation.updateDates(checkin, checkout);
            System.out.println("\n---- Reservation ----"+reservation);

        } // Trata a exception da leitura do sdf.parse()
        catch(ParseException e){
            System.out.println("Invalid date format!");

        } // Trata as exceções lançadas pela classe reservation
        catch(DomainException e){
            System.out.println("Error in reservation: "+e.getMessage());
        } 
        catch (Exception e){
            System.out.println("Unexpected Error");
        }
        ler.close();
    }
}
