/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jablonskib.pollbot;

import java.io.IOException;
import org.jibble.pircbot.IrcException;

/**
 *
 * @author jablo
 */
public class Main {
    
    public static void main(String[] args) throws IOException, IrcException{
        
        Config c = new Config("#bitwise_");
        Bot bot = new Bot(c.getChannel());
        bot.setVerbose(true);
        bot.changeNick("PollBot");
        bot.connect(c.getIRC(), c.getPort(), c.getAuth());
        bot.joinChannel(c.getChannel());
       
    }
}
