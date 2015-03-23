package de.codecentric;

public class DeadCodeElimination {
  public static final boolean DEBUG = false;

  public static void main(String[] args) {
    if (DEBUG) {
      System.out.println("I am a debug output!");
    }
    // can we optimize here?
  }
}
