package rsf2s1g2.utility;

import java.util.Scanner;

/**
 *
 * 
 */
public class Screen {
  public static void clear() {
    try {
      String operatingSystem = System.getProperty("os.name"); // Check the current operating system

      if (operatingSystem.contains("Windows")) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      } else {
        ProcessBuilder pb = new ProcessBuilder("clear");
        Process startProcess = pb.inheritIO().start();

        startProcess.waitFor();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void pause(float seconds) {
    int miliSeconds = (int) (seconds * 1000);
    try {
      Thread.sleep(miliSeconds);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static int numInputValid(int min, int max, String message) {
    Scanner input = new Scanner(System.in);
    int num = 0;
    try {
      System.out.print(message);
      num = input.nextInt();
      if (num < min || num > max) {
        System.out.println("Invalid input. Please try again.");
        num = numInputValid(min, max, message);
      }
    } catch (Exception e) {
      System.out.println("Invalid input. Please try again.");
      num = numInputValid(min, max, message);
    }
    return num;
  }
}
