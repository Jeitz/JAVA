//Program 1
/* For Question to this program, please visit https://kingkrab.net/ipa-26-jan-2021-xplore-answer-java/ */
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        s.close();
        int tempVariable = number;
        int sum = 0;
        while(tempVariable > 0){
            int remainder = tempVariable % 10;
            sum += remainder;
            tempVariable /= 10;
        }
        if(sum % 2 == 0 && number % 3 == 0)
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
    }
}

//Program 2
/* For Question to this program, please visit https://kingkrab.net/ipa-26-jan-2021-xplore-answer-java/ */

import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int panId;
        String panBrand;
        String panType;
        int capacity;
        String material;
        double price;
        Pan[] pans = new Pan[5];
        for(int i=0; i<pans.length; i++){
            panId = s.nextInt();s.nextLine();
            panBrand = s.nextLine();
            panType = s.nextLine();
            capacity = s.nextInt();s.nextLine();
            material = s.nextLine();
            price = s.nextDouble();
            pans[i] = new Pan(panId, panBrand, panType, capacity, material, price);
        }
        s.nextLine();
        String newMaterialValue = s.nextLine();
        String newPanBrandValue = s.nextLine();
        s.close();

        Pan costliestBasedOnMaterial = getCostliestBasedOnMaterial(newMaterialValue, pans);
        if(costliestBasedOnMaterial == null)
            System.out.println("Pans are not available for the given material");
        else {
            System.out.println(costliestBasedOnMaterial.getPanBrand());
            System.out.println(costliestBasedOnMaterial.getPrice());
        }

        double getDiscountPriceValue = getDiscountedPrice(pans, newPanBrandValue);
        if(getDiscountPriceValue == 0)
            System.out.println("There is no matching pans with the given brand.");
        else
            System.out.println(getDiscountPriceValue);
    }

    public static Pan getCostliestBasedOnMaterial(String material, Pan[] pans){
        int count = 0;
        for(int i=0; i<pans.length; i++){
            if(material.equalsIgnoreCase(pans[i].getMaterial()))
                count++;
        }
        if(count == 0) return null;
        Pan[] pans1 = new Pan[count];
        count = 0;
        for(int i=0; i<pans.length; i++){
            if(material.equalsIgnoreCase(pans[i].getMaterial()))
                pans1[count++] = pans[i];
        }
        double maxPrice = pans1[0].getPrice();
        for(int i=0; i< pans1.length; i++){
            if(pans1[i].getPrice() > maxPrice)
                maxPrice = pans1[i].getPrice();
        }
        for(int i=0; i< pans1.length; i++){
            if(pans1[i].getPrice() == maxPrice)
                return pans1[i];
        }
        return null;
    }

    public static double getDiscountedPrice(Pan[] pans, String panBrand){
        double discountValue = 0;
        for(int i=0; i< pans.length; i++){
            if(panBrand.equalsIgnoreCase(pans[i].getPanBrand())) {
                if(pans[i].getPrice() == 500)
                    discountValue = pans[i].getPrice()-(pans[i].getPrice()*20)/100;
                else if(pans[i].getPrice() == 1000)
                    discountValue = pans[i].getPrice()-(pans[i].getPrice()*26)/100;
                else if(pans[i].getPrice() == 1500)
                    discountValue = pans[i].getPrice()-(pans[i].getPrice()*24)/100;
                pans[i].setPrice(discountValue);
                discountValue = pans[i].getPrice();
            }
        }
        return discountValue;
    }
}

class Pan{
    private int panId;
    private String panBrand;
    private String panType;
    private int capacity;
    private String material;
    private double price;
    public Pan(int panId, String panBrand, String panType, int capacity, String material, double price){
        this.panId = panId;
        this.panBrand = panBrand;
        this.panType = panType;
        this.capacity = capacity;
        this.material = material;
        this.price = price;
    }
    public int getPanId(){
        return panId;
    }
    public String getPanBrand(){
        return panBrand;
    }
    /*public String getPanType(){
        return panType;
    }
    public int getCapacity(){
        return capacity;
    }*/
    public String getMaterial(){
        return material;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
}
