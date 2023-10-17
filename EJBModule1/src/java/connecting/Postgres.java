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
            }else if(base.equalsIgnoreCase("oracle"))
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
                return con;
            }else {
                Class.forName("org.postgresql.Driver");
                Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/foncier","postgres","postgres");
                return connect;
            }
        }catch(Exception e){
            throw e;
        }
    }
}
