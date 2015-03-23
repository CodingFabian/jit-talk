package de.codecentric;

import java.util.Arrays;
import java.util.Random;

public class BranchPrediction {
  private static final int ARRAY_SIZE = 100_000_000;

  private static final boolean FAST = true;

  public static void main(String[] args) {
    long data[] = new long[ARRAY_SIZE];

    // same random seed for every run
    Random rnd = new Random(0);
    for (int c = 0; c < ARRAY_SIZE; ++c) {
      data[c] = rnd.nextInt(10);
    }

    if (FAST) {
      Arrays.sort(data);
    }

    long start = System.currentTimeMillis();
    long sum = calculationLoop(data);

    System.out.println(System.currentTimeMillis() - start + "ms");
    System.out.println(sum);
  }

  private static long calculationLoop(long[] data) {
    long sum = 0;

    for (int c = 0; c < ARRAY_SIZE; ++c) {
      if (data[c] >= 5) {
        sum += data[c];
      }
    }
    return sum;
  }
}
