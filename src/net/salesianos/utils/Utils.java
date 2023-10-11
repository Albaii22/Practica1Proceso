package net.salesianos.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
  public static ArrayList<String> getAllTextLineCounter(String fileRoute) {
    ArrayList<String> TextLineCounter = new ArrayList<>();

    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRoute));

      String currentLine = bufferedReader.readLine();

      while (currentLine != null) {
        TextLineCounter.add(currentLine);
        currentLine = bufferedReader.readLine();
      }

      bufferedReader.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return TextLineCounter;
  }

  public static Integer getTotalVowelsFrom(String fileRoute) {
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRoute));
      String firsLine = bufferedReader.readLine();
      bufferedReader.close();
      return Integer.parseInt(firsLine);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }
}
