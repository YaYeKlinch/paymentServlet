package com.example.payment.controller.command.uttils;

import javax.servlet.http.HttpServletRequest;

public class PathUtils {
    private static final String ACCOUNT_PATH = "account_id=";
    private final static String SEPARATOR = "/";


    public static Long getAccountId(HttpServletRequest request){
        String path = request.getRequestURI();
        int numberStartIndex = getFirstIndex(ACCOUNT_PATH,path);
        int numberEndIndex = getLastIndex(numberStartIndex,path);
        String id = path.substring(numberStartIndex,numberEndIndex);
        return Long.parseLong(id);
    }


    private static int getFirstIndex(String IdAnnouncement, String path){
        int numberStartIndex = path.indexOf(IdAnnouncement);
        if(numberStartIndex < 0){
            throw new NumberFormatException("cant find requested id");
        };
        return numberStartIndex + IdAnnouncement.length();
    }

    private static int getLastIndex(int firstIndex, String path){
        int numberEndIndex = path.indexOf(SEPARATOR,firstIndex);
        if(numberEndIndex < 0){
            numberEndIndex =  path .length();
        }
        return numberEndIndex;
    }

}
