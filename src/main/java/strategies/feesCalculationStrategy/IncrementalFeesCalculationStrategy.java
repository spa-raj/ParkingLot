package strategies.feesCalculationStrategy;

import models.Ticket;

import java.time.LocalDateTime;

public class IncrementalFeesCalculationStrategy implements  FeesCalculationStrategy {
    @Override
    public long calculateFees(Ticket ticket) {
        LocalDateTime startTime = ticket.getEntryTime();
        LocalDateTime endTime = LocalDateTime.now();
        long hours = java.time.Duration.between(startTime, endTime).toHours();
        long fees = 0;
        if(hours<=1){
            fees = 50;
        }
        else if(hours<=2){
            fees=50+60;
        }
        else if(hours<=3){
            fees=50+60+70;
        }
        else if(hours<=4){
            fees=50+60+70+80;
        }
        else if(hours<=5){
            fees=50+60+70+80+90;
        }
        else if(hours<=6){
            fees=50+60+70+80+90+100;
        }
        else if(hours<=7){
            fees=50+60+70+80+90+100+110;
        }
        else if(hours<=8){
            fees=50+60+70+80+90+100+110+120;
        }
        else{
            fees=50*hours;
        }
        return fees;
    }
}
