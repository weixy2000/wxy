package adapter;

/**
 *  The Adaptee in this sample
 *  �������Դ����
 */
public class Text  {
    private String content; 
    public Text() {
        
    }
    public void SetContent(String str) {
        content = str;
    }
    public String GetContent() {
        return content;
    }
}