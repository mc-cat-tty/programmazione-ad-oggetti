import java.time.Instant;
import java.util.*;

public class MicroBenchmarkTester {
  private final static int ELEMENTS = 1000000;
  
  public MicroBenchmarkTester() {
    List<Integer> v = new Vector<>();
    
    // avoid cache bias
    benchMark(v);

    for (int i = 0; i < 3; i++) {
      System.out.println("Vector " + i + ": " +  benchMark(v));
    }

    List<Integer> a = new ArrayList<>();

    // avoid cache bias
    benchMark(a);

    for (int i = 0; i < 3; i++) {
      System.out.println("ArrayList " + i + ": " + benchMark(a));
    }
  }

  public static void main(String[] args) {
    new MicroBenchmarkTester();
  }

  private long benchMark(Collection<Integer> c) {
    System.gc();

    long startTime = Instant.now().toEpochMilli();

    for (int i = 0; i < ELEMENTS; i++) {
      c.add(1);
    }

    long endTime = Instant.now().toEpochMilli();

    c.clear();
    
    return endTime - startTime;
  }
}