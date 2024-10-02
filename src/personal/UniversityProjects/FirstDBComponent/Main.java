package personal.UniversityProjects.FirstDBComponent;

import java.sql.*;


public class Main {

    public static void main(String[] args) throws SQLException {

		String[] params = new String[1];
		params[0] = "46";

		try
		{
            DBComponent dbComponent = new DBComponent("C:\\Users\\jjmel\\eclipse-workspace\\JavaCourse\\src\\personal\\UniversityProjects\\FirstDBComponent\\Connection.properties", "C:\\Users\\jjmel\\eclipse-workspace\\JavaCourse\\src\\personal\\UniversityProjects\\FirstDBComponent\\Querys.properties");
          //  Connection con = dbComponent.getCnn();
			dbComponent.exe("artists", "getArtist", params);

		}catch ( Exception e ){
			e.printStackTrace();
		}

    }


}

	


