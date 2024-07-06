package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CustomFileHandler {
  private OutputStreamWriter writer = null;
  private BufferedReader reader = null;

  public void writeTextFile(String fileName, String data, boolean append) {
    try {
      writer = new OutputStreamWriter(new FileOutputStream(fileName, append), "UTF-8");

      writer.write(data);

      writer.flush();
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("O arquivo não foi encontrado.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readTextFile(String fileName) {
    try {
      reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

      String line;
      while ((line = reader.readLine()) != null) {

        System.out.println(line);
      }

      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("O arquivo não foi encontrado.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int getTextFileLinesCount(String fileName) {
    try {
      reader = new BufferedReader(new FileReader(fileName));

      int lines = 0;
      while (reader.readLine() != null) {
        lines++;
      }

      reader.close();

      return lines;
    } catch (FileNotFoundException e) {
      System.out.println("O arquivo não foi encontrado.");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }
}
