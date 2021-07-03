package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SamsungProduct implements Comparable<SamsungProduct>{
    String productName;
    int productPrice;

    SamsungProduct(){}

    SamsungProduct(String productName, int productPrice){
        super();
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public int compareTo(SamsungProduct o) {
        int compareProductPrice = ((SamsungProduct) o).getProductPrice();
        return this.productPrice - compareProductPrice;
    }


}

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "samsung,'OEM Samsung Washing Machine Pulsator Washplate Cap Shipped With" +
                "WA48J7700AW, WA48J7700AW/A2, WA48J7700AW/AA',20916,samsung,'OEM Samsung" +
                "Chrome Washing Machine Washplate Pulsator Cap Shipped With WA52M7750AV," +
                "WA52M7750AV/A4, WA52M7750AW, WA52M7750AW/A4',91995,samsung, 'SAMSUNG" +
                "Washing Machine Spring Hanger, DC61-01257M', 22970,samsung,'Samsung DC97-17022B" +
                "Assy Detergent',32959,samsung,'Samsung DC66-00470A DAMPER" +
                "SHOCK',29981,samsung,'DC64-00519D Samsung Washing Machine Door Lock Washer Dryer" +
                "Dishwashe -MP#GH4498 349Y49HBRG9109150',52000,samsung,'Samsung DC97-16991A" +
                "Assembly Filter',13000";
        String[] arr = s.split(",");
        List<SamsungProduct> samsungProducts = new ArrayList<>();
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        String productName = "";
        int productPrice = 0;
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i].trim();
            if(arr[i].length() == 5){
                Matcher m  = p.matcher(arr[i]);
                if(m.matches()){
                    productPrice = Integer.parseInt(arr[i]);
                    samsungProducts.add(new SamsungProduct(productName,productPrice));
                    productName = "";
                    productPrice = 0;
                }
            }
            else{
                productName += arr[i]+", ";
            }
        }
        Collections.sort(samsungProducts);
        for(int i=0;i< samsungProducts.size();i++){
            System.out.println(samsungProducts.get(i).getProductName()+""+samsungProducts.get(i).getProductPrice());
        }
    }
}
