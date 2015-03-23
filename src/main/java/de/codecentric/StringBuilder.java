package de.codecentric;

public class StringBuilder {
  public static void main(String[] args) {

    String nums = "";
    for (int i = 1; i < 10; i++) {
      nums += i;
    }
    System.out.println(nums);
    // Do you know why this class is called StringBuilder?
  }
}
