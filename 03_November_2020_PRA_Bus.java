import java.util.*;
public class Solution{

     public static void main(String []args){
        Scanner s = new Scanner(System.in);
        Bus[] bus = new Bus[4];
        String busNo, fromStation, toStation;
        double ticketCost;
        for(int i=0;i<bus.length;i++){
            busNo = s.nextLine();
            fromStation = s.nextLine();
            toStation = s.nextLine();
            ticketCost = s.nextDouble();s.nextLine();
            bus[i] = new Bus(busNo, fromStation, toStation, ticketCost);
        }
        String getFromStation = s.nextLine();
        String getToStation = s.nextLine();
        s.close();
        Bus b = getBus(bus, getFromStation, getToStation);
        double cost = getSumOfMinMaxTicketCost(bus);
         if(cost>0)
            System.out.println(cost);
        else
            System.out.println("Travel is free of cost");
            
         if(b==null)
            System.out.println("No Bus found");                
        else
            System.out.println(b.getBusNo());
        
     }
     public static Bus getBus(Bus[] bus, String fromStation, String toStation){
         for(int i=0;i<bus.length;i++){
             if(fromStation.equalsIgnoreCase(bus[i].getFromStation()) && toStation.equalsIgnoreCase(bus[i].getToStation()))
                return bus[i];
         }
         return null;
     }
     public static double getSumOfMinMaxTicketCost(Bus[] bus){
         double minCost = 9999999, maxCost = -9999999;
         for(int i=0;i<bus.length;i++){
             if(bus[i].getTicketCost() <= minCost)
                minCost = bus[i].getTicketCost();
            if(bus[i].getTicketCost() >= maxCost)
                maxCost = bus[i].getTicketCost();
         }
         return minCost+maxCost;
     }
}
class Bus{
    String busNo, fromStation, toStation;
    double ticketCost;
    Bus(String busNo, String fromStation, String toStation, double ticketCost){
        this.busNo = busNo;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.ticketCost = ticketCost;
    }
    String getBusNo(){
        return busNo;
    }
    String getFromStation(){
        return fromStation;
    }
    String getToStation(){
        return toStation;
    }
    double getTicketCost(){
        return ticketCost;
    }
}
