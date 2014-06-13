package bridge;

/**
 *  A test client
 */
/**
 * 桥梁模式(Bridge):将抽象化与实现化脱耦，使得二者可以独立的变化，也就是说将他们之间的强关联变成弱关联，
 * 			也就是指在一个软件系统的抽象化和实现化之间使用组合/聚合关系而不是继承关系，从而使两者可以独立的变化。  
 */
public class Test  {
    public Test() {
    }

    public static void main(String[] args) {
        Text myText = new TextBold("Mac");
        myText.DrawText("=== A test String ===");

        myText =  new TextBold("Linux");
        myText.DrawText("=== A test String ===");

        System.out.println("------------------------------------------");
        
        myText =  new TextItalic("Mac");
        myText.DrawText("=== A test String ===");

        myText =  new TextItalic("Linux");
        myText.DrawText("=== A test String ===");
    }
}