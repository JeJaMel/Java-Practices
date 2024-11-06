package personal.UniversityProjects.DBComponent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBComponent {

    private static String CONFIG_FILE_PATH = "";
    private static String SENTECES_FILE_PATH = "";
    private final Properties connectionProperties = new Properties();
    private final Properties sentecesProperties = new Properties();

//    public static Pool CreatePool(Properties props) throws ClassNotFoundException, SQLException, IOException {
//        return Pool.getInstance();
//    }

    private String getDB(String dbType, String dbAttribute) {
        String key = dbType + "." + dbAttribute;
        if (!connectionProperties.containsKey(key)) {
            System.out.println("Key " + key + " not found");
            return null;
        }
        return connectionProperties.getProperty(key);
    }

    private static Properties loadProps(String CONFIG_FILE_PATH) throws IOException {
        Properties props = new Properties();
        try (InputStream input = Pool.class.getResourceAsStream(CONFIG_FILE_PATH)) {
            if (input == null) {
                throw new IOException("Unable to find Config.properties");
            }
            props.load(input);
        }
        return props;
    }

}
