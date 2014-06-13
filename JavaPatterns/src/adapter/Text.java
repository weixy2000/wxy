package adapter;

/**
 *  The Adaptee in this sample
 *  被适配的源对象
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