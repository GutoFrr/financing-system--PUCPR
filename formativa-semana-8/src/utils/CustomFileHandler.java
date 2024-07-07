package utils;

import java.io.*;
import java.util.List;

import financing.Financing;

public class CustomFileHandler {
  public void writeTextFile(String fileName, String data, boolean append) {
    OutputStreamWriter writer = null;
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
    BufferedReader reader = null;
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
    BufferedReader reader = null;
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

  public void serializeObject(List<Financing> financingList) {
    ObjectOutputStream outputStream = null;
    try {
      outputStream = new ObjectOutputStream(new FileOutputStream("novosFinanciamentos.test"));

      outputStream.writeObject(financingList);

      outputStream.flush();
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deserializeObject() {
    ObjectInputStream inputStream = null;
    try {
      inputStream = new ObjectInputStream(new FileInputStream("novosFinanciamentos.test"));

      System.out.println();
      System.out.println("===== Novos financiamentos =====");

      List<Financing> financingList = (List<Financing>) inputStream.readObject();
      for (Financing item : financingList) {
        System.out.println();
        System.out.println(item.toString());
      }

      inputStream.close();
    } catch (EOFException e) {
      System.out.println("Fim do arquivo.");
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
