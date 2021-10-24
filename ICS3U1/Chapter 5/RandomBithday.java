public class RandomBithday {
  public static void main(String[] args) {
    int year = (int) ((2054 - 1954 + 1) * Math.random() + 1954);
    int month = (int) ((12 - 1 + 1) * Math.random() + 1);
    int day = 0;
    String monthWorded = "";
    boolean leapYear = false;
    if (year % 4 == 0) { 
      if (year % 100 == 0 && year % 400 == 0) {
        leapYear = true;
      } else if (year % 100 == 0) {
        leapYear = false;
      } else {
        leapYear = true;
      }
    }
    switch (month) {
      case 1:
        monthWorded = "January";
        day = (int) ((31 - 1 + 1) * Math.random() + 1);
        break;
      case 2:
        monthWorded = "Febuary";
        if (leapYear == true) {
          day = (int) ((29 - 1 + 1) * Math.random() + 1);
        } else { 
          day = (int) ((28 - 1 + 1) * Math.random() + 1);
        }
        break;
      case 3:
        monthWorded = "March";
        day = (int) ((31 - 1 + 1) * Math.random() + 1);
        break;
      case 4:
        monthWorded = "April";
        day = (int) ((30 - 1 + 1) * Math.random() + 1);
        break;
      case 5:
        monthWorded = "May";
        day = (int) ((31 - 1 + 1) * Math.random() + 1);
        break;
      case 6:
        monthWorded = "June";
        day = (int) ((30 - 1 + 1) * Math.random() + 1);
        break;
      case 7:
        monthWorded = "July";
        day = (int) ((31 - 1 + 1) * Math.random() + 1);
        break;
      case 8:
        monthWorded = "August";
        day = (int) ((31 - 1 + 1) * Math.random() + 1);
        break;
      case 9:
        monthWorded = "September";
        day = (int) ((30 - 1 + 1) * Math.random() + 1);
        break;
      case 10:
        monthWorded = "October";
        day = (int) ((31 - 1 + 1) * Math.random() + 1);
        break;
      case 11:
        monthWorded = "November";
        day = (int) ((30 - 1 + 1) * Math.random() + 1);
        break;
      case 12:
        monthWorded = "December";
        day = (int) ((31 - 1 + 1) * Math.random() + 1);
        break;
    }
    System.out.print("You were born on " + monthWorded + " " + day + " " + year + ". ");
    if (leapYear == true) {
      System.out.println("It was a leap year"); 
    } else {
      System.out.println("It was not a leap year"); 
    }
  }
}