package de.codecentric.inline;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class InlineBenchmark {

  public static class Class1 {
    int getOne() {
      return 1;
    }
  }

  public static class Class2 {
    final int ONE = 1;

    int getOne() {
      return ONE;
    }
  }

  public static class Class3 {
    int one = 1;

    int getOne() {
      return one;
    }
  }

  public static class Class4 {
    volatile int one = 1;

    int getOne() {
      return one;
    }
  }

  @Benchmark
  public long add() {
    long sum = 0;
    for (int i = 0; i < 1_000_000; i++) {
      sum += 1;
    }
    return sum;
  }

  Class1 class1 = new Class1();

  @Benchmark
  public long addClass1() {
    long sum = 0;
    for (int i = 0; i < 1_000_000; i++) {
      sum += class1.getOne();
    }
    return sum;
  }

  Class2 class2 = new Class2();

  @Benchmark
  public long addClass2() {
    long sum = 0;
    for (int i = 0; i < 1_000_000; i++) {
      sum += class2.getOne();
    }
    return sum;
  }

  Class3 class3 = new Class3();

  @Benchmark
  public long addClass3() {
    long sum = 0;
    for (int i = 0; i < 1_000_000; i++) {
      sum += class3.getOne();
    }
    return sum;
  }

  Class4 class4 = new Class4();

  @Benchmark
  public long addClass4() {
    long sum = 0;
    for (int i = 0; i < 1_000_000; i++) {
      sum += class4.getOne();
    }
    return sum;
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(InlineBenchmark.class.getSimpleName()).forks(1)
        .warmupIterations(5).measurementIterations(5).build();

    new Runner(opt).run();
  }

}
