/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yunusemrejr.sqlquerybuilder;

import static com.yunusemrejr.sqlquerybuilder.Create.create;
import static com.yunusemrejr.sqlquerybuilder.Help.help;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author yunus
 */
public class Listener {
      public static void listener() throws IOException{
        
          BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
        
        String line = reader.readLine();
        
        
        
        
        if(null == line){
            System.out.println("\nyou entered an unknown command. try again:\n");
            listener();
        }
        
        
        
        else switch (line) {
              case "-help" -> help();
              case "-create" -> create();
              case "-drop" -> {
              }
              case "-alter" -> {
              }
              case "-truncate" -> {
              }
              case "-grant" -> {
              }
              case "-revoke" -> {
              }
              case "-insert" -> {
              }
              case "-update" -> {
              }
              case "-delete" -> {
              }
              case "-commit" -> {
              }
              case "-rollback" -> {
              }
              case "-savepoint" -> {
              }
              case "-select" -> {
              }
              default -> {
                  System.out.println("\nyou entered an unknown command. try again:\n");
                  listener();
              }
          }
        
        
        
    }
}
