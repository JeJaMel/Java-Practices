package personal.UniversityProjects.ConnectionPool;

import java.io.IOException;
import java.sql.SQLException;

public class PoolManager {

    private Pool pool;

    public PoolManager() throws IOException, SQLException, ClassNotFoundException {
        pool = Pool.getInstance();
    }



    public void getConnection() throws IOException {

    }


}
