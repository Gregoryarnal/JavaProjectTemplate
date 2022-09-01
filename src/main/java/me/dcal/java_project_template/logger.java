package me.dcal.java_project_template;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class logger {
    public void log(String message){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now) + " : " + message);  
    }
}
