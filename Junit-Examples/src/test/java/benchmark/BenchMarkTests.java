package benchmark;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.After;
import org.junit.Test;

public class BenchMarkTests extends AbstractBenchmark {
	private int i = 0;

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(20);
	}

	@BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 1, concurrency = 3)
	@Test
	public void testWithBenchMark() throws InterruptedException {
		System.out.println("Running " + i++);
		Thread.sleep(20);
		//http://labs.carrotsearch.com/junit-benchmarks-tutorial.html
	}

}
