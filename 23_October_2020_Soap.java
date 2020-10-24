import java.util.*;
public class Solution {
	public static void main(String[] args) {
		int soapId;
		String soapName;
		String brand;
		double price;
		boolean isGlycerin;
		Soap[] soap = new Soap[4];
		Scanner s = new Scanner(System.in);
		for(int i=0;i<soap.length;i++) {
			soapId = s.nextInt();s.nextLine();
			soapName = s.nextLine();
			brand = s.nextLine();
			price = s.nextDouble();
			isGlycerin = s.nextBoolean();
			soap[i] = new Soap(soapId, soapName, brand, price, isGlycerin);
		}
		s.nextLine();
		String getBrand = s.nextLine();
		double minPrice = s.nextDouble();
		double maxPrice = s.nextDouble();
		Soap sp = getMaxPricedSoapByBrand(soap, getBrand);
		Soap[] ss = getGlycerinSoapsByPriceRange(soap, minPrice, maxPrice);

		if(sp == null)
			System.out.println("There are no Soaps with given brand");
		else {
			System.out.println(sp.getSoapId()+"#"+sp.getSoapName()+"#"+sp.getBrand()+"#"+sp.getPrice());
		}
		for(int i=0;i<ss.length;i++) {
			System.out.println(ss[i].getSoapId()+"-"+ss[i].getSoapName()+"-"+ss[i].getPrice());
		}
	}
	public static Soap getMaxPricedSoapByBrand(Soap[] soapArr, String brand)
	  {
	   //method logic
		double maxPrice = 0;
		Soap soap = new Soap();
		for(int i=0;i<soapArr.length;i++) {
			for(int j=0;j<soapArr.length;j++) {
				if(soapArr[i].getPrice()<=soapArr[i].getPrice()) {
					Soap temp = soapArr[i];
					soapArr[i] = soapArr[j];
					soapArr[j] = temp;
				}
			}
		}
		for(int i=0;i<soapArr.length;i++) {
			if(brand.equalsIgnoreCase(soapArr[i].getBrand()))
				return soapArr[i];
		}
		return null;
	  }
	public static Soap[] getGlycerinSoapsByPriceRange(Soap[] soapArr, double minPrice, double maxPrice)
	  {
	   //method logic
		int count = 0;
		for(int i=0;i<soapArr.length;i++) {
			if(soapArr[i].getIsGlycerin()==true && soapArr[i].getPrice()>=minPrice && soapArr[i].getPrice()<=maxPrice)
				count++;
		}
		if(count == 0) return null;
		Soap[] soap = new Soap[count];
		count = 0;
		for(int i=0;i<soapArr.length;i++) {
			if(soapArr[i].getIsGlycerin()==true && soapArr[i].getPrice()>=minPrice && soapArr[i].getPrice()<=maxPrice) {
				soap[count++] = soapArr[i];
			}
		}
		for(int i=0;i<soap.length;i++) {
			for(int j=0;j<soap.length;j++) {
				if(soap[i].getPrice()<=soap[i].getPrice()) {
					Soap temp = soap[i];
					soap[i] = soap[j];
					soap[j] = temp;
				}
			}
		}
		return soap;
	  }
}

class Soap{
	int soapId;
	String soapName;
	String brand;
	double price;
	boolean isGlycerin;
	Soap(){}
	Soap(int soapId, String soapName, String brand, double price, boolean isGlycerin){
		this.soapId = soapId;
		this.soapName = soapName;
		this.brand = brand;
		this.price = price;
		this.isGlycerin = isGlycerin;
	}
	int getSoapId() {
		return soapId;
	}
	String getSoapName() {
		return soapName;
	}
	String getBrand() {
		return brand;
	}
	double getPrice() {
		return price;
	}
	boolean getIsGlycerin() {
		return isGlycerin;
	}
}
