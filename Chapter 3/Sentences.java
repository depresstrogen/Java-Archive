import java.util.Scanner;
public class Sentences {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int subjectCount = sc.nextInt();
    int verbCount = sc.nextInt();
    int objectCount = sc.nextInt();
    
    String currentSubject = "";
    String currentVerb = "";
    String currentObject = "";
    
    String[] subjects = new String[subjectCount];
    String[] verbs = new String[verbCount];
    String[] objects = new String[objectCount];
    
    for (int i = 0; i < subjectCount; i ++) {
      subjects[i] = sc.nextLine();
    }
    
    for (int i = 0; i < verbCount; i ++) {
      verbs[i] = sc.nextLine();
    }
    
    for (int i = 0; i < objectCount; i ++) {
      objects[i] = sc.nextLine();
    }
    
    for (int i = 0; i < subjectCount; i ++) {
      for (int j = 0; i < verbCount; i ++) {
        for (int k = 0; i < objectCount; i ++) {
          System.out.println(subjects[i] + " " + verbs[j] + " " + objects[k]);
        }
      }
    }
  }
}