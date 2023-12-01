package edu.washburn;

/* This not done and still has place holder code but this is a general outline 
* 
*/
public class Item {
    private String url;
    private String asin;
    private String sku;
    private String itemName;
    private boolean notify;
    private boolean percent;
    private Double goalPrice;
    private Double userPercent;
    private Double baseprice;

    public Item(){
        itemName="";
        url="";
        notify=true;
        percent=false;
    }

    /**
     * 
     * @param url The URL of the Amazon item
     * @param itemName The Name of the Item
     * @param notify Set true for for Notfcation Mode set false for buy mode
     * @param percent Set true if you are looking for a percentage discount keep false for specific price 
     * @param userNum Ether the price or percentage discount you are looking for depends on how you set the last flag
     */
    public Item(String url,String itemName, boolean notify, boolean percent,Double userNum){
        this.url = url;
        this.itemName = itemName;
        this.notify=notify;
        this.percent = percent;
        setMetaData(url);
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


    //TODO actually write the code this does the shit
    private void setMetaData(String url){
        
    }

    // Getters and Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        setMetaData(url);
    }

    public String getAsin() {
        return asin;
    }


    public String getSku() {
        return sku;
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

    



}
