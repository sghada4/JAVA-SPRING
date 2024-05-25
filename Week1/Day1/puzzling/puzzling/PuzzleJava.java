import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

  Random randMachine = new Random();

  public ArrayList<Integer> getTenRolls() {
    ArrayList<Integer> myArray = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      int randomNum = randMachine.nextInt(20);
      myArray.add(randomNum + 1);
    }
    return myArray;
  }

  public char getRandomLetter() {
    String alphabet = new String("abcdefghijklmnopqrstuvwxyz");
    ArrayList<Character> alphabetArray = new ArrayList<Character>();

    for (int i = 0; i < alphabet.length(); i++) {
      alphabetArray.add(alphabet.charAt(i));
    }
    int randomNum = randMachine.nextInt(25);

    // System.out.println(alphabetArray);
    Character removedChar = alphabetArray.remove(randomNum);
    // System.out.println(alphabetArray);
    return removedChar;
  }

  public String generatePassword() {
    String password = "";
    for (int i = 0; i < 8; i++) {
      password += String.valueOf(getRandomLetter());
    }
    return password;
  }

  public ArrayList<String> getNewPasswordSet(int arrayLength){
    ArrayList<String> myArray = new ArrayList<String>();
    for (int i = 0; i < arrayLength; i++) {
      myArray.add(generatePassword());
    }
    return myArray;
  }
}
