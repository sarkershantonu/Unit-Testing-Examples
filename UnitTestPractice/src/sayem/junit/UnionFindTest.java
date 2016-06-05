package sayem.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UnionFindTest {
	  @Rule
	  public ExpectedException expect = ExpectedException.none();
	  
	  @Test(expected = CustomException.class)
	  public void unionShouldThrowException() throws CustomException{
	    UnionFind uf = new UnionFind(10);	    
	    expect.expect(CustomException.class);
	    uf.union(0, 1);
	  }
	}