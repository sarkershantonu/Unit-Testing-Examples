package sayem.junit;

import org.junit.Before;
import org.junit.Test;

public class TestMyWork {

	private MyWork work; 
	@Before
	public void setUp() throws Exception {
		work = new MyWork();
	}

	@Test(expected = CustomException.class)
	public void test() throws Exception{
		work.aMethod(5);
	}

	/*public static junit.framework.Test suite(){
		return new JUnit4TestAdapter(CustomException.class);
	}*/
}
