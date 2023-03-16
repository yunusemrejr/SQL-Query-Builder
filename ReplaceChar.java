/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yunusemrejr.sqlquerybuilder;

/**
 *
 * @author yunus
 */
public class ReplaceChar {
        public static String replaceCharacters(String str, char chr, int index) {
    StringBuilder string1 = new StringBuilder(str);
    string1.setCharAt(index, chr);
    return string1.toString();
}
    
}
