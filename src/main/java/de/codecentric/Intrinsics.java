package de.codecentric;

public class Intrinsics {

  public static volatile boolean go = true;

  public static void main(String[] args) {
    System.out.println("Debug indexOf!");
    long sumOfWorlds = 0;
    while (go) {
      sumOfWorlds += "Hello World".indexOf("World");
    }
    System.out.println(sumOfWorlds);
  }

}
