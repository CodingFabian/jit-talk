package de.codecentric.interfaces;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class InterfaceBenchmark4 {

  private static class Point implements Shape {

    @Override
    public int getPoints() {
      return 1;
    }
  }

  private static class Line implements Shape {

    @Override
    public int getPoints() {
      return 2;
    }
  }

  private static class Triangle implements Shape {

    @Override
    public int getPoints() {
      return 3;
    }
  }

  private static class Square implements Shape {

    @Override
    public int getPoints() {
      return 4;
    }
  }

  Shape[] shapes;

  @Setup
  public void prepare() {
    shapes = new Shape[Shape.ARRAY_SIZE];
    for (int i = 0; i < Shape.ARRAY_SIZE; i++) {
      if (i % 4 == 0) {
        shapes[i] = new Point();
      } else if (i % 4 == 1) {
        shapes[i] = new Line();
      } else if (i % 4 == 2) {
        shapes[i] = new Triangle();
      } else {
        shapes[i] = new Square();
      }
    }
  }

  @Benchmark
  public long testFourShapes() {
    long sum = 0;
    for (int i = 0; i < Shape.ARRAY_SIZE; i++) {
      sum += shapes[i].getPoints();
    }
    return sum;
  }

}
