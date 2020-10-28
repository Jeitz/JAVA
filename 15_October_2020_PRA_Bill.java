import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int billId;
		String custName;
		int units;
		Scanner s = new Scanner(System.in);
		Bill[] bill = new Bill[5];
		for(int i=0;i<bill.length;i++) {
			billId = s.nextInt();s.nextLine();
			custName = s.nextLine();
			units = s.nextInt();
			bill[i] = new Bill(billId, custName, units);
		}
		double minBillAmnt = s.nextDouble();
		double maxBillAmnt = s.nextDouble();
		s.close();
		int noOfBills = findBillsInTheAmntRange(bill, minBillAmnt, maxBillAmnt);
		Bill b = getBillWithHighAmnt(bill);
		
		if(noOfBills == 0)
			System.out.println("No bills with given amount");
		else
			System.out.println(noOfBills);
		
		if(b == null)
			System.out.println("No bill object found");
		else
			System.out.println(b.getBillId()+" "+b.getCustName()+" "+b.getUnits());
	}
	public static int findBillsInTheAmntRange(Bill[] bills, double minAmnt, double maxAmnt) {
		double billAmnt = 0;int count = 0;
		for(int i=0;i<bills.length;i++) {
			if(bills[i].getUnits()>=1000)
				billAmnt = bills[i].getUnits() * 5;
			else if(bills[i].getUnits()>=500 && bills[i].getUnits()<1000)
				billAmnt = bills[i].getUnits() * 3;
			else if(bills[i].getUnits()<500)
				billAmnt = bills[i].getUnits() * 1;
			if(billAmnt >= minAmnt && billAmnt <= maxAmnt) count++;
		}
		return count;
	}
	public static Bill getBillWithHighAmnt(Bill[] bills) {
		int maxUnits=-999;
		for(int i=0;i<bills.length;i++) {
			if(bills[i].getUnits()>=maxUnits)
				maxUnits = bills[i].getUnits();
		}
		for(int i=0;i<bills.length;i++) {
			if(maxUnits == bills[i].getUnits())
				return bills[i];
		}
		return null;
	}
}
class Bill{
	int billId;
	String custName;
	int units;
	Bill(int billId, String custName, int units){
		this.billId = billId;
		this.custName = custName;
		this.units = units;
	}
	int getBillId() {
		return billId;
	}
	String getCustName() {
		return custName;
	}
	int getUnits() {
		return units;
	}
}
