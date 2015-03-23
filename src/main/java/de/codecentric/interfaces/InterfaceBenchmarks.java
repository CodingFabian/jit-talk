package de.codecentric.interfaces;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class InterfaceBenchmarks {

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder().include(".*InterfaceBenchmark.+")
        .forks(1).warmupIterations(5).measurementIterations(5).build();

    new Runner(opt).run();
  }

}
