package personal.UniversityProjects.DBCRUD;


import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {

		String[] params = new String[1];
		params[0] = "46";

		try
		{
            DBComponent dbComponent = new DBComponent("C:\\Users\\jjmel\\eclipse-workspace\\JavaCourse\\src\\personal\\UniversityProjects\\DBCRUD\\Connection.properties", "C:\\Users\\jjmel\\eclipse-workspace\\JavaCourse\\src\\personal\\UniversityProjects\\DBCRUD\\Querys.properties");
			dbComponent.exe("artists", "getArtist", params);

		}catch ( Exception e ){
			e.printStackTrace();
		}

    }


}

	


