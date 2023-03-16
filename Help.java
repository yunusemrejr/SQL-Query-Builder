/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yunusemrejr.sqlquerybuilder;
import java.io.IOException;
 /**
 *
 * @author yunus
 */
public class Help {
       public static void help() throws IOException{
        
        System.out.println("\n Here are the instructions:\n*run the executable (you already did),\n *start entering one of these "
                + "commands to start building queries:\n*'-create'\n *'-drop'\n*'-alter'\n*'-truncate'\n*'-grant'\n*'-revoke'\n*'-insert'\n"
                + "*'-update'\n*'-delete'\n*'-commit'\n*'-rollback'\n*'-savepoint'\n*'-select'\n********\n"
                );
        
           Listener.listener();
    }

    
}
