import org.junit.Test;

public class FileDemo {
	@Test
	public void test() {
		String name = "123.bak";
		
		System.out.println(name.matches(".+\\.bak$"));
	}
}
