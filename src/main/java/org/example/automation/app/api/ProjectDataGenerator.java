package org.example.automation.app.api;

public class ProjectDataGenerator {
    static String username = "TestUser";
    static double rand = Math.random();
    static long randNumber = Math.round(rand * 100);
    public static String getUniqueUserName(){
        return username+randNumber;
    }

    static String projectName = "Test Project";
    public static String getUniqueProjectName(){return projectName+randNumber;}
}
