package basics;

class MyDate {
  int day, month, year;

  MyDate(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public String toString() {
    return " " + day + "-" + month + "-" + year;

  }
}


public class PassByValueAndReference {

  public static void changeInt(int value) {
    value = 50;
  }

  public static void changeObjectRef(MyDate dateRef) {
    dateRef = new MyDate(7, 4, 2014);
  }

  public static void changeObjectAttribute(MyDate dateRef) {
    dateRef.setDay(7);
  }

  public static void main(String[] args) {
    MyDate date;
    int val;
    val = 22;

    changeInt(val);
    System.out.println("Int value is: " + val);
    date = new MyDate(2, 7, 2014);
    changeObjectRef(date);
    System.out.println("Mydate  is: " + date);
    changeObjectAttribute(date);
    System.out.println("Mydate  is: " + date);
  }
}
