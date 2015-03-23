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

@State(Scope.Thread)
@BenchmarkMode(org.openjdk.jmh.annotations.Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class LockElisionBenchmark {

  private static class Calculator {
    public int calculate() {
      return 42 * 42 / 42;
    }
  }

  private static class SynchronizedCalculator {
    // should be much slower, stupid locks!
    public synchronized int calculate() {
      return 42 * 42 / 42;
    }
  }

  @Benchmark
  public int a_notSynchronized() {
    return new Calculator().calculate();
  }

  @Benchmark
  public int b_synchronized() {
    return new SynchronizedCalculator().calculate();
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(LockElisionBenchmark.class.getSimpleName()).forks(1)
        .warmupIterations(5).measurementIterations(5).build();

    new Runner(opt).run();
  }

}
