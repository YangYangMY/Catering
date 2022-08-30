/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rsf2s1g2.adt.utility;

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
    int miliSeconds = (int)(seconds * 1000);
    try {
      Thread.sleep(miliSeconds);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
