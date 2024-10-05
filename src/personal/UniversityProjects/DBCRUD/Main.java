package personal.UniversityProjects.DBCRUD;


import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {

		String[] params = new String[1];
		params[0] = "";
		String connectorFilePath = "C:\\Users\\jjmel\\eclipse-workspace\\JavaCourse\\src\\personal\\UniversityProjects\\DBCRUD\\Connection.properties";
		String sentencesFilePath = "C:\\Users\\jjmel\\eclipse-workspace\\JavaCourse\\src\\personal\\UniversityProjects\\DBCRUD\\Querys.properties";

		try
		{
            DBComponent dbComponent = new DBComponent(connectorFilePath, sentencesFilePath);
			dbComponent.exe("songs", "seeAllSongs", params);

		}catch ( Exception e ){
			e.printStackTrace();
		}

    }


}

	


