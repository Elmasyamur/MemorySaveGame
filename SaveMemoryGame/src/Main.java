import java.io.File;
import java.util.Scanner;

public class Main {
    private static Card[][] cards = new Card[4][4];

  public static void getrecord(){
      //Are there any previously saved games? Let's check it
      Scanner inp= new Scanner(System.in);
      File file= new File("record.bin");
      if(file.exists()){
          System.out.println("You have a saved game. Would you like to continue from the save?");
          String answer= inp.nextLine();
          if(answer.equals("yes")){
              cards = Save.getrecord();
              return;
          }

      }
      cards[0][0] = new Card('E');
      cards[0][1] = new Card('A');
      cards[0][2] = new Card('B');
      cards[0][3] = new Card('F');
      cards[1][0] = new Card('G');
      cards[1][1] = new Card('A');
      cards[1][2] = new Card('D');
      cards[1][3] = new Card('H');
      cards[2][0] = new Card('F');
      cards[2][1] = new Card('C');
      cards[2][2] = new Card('D');
      cards[2][3] = new Card('H');
      cards[3][0] = new Card('E');
      cards[3][1] = new Card('G');
      cards[3][2] = new Card('B');
      cards[3][3] = new Card('C');







  }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getrecord();
        while (isGameOver() == false) {
          GameTable();
            System.out.print("Press q to exit (yes or no)");
            String exit= scanner.nextLine();
            if(exit.equals("yes")){
                System.out.println("Do you want to save the game?(yes or no)");
              String save = scanner.nextLine();
              if(save.equals("yes")){
                  Save.savegame(cards);
              }
              else System.out.println("The game did not save");
              System.out.println("Exiting the program...");
                break;
            }
            predict();
        }
    }
    public static void predict(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("First prediction (Enter i and j values with a space...): ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        cards[i1][j1].setPrediction(true);
        GameTable();

        System.out.print("Second prediction (Enter i and j values with a space...): ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();

        if (cards[i1][j1].getValue() == cards[i2][j2].getValue()) {
            System.out.println("Right guess. Congratulations!");
            cards[i2][j2].setPrediction(true);

        }
        else {
            System.out.println("Wrong guess");
            cards[i1][j1].setPrediction(false);

        }
    }
    public static boolean isGameOver(){

        for (int i =  0 ; i < 4; i++){
            for (int j = 0 ; j < 4 ; j++) {
                if (cards[i][j].getPrediction() == false) {
                    return false;

                }

            }
        }
        return true;

    }
    public static void GameTable(){
        for (int i = 0 ;  i < 4 ; i++) {
            System.out.println("____________________");
            for (int j = 0 ; j < 4 ; j++) {

                if (cards[i][j].getPrediction()) {
                    System.out.print(" |" + cards[i][j].getValue() + "| ");

                }
                else {
                    System.out.print(" | | ");

                }
            }
            System.out.println("");
        }
        System.out.println("____________________");

    }
}