/* For question, please visit https://kingkrab.net/ira-03-nov-2020-xplore-answer-java/*/
import java.util.*;
public class Solution{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int theatreId, seatCapacity, theatreRating;
		String theatreName;
		double ticketRate;
		Theatre[] th = new Theatre[4];
		for(int i=0;i<th.length;i++) {
			theatreId = s.nextInt();s.nextLine();
			theatreName = s.nextLine();
			seatCapacity = s.nextInt();
			ticketRate = s.nextDouble();
			theatreRating = s.nextInt();
			th[i] = new Theatre(theatreId, theatreName, seatCapacity, ticketRate, theatreRating);
		}
		int getTheatreId = s.nextInt();
		s.close();
		String theatreCategory = findTheatreCategory(th, getTheatreId);
		Theatre t = findSecondHighestTicket(th);
		
		if(theatreCategory == null)
			System.out.println("There is no Theatre with the given theatreId");
		else
			System.out.println(theatreCategory);
		
		if(t == null)
			System.out.println("Only low rating theatres are available");
		else
			System.out.println(t.getTheatreName());
	}
	public static String findTheatreCategory(Theatre[] th, int theatreId) {
		String s=null;
		for(int i=0;i<th.length;i++) {
			if(theatreId == th[i].getTheatreId() ) {
				if(th[i].getSeatCapacity()>1000 && th[i].getTheatreRating()>=4)
					s = "Premium";
				else
					s = "Non Premium";
			}
		}
		return s;
	}
	public static Theatre findSecondHighestTicket(Theatre[] th) {
		int count = 0;
		for(int i=0;i<th.length;i++) {
			if(th[i].getTheatreRating()>=2) count++;
		}
		if(count == 0) return null;
		Theatre[] t = new Theatre[count];
		count = 0;
		for(int i=0;i<th.length;i++) {
			if(th[i].getTheatreRating()>=2)
				t[count++] = th[i];
		}
		for(int i=0;i<t.length;i++) {
			for(int j=i+1;j<t.length;j++) {
				if(t[i].getTicketRate() <= t[j].getTicketRate()) {
					Theatre temp = t[i];
					t[i] = t[j];
					t[j] = temp;
				}
			}
		}
		return t[1];
	}
}
class Theatre{
	int theatreId, seatCapacity, theatreRating;
	String theatreName;
	double ticketRate;
	Theatre(int theatreId, String theatreName, int seatCapacity, double ticketRate, int theatreRating){
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.seatCapacity = seatCapacity;
		this.ticketRate = ticketRate;
		this.theatreRating = theatreRating;
	}
	int getTheatreId() {
		return theatreId;
	}
	String getTheatreName() {
		return theatreName;
	}
	int getSeatCapacity() {
		return seatCapacity;
	}
	double getTicketRate() {
		return ticketRate;
	}
	int getTheatreRating() {
		return theatreRating;
	}
}
