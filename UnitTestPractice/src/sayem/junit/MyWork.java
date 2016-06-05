package sayem.junit;

public class MyWork {

	public MyWork() {

	}

	public int aMethod(int x) throws CustomException {
		if (x == 5) {
			throw new CustomException();
		} else {
			return 10;
		}
	}
}
