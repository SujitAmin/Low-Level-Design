package DesignPatterns.SingletonPattern;

public class DBConnection {
    private static DBConnection instance;
    private DBConnection(){

    }
    public static DBConnection getInstance(){
        if(instance == null){
            instance = new DBConnection();
            System.out.println("Created DB Connection");
        }
        return instance;
    }
}
