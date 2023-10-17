/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connecting;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 26134
 */
public class Postgres {
    public static Connection getConnect(String base) throws Exception{
        try {
            if(base.equalsIgnoreCase("mysql"))
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/katsaka","postgres","postgres");
                return connection;
            }else if(base.equalsIgnoreCase("sql"))
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-U4RVM70:1433;databaseName=banque","admin","admin");
                return con;
            }else {
                Class.forName("org.postgresql.Driver");
                Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cin","postgres","postgres");
                return connect;
            }
        }catch(Exception e){
            throw e;
        }
    }
}
