/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jablonskib.pollbot;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 *
 * @author jablo
 */
public class Poll {
    private String pollQuestion;
    private String sender;
    private boolean isActive;
    private int yes;
    private int no;
    private String uuid;
    private DecimalFormat df = new DecimalFormat();

    public Poll(String pq, String s, boolean a){
        pq = pollQuestion;
        sender = s;
        isActive = a;
        yes = 0;
        no = 0;     
        uuid = UUID.randomUUID().toString();
        df.setMaximumFractionDigits(2);
    }
    
    public void setPollQuestion(String pollQuestion) {
        this.pollQuestion = pollQuestion;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void addYes() {
        yes+=1;
    }

    public void addNo() {
        no+=1;
    }
    
    public String getYes(){
        return Integer.toString(yes);
    }
    public String getNo(){
        return Integer.toString(no);
    }
    
    public String getTotalVotes(){
        return Integer.toString(yes+no);
    }
    public int totalVotes(){
        return yes + no;
    }
    
    public String getPercentageYes(){
        
        
        if(yes != 0){
           float result = (((float)yes/totalVotes()) *100);
           String tResult = df.format(result);
            
           return tResult + "%";
        }
        else{
            return "0%";
        } 

    }
    
    public String getPercentageNo(){
        if(no != 0){
            float result = (((float)no/totalVotes()) *100);
            String tResult = df.format(result);
            
            return tResult + "%";
        }
        else{
            return "0%";
        } 
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
   
    

    public String getUuid() {
        return uuid;
    }

    public String getPollQuestion() {
        return pollQuestion;
    }

    public String getSender() {
        return sender;
    }

    public boolean isActive() {
        return isActive;
    }


   
}
