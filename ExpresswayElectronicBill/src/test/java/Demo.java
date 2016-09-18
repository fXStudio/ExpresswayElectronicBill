import java.io.File;
import java.net.URL;

import org.junit.Test;

public class Demo {
	@Test
	public void print(){
		URL url = Demo.class.getResource("/");
		
		File file = new File(url.getFile());
		
		System.out.println(file.listFiles().length);
	}
}
