package com.kash;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    @Value("${mySql.userName}")
    private String userName;

    @Value("${mySql.password}")
    private String password;
    @Value("${mySql.url}")
    private String url;
    @Value("${mySql.driver}")
    private String driver;

    public void displayJDBCConnectionInfo(){
        System.out.println("=>>Connection Details<<=");
        System.out.println("userName: " + this.userName);
        System.out.println("password: " + this.password);
        System.out.println("url: " + this.url);
        System.out.println("driver: " + this.driver);
    }

    public void getConnection() {
        try {
            // load driver:
            Class.forName(this.driver);

            // get the connection:
            Connection con = DriverManager.getConnection(this.url, this.userName, this.password);

            // check whether connection is made or not:
            if(con.isClosed()){
                System.out.println("Connection is still closed");
            }else{
                System.out.println("Connection is Made, Relax Man Chill...");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
