package Java.SQl;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSQl {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://astrix.database.windows.net:1433;database=debsql;user={dwaipayanbasu25_outlook.com#EXT#@dwaipayanbasu25outlook.onmicrosoft.com};password={dwaipayan@1996};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;authentication=ActiveDirectoryPassword");
        
    }
}
