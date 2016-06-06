package mathieu.concurrent.examples;


import concurrent.Mathieu.Concurrent;
import concurrent.Mathieu.ConcurrentJunitRunner;
import org.junit.runner.RunWith;

/**
 * Created by shantonu on 6/6/16.
 * This class have examples using concurrency using Mathieu Carbou; simplementation.
 * Original posts : https://dzone.com/articles/concurrent-junit-tests
 */
@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 2)
public class TestConcurrency {
}
