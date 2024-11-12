package personal.UniversityProjects.DBComponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        /*
        Here in the main, I will create a mini example app to try the DBComponent Class methods.
        -Option to change the db, from PSQL to MySQL, Different DB same main usage.
        -Option to test the Connection Pool
        -Basic CRUD implementation
        */

        DBComponent db = new DBComponent();
        db.switchDatabase("productos");
        try {
            Connection con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from prod");
            rs.close();
            stmt.close();
            db.returnConnection(con);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}


