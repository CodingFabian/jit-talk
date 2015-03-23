package de.codecentric;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@BenchmarkMode(org.openjdk.jmh.annotations.Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class IntrinsicsBenchmark {

  String helloWorld = "Hello World";

  @Benchmark
  public int a_useIntrinsics() {
    return helloWorld.indexOf("World");
  }

  @Benchmark
  public int b_doNotUseIntrinsics() {
    return helloWorld.indexOf("World", 0);
  }

  @Benchmark
  public int c_byTheWayChars() {
    return helloWorld.indexOf('W');
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(IntrinsicsBenchmark.class.getSimpleName()).forks(1)
        .warmupIterations(5).measurementIterations(5).build();

    new Runner(opt).run();
  }

}
