package de.codecentric;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AllocationAvoidance {

  public static volatile boolean go = true;

  public static void main(String[] args) {
    System.out.println("You want to learn about AllocationAvoidance?");
    System.out.println("Run with -verbose:gc -Xmx10M");
    monitorObjectCreation();
    long sumOfAllX = 0;
    while (go) {
      sumOfAllX += new Point().x;
    }
    System.out.println(sumOfAllX);
    System.out.println(pointsConstructed);
  }

  public static class Point {
    volatile long x = 42;
    volatile long y = 42;

    public Point() {
      pointsConstructed++;
    }
  }

  public static volatile long pointsConstructed = 0;

  private static void monitorObjectCreation() {
    Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        System.out.println(pointsConstructed);
      }
    }, 5, 5, TimeUnit.SECONDS);
  }

}
