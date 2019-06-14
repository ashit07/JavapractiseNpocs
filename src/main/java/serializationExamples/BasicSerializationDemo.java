package serializationExamples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Car implements Serializable {
  int a = 10;
}


public class BasicSerializationDemo {
  public void writeObjectToFile() {
    Car c = new Car();
    FileOutputStream fs;
    try {
      fs = new FileOutputStream("dummy.ser");
      try (ObjectOutputStream os = new ObjectOutputStream(fs)) {
        os.writeObject(c);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("done");
  }

  public void readObjectFromFile() {
    FileInputStream fs;
    try {
      fs = new FileInputStream("dummy.ser");
      Car c;
      try (ObjectInputStream is = new ObjectInputStream(fs)) {
        c = (Car) is.readObject();
      }
      System.out.println(c.a);
    } catch (IOException | ClassNotFoundException ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new BasicSerializationDemo().writeObjectToFile();
    new BasicSerializationDemo().readObjectFromFile();

  }
}
