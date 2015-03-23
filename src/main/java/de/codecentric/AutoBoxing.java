package de.codecentric;

public class AutoBoxing {

  public static void main(String[] args) {
    Integer i = 42;
    // shouldn't this be new Object somehow?
    System.out.println(i.toString());
  }

}
