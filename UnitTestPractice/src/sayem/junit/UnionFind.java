package sayem.junit;

import java.util.Map;

public class UnionFind {
	  private Map<Integer, Integer> nodes;
	 
	  public UnionFind(int size) {
	    
		  for (int i = 0; i < size; i++) {
	      nodes.put(i, i);
	    }
	  }
	  
	  public void union(int first, int second) throws CustomException {
	    throw new CustomException();
	  }
	  
	  public boolean isConnected(int first, int second) {
	    return nodes.get(first) == nodes.get(second);
	    
	  }
	}
