package com.factweavers.tutorials.common;
import com.factweavers.tutorials.configurationLoader.ConfigurationLoader;
import com.factweavers.tutorials.constants.Constants;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
public class SqlConnector {
    private static Connection connection=null;
    private static PreparedStatement preparedStatement=null;
    private static final Properties properties = ConfigurationLoader.getInstance().getProperties();
    public  final String url = properties.getProperty(Constants.SQL_JDBC_URL);
    public  final String user = properties.getProperty(Constants.SQL_USERNAME);
    public  final String password = properties.getProperty(Constants.SQL_PASSWORD);
    private static SqlConnector sqlConnector;
    private Logger logger=Logger.getLogger(this.getClass());
    public SqlConnector(){
        try {
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
    public static SqlConnector getInstance(){
        if(sqlConnector ==null){
            sqlConnector=new SqlConnector();
        }
        return sqlConnector;
    }
    public Connection getconnection(){
        return connection;
    }
    public static PreparedStatement getstatement(){
        try {
            preparedStatement= (PreparedStatement) connection.createStatement();
        } catch (Exception e){
            e.getMessage();
        }
        return preparedStatement;
    }
}
