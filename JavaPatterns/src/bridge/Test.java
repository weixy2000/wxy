package bridge;

/**
 *  A test client
 */
/**
 * ����ģʽ(Bridge):��������ʵ�ֻ����ʹ�ö��߿��Զ����ı仯��Ҳ����˵������֮���ǿ���������������
 * 			Ҳ����ָ��һ�����ϵͳ�ĳ��󻯺�ʵ�ֻ�֮��ʹ�����/�ۺϹ�ϵ�����Ǽ̳й�ϵ���Ӷ�ʹ���߿��Զ����ı仯��  
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