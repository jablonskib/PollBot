/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jablonskib.pollbot;

import java.util.ArrayList;
import java.util.List;
import org.jibble.pircbot.PircBot;

/**
 *
 * @author jablo
 */
public class Bot extends PircBot{
    
    
    private List<Poll> polls = new ArrayList<Poll>();
    private String channel;
    private String currentPollUUID;
            
    public Bot(String c){
        channel = c;
        sendMessage(channel, "I'm pollbot. I do exactly what you'd think I do.");
    }
    
    public void onMessage(String channel, String sender, String login, String hostname,
            String message){
        
        if(message.contains("!poll set")){
            String[] pollQuestion = message.split("(?<=set)");
            System.out.println(Integer.toString(pollQuestion.length));
            for(int i = 0; i < pollQuestion.length; i++){
                System.out.println(pollQuestion[i]);
            }
            
            if(polls.size() > 0){
                for(Poll p : polls){
                    if(p.isActive()){
                        p.setIsActive(false);
                    }
                }
            }
            String question = pollQuestion[1];
            polls.add(new Poll(question, sender, true));
            currentPollUUID = polls.get(polls.size()-1 ).getUuid();
            sendMessage(channel, "The poll question: " + question + " has been"
                    + " set, with the UUID of " + currentPollUUID);
                    
        }
        else if(message.contains("!pv"))
        {
            String[] voteString = message.split("(?<=!pv)");
            String vote = voteString[1];
            System.out.println(vote);
            
            for(int i = 0; i < polls.size(); i++){
                if(polls.get(i).isActive()){
                    if(vote.contains("yes")){
                        polls.get(i).addYes(); 
                        System.out.println(polls.get(i).getYes());
                    }
                    
                    if(vote.contains("no")){
                        polls.get(i).addNo();
                    }
                }
            }
        }
        else if(message.contains("!poll result")){
          
            for(int i = 0; i < polls.size(); i++){
                if(polls.get(i).isActive()){
                   String result = "Poll Results: Q: " + polls.get(i).getPollQuestion() + " Y: " + 
                    polls.get(i).getPercentageYes() + " N: " + polls.get(i).getPercentageNo();
            sendMessage(channel, result );
                }
            }
            
            
        }
        else if (message.contains("!poll num")){
            sendMessage(channel, polls.get(0).getYes() + " " + polls.get(0).getNo() + polls.get(0).getTotalVotes());
        }
        else{
            System.out.println(message);
        }
    }
    
}
