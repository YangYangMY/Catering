package rsf2s1g2.utility;

import java.util.Scanner;
import rsf2s1g2.utility.Font;

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

  public static int numInputValid(int min, int max, String message, String invalidMessage) {
    Scanner input = new Scanner(System.in);
    int num = 0;
    try {
      System.out.print(message);
      num = input.nextInt();
      if (num < min || num > max) {
        Font.print(Font.RED_BOLD_BRIGHT,invalidMessage);
        num = numInputValid(min, max, message, invalidMessage);
      }
    } catch (Exception e) {
      Font.print(Font.RED_BOLD_BRIGHT,invalidMessage);
      num = numInputValid(min, max, message, invalidMessage);
    }
    return num;
  }
}
