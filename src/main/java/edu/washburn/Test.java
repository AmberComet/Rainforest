package edu.washburn;

public class Test {
    public static void main(String[] args) {
        String url = "https://www.amazon.com/ELEGOO-Mars-Max-Monochrome-7-71x4-81x5-9/dp/B0BYSYBB91/?_encoding=UTF8&ref_=pd_gw_deals_m1_t1&th=1";
        System.out.println("testing item class");

        Item test = new Item(url, true, false, 267.99); //Getting Null pointer exception here why?

        System.out.println(test.toString());
    }
}