import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class PropertiesWriter {
    @Test
    public void write() {
        Properties prop = new Properties();
        
        try {
            prop.load(new FileInputStream("d:/mes.propeties"));
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        prop.setProperty("username", "ajaxfan");
        prop.setProperty("password", "123123123");
       
        
        try {
            prop.store(new FileOutputStream("d:/mes.propeties"), "This is Demo");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
