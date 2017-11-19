/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jablonskib.pollbot;

/**
 *
 * @author jablo
 */
public class Config {
    private String oauth = "oauth:1rwht6f25mamcxwnswhkaqwr04nfwk";
    private int port = 6667;
    private String ircChannel = "irc.twitch.tv";
    private String channel = "";
    
    public Config(String channelName){
        channel = channelName;
    }
    
    public String getAuth(){
        return oauth;
    }
    
    public int getPort(){
        return port;
    }
    
    public String getIRC(){
        return ircChannel;
    }
    public String getChannel(){
        return channel;
    }
}
