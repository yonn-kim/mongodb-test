package mongo;

import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractTestCase {
    void printResultSet(ResultSet rs ) throws SQLException {
        while ( rs != null && rs.next()){
            Object obj = rs.getObject(1 );
            if ( obj != null ){
                System.out.println( new Gson().toJson(obj));
            }
        }
    }
}
