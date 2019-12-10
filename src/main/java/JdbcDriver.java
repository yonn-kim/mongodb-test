import com.google.gson.Gson;

import java.sql.*;
import java.util.Properties;

public class JdbcDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.dbschema.MongoJdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:mongodb://127.0.0.1:27017/ngrinder");

            String query = "db.user.find({})";

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while ( rs != null && rs.next()){
                Object obj = rs.getObject(1 );
                if ( obj != null ){
                    System.out.println( new Gson().toJson(obj));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
