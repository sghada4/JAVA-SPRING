public class PuzzleJavaTest{
    public static void main(String[] args){
        PuzzleJava p1=new PuzzleJava();
        System.out.println(p1.getTenRolls());
        System.out.println(p1.getRandomLetter());
        System.out.println(p1.generatePassword());
        System.out.println(p1.getNewPasswordSet(4));
    }
}