import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doa {
    public ResultSet access() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1?useSSL=false","root","m1234y5678");
        System.out.println(conn);
        String sql= "select age from student where id = 1";
        Statement stmt=conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        resultSet.next();

        return resultSet;
    }
}
