package exceptions.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions.model.exception.DomainException;

public class Reservation {
    
    // Atributos
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

    // Constructors
    public Reservation(){}

    public Reservation(Integer rooNumber, Date checkin, Date checkout) throws DomainException {

        // Tratando a exceção de checagem da data logo no construtor
        if(!checkout.after(checkin)){
            throw new DomainException ("Error in reservation: Check-out date must be after check-in date");
        }

        this.roomNumber = rooNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    // Getters and Setters
    public Integer getRooNumber() {
        return roomNumber;
    }
    public void setRooNumber(Integer rooNumber) {
        this.roomNumber = rooNumber;
    }
    public Date getCheckin() {
        return checkin;
    }
    public Date getCheckout() {
        return checkout;
    }
   

    // Methods
    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    // Método que pode lançar uma exceção
    public void updateDates(Date checkin, Date checkout) throws DomainException{

        // Validação da data de att, onde as novas datas não podem ser menores que as já cadastradas anteriormente
        // Date now = new Date();
        if(checkin.before(this.checkin) || checkout.before(this.checkout)){
            throw new DomainException ("Error in reservation: Reservation dates for update must be future dates");
        } 
        if(!checkout.after(checkin)){
            throw new DomainException ("Error in reservation: Check-out date must be after check-in date");
        }
        // Atualização
        this.checkin = checkin;
        this.checkout = checkout;
    }

    
    // ToString
    @Override
    public String toString(){
        return "\nRoom: "+roomNumber+"\nCheck-in: "+sdf1.format(checkin)+"\nCheck-out: "+sdf1.format(checkout)+"\nTime: "+duration()+" days\n";
    }

}
