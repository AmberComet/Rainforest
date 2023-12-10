package edu.washburn;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Query {
    private String url;
    private String html;
    private String currentPrice;
    private String itemName;

    public Query(){
        url ="";
    }

    public Query(String url){
        this.url = url;
        captureDataFromFile();
        /*try {
        *    scrapeSite();
        *} catch (IOException e) {
        *    // TODO Auto-generated catch block
        *    e.printStackTrace();
       }*/
        captureData();
    }

    //TODO this doesnt work
    private void scrapeSite() throws IOException{ 
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

        this.html = response.toString();
        
    }
    public void captureDataFromFile(){
        String html ="";
        try{
           File htmlFile = new File("TestHTML.html");
           Scanner scan = new Scanner(htmlFile);
           while(scan.hasNextLine()){
                html+= scan.nextLine();
           }
           this.html=html;
        }catch(Exception e ){
            System.err.println("file not found");
        }
    }

    private void captureData(){
        String regex = "<span class=\"a-offscreen\">(.*?)</span>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        String capturedData = null;
        if (matcher.find()) {
            capturedData = matcher.group(1);
        }
        System.out.println("CapturedData: "+capturedData);
        this.currentPrice=capturedData;

        //TODO add code that captures the item name
    }

    public String getPrice(){
        return currentPrice;
    }

    public String getItemName(){
        return itemName;
    }


    public void dumpHTML(){
        System.out.println(html);
    }

}
