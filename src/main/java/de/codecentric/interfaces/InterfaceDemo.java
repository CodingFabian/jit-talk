package de.codecentric.interfaces;

import java.util.Random;

public class InterfaceDemo {

  static Shape[] shapes = new Shape[] { new Point(), new Line(), new Triangle() };

  public static void main(String[] args) {
    int i = new Random().nextInt(3);
    Shape shape = shapes[i];
    int points = shape.getPoints();
    System.out.println(points);
  }

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

}
