package exceptions.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    
    // Atributos
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    
    // Constructors
    public Reservation(){}

    public Reservation(Integer rooNumber, Date checkin, Date checkout) {
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

    public void updateDates(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    
    // ToString
    @Override
    public String toString(){
        return "\nRoom: "+roomNumber+"\nCheck-in: "+sdf1.format(checkin)+"\nCheck-out: "+sdf1.format(checkout)+"\nTime: "+duration()+" days\n";
    }

}
