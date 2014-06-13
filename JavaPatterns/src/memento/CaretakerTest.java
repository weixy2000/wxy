package memento;

/**
 *  A Caretaker as our test client
 */
import java.io.*;
/**
 * 备忘录模式(Memento)： 备忘录对象是一个用来存储另外一个对象内部状态的快照的对象。
 * 				备忘录模式的用意是在不破坏封装的条件下，将一个对象的状态捉住，并外部化，存储起来，
 * 				从而可以在将来合适的时候把这个对象还原到存储起来的状态。  
 */
public class CaretakerTest  {
    public static void main(String[] args) {
        TextOriginator originator = new TextOriginator();
        System.out.println("-----  Please edit text  -----");
        System.out.println("Usage: input \"undo\" to undo your edit");
        System.out.println("Usage: input \"end\" to end edit");
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));            

            String str = "";
            while(true) {
                str = in.readLine();
                if(str.equals("end")) {
                    System.out.println("-----  End edit  -----");
                    break;
                } else if(str.equals("undo")) {
                    originator.setMemento();
                } else { 
					if (!str.equals("")) {
                        originator.addText(str);
                        originator.createMemento();
                    }
                    
                }
                System.out.println("--Input Text is :" + originator.getText());
            }
        } catch(IOException e) {
            System.out.println("I/O Error !");
            System.exit(1);
        }
    }
}