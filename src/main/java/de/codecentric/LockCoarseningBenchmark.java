package de.codecentric;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
@BenchmarkMode(org.openjdk.jmh.annotations.Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LockCoarseningBenchmark {

  @Benchmark
  public int a_notSynchronized() {
    int result = 0;
    result += 42 * 42 / 42;
    result += 42 * 42 / 42;
    result += 42 * 42 / 42;
    return result;
  }

  private Object lock = new Object();

  @Benchmark
  public int b_synchronized() {
    int result = 0;
    synchronized (lock) {
      result += 42 * 42 / 42;
      result += 42 * 42 / 42;
      result += 42 * 42 / 42;
    }
    return result;
  }

  @Benchmark
  public int c_synchronizedMultipleTimes() {
    int result = 0;
    synchronized (lock) {
      result += 42 * 42 / 42;
    }
    synchronized (lock) {
      result += 42 * 42 / 42;
    }
    synchronized (lock) {
      result += 42 * 42 / 42;
    }
    return result;
  }

  @Benchmark
  public int d_synchronizedMultipleTimesOnThreadLocalLock() {
    int result = 0;
    Thread thread = Thread.currentThread();
    synchronized (thread) {
      result += 42 * 42 / 42;
    }
    synchronized (thread) {
      result += 42 * 42 / 42;
    }
    synchronized (thread) {
      result += 42 * 42 / 42;
    }
    return result;
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(LockCoarseningBenchmark.class.getSimpleName()).forks(1)
        .warmupIterations(5).measurementIterations(5).build();

    new Runner(opt).run();
  }

}
