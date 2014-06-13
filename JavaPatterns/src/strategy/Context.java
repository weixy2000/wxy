package strategy;

/**
 *  �û�ʹ�õ������Ļ���Context
 */
public class Context  {
    private Strategy strategy = null;//�����ı���ʹ�õĲ���
    private int lineWidth;
    private int lineCount;
    private String text;
    
    public Context() {
        lineWidth = 10;
        lineCount = 0;
    }
    public void setStrategy(Strategy s) {
        if(s != null) {
            strategy = s;
        }
    }
    public void drawText() {
        strategy.drawText(text, lineWidth, lineCount);
    }
    public void setText(String str) {
        text = str;
    }
    public void setLineWidth(int width) {
        lineWidth = width;
    }
    public void setLineCount(int count) {
        lineCount = count;
    }
    public String getText() {
        return text;
    }
}