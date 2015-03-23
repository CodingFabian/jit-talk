package de.codecentric.inline;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.CompilerControl.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@BenchmarkMode(org.openjdk.jmh.annotations.Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class InlineControlBenchmark {

  public static class Multiplier {
    long multiply(int i) {
      return i * 2;
    }
  }

  Multiplier multiplier = new Multiplier();

  @Benchmark
  public long multiply() {
    return 42 * 2;
  }

  @Benchmark
  public long multiplyInstance() {
    return multiplier.multiply(42);
  }

  @Benchmark
  @CompilerControl(Mode.DONT_INLINE)
  public long multiplyNoInline() {
    return multiplier.multiply(42);
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(InlineControlBenchmark.class.getSimpleName()).forks(1)
        .warmupIterations(5).measurementIterations(5).build();

    new Runner(opt).run();
  }

}
