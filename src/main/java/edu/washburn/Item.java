package edu.washburn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* This not done and still has place holder code but this is a general outline 
* 
*/
public class Item {
    private String url;
    private String itemName;
    private boolean notify;
    private boolean percent;
    private Double goalPrice;
    private Double userPercent;
    private Double baseprice;

    public Item(){
        url="";
        notify=true;
        percent=false;
    }

    /**
     * 
     * @param url The URL of the Amazon item
     * @param notify Set true for for Notfcation Mode set false for buy mode
     * @param percent Set true if you are looking for a percentage discount keep false for specific price 
     * @param userNum Ether the price or percentage discount you are looking for depends on how you set the last flag
     */
    public Item(String url, boolean notify, boolean percent,Double userNum){
        this.url = url;
        this.notify=notify;
        this.percent = percent;
        try {
            setMetaData(url);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setGoalPrice(userNum);

    }

    /*
     * This will check if the percent Flag is set and set the correct varibe
     */
    private void setGoalPrice(double userNum){
        if(percent){
            this.goalPrice = baseprice - (baseprice*userNum); 
        }
        else{
            this.goalPrice=userNum;
        }

    }


    //TODO Fix parsing 
    private void setMetaData(String url) throws Exception{
        //opening a connection to the website
        URL obj = new URL(url); //could prob come up with a better name for this object
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //headers for the connection so it works
        con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:120.0) Gecko/20100101 Firefox/120." );

        int responseCode = con.getResponseCode();
        System.out.println("Response code: " + responseCode);

        //reads the website from buffer and builds the HTML
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        
        String html = response.toString();
        System.out.println(html); //so the HTML is corrupted
        String regex = "<span class=\"a-offscreen\">(.*?)</span>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        String capturedData = null;
        if (matcher.find()) {
            capturedData = matcher.group(1);
        }
        System.out.println("CapturedData: "+capturedData);
        this.baseprice=Double.parseDouble(capturedData);
    }
    

    // Getters and Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        try {
            setMetaData(url);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public boolean isPercent() {
        return percent;
    }

    public Double getGoalPrice() {
        return goalPrice;
    }

    public Double getUserPercent() {
        return userPercent;
    }

    public Double getBaseprice() {
        return baseprice;
    }

    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Item:" + itemName +"\n");
        sb.append("The URL is:" + url +"\n");
        sb.append("The base price is:" + baseprice +"\n");
        sb.append("The goal price is:" + goalPrice + "\n");
        sb.append("The current mode for this item is currently set to:");
        if (notify) {
            sb.append(" Notifcation mode");
        }else{
            sb.append(" Buy mode");
        }
        return sb.toString();
    }


}
