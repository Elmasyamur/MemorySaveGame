import java.io.*;

public class Save {
    public static void savegame(Card[][] cards){
     try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("record.bin")) ){
         System.out.println("The game is being saved...");
         out.writeObject(cards);
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
    }
    public static Card[][] getrecord(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("record.bin")) ){
           Card[][] output = (Card[][])in.readObject();
           return output;
        } catch (IOException e) {
            System.out.println("IO exception occurred");
        } catch (ClassNotFoundException e) {
            System.out.println("The class not found exception occurred");
        }
        return null;
    }
}
