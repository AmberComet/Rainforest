package edu.washburn;

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
            setMetaData();
        } catch (Exception e) {
            System.err.println("error no valid HTML returned");
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


    
    private void setMetaData(){
        Query query = new Query(url);
        this.baseprice = Double.parseDouble(query.getPrice());
        this.itemName = query.getItemName();
        
        
    }
    

    // Getters and Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        try {
            setMetaData();
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
