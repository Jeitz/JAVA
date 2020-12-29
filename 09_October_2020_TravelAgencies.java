/* For question, please visit kingkrab.net */ 
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

 public static void main(String[] args)
 {
  //code to read values 
  //code to call required method
  //code to display the result
  int regNo;
  String agencyName;
  String packageType;
  int price;
  int rating;
  String location;
  Scanner s = new Scanner(System.in);
  TravelAgencies[] ta = new TravelAgencies[4];
  for(int i=0;i<ta.length;i++){
      regNo = s.nextInt();s.nextLine();
      agencyName = s.nextLine();
      packageType = s.nextLine();
      price = s.nextInt();
      rating = s.nextInt();s.nextLine();
      location = s.nextLine();
      ta[i] = new TravelAgencies(regNo, agencyName, packageType, price, rating, location);
  }
  String getPackageType = s.nextLine();
    String getLocation = s.nextLine();
  int highestPrice = findAgencyWithHighestPackagePrice(ta, getLocation);
  TravelAgencies[] agencies = sortedAgencyDetailsByPckg(ta, getPackageType);
  
  if(highestPrice == 0)
        System.out.println("No agencies in the given location");
    else
        System.out.println(highestPrice);

    if(agencies == null)
        System.out.println("No such agencies with the given packageType");
    else{
        for(int i=0;i<agencies.length;i++){
            System.out.println(agencies[i].getAgencyName());
        }
    }
 }

public static int findAgencyWithHighestPackagePrice(TravelAgencies[] agencies, String location)
  {
   //method logic
   int highestPrice = 0;
   for(int i=0;i<agencies.length;i++){
       if(location.equalsIgnoreCase(agencies[i].getLocation())){
           if(agencies[i].getPrice()>=highestPrice){
               highestPrice = agencies[i].getPrice();
           }
       }
   }
   return highestPrice;
  }
public static TravelAgencies[] sortedAgencyDetailsByPckg(TravelAgencies[] agencies, String packageType)
  {
   //method logic
   int count = 0;
   for(int i=0;i<agencies.length;i++){
       if(packageType.equalsIgnoreCase(agencies[i].getPackageType()))
            count++;
   }
   if(count == 0)
    return null;
   TravelAgencies[] ta = new TravelAgencies[count];
   count = 0;
   for(int i=0;i<agencies.length;i++){
       if(packageType.equalsIgnoreCase(agencies[i].getPackageType())){
           ta[count++] = agencies[i];
       }
   }
   for(int i=0;i<ta.length;i++){
       for(int j=i+1;j<ta.length;j++){
           if(ta[i].getRating()>=ta[j].getRating()){
               TravelAgencies temp = ta[i];
               ta[i] = ta[j];
               ta[j] = temp;
           }
       }
   }
   return ta;
  }
}
class TravelAgencies
{
  //code to build the class
  int regNo;
  String agencyName;
  String packageType;
  int price;
  int rating;
  String location;
  TravelAgencies(int regNo, String agencyName, String packageType, int price, int rating, String location){
      this.regNo = regNo;
      this.agencyName = agencyName;
      this.packageType = packageType;
      this.price = price;
      this.rating = rating;
      this.location = location;
  }
  int getRegNo(){
      return regNo;
  }
  String getAgencyName(){
      return agencyName;
  }
  String getPackageType(){
      return packageType;
  }
  int getPrice(){
      return price;
  }
  int getRating(){
      return rating;
  }
  String getLocation(){
      return location;
  }
}
