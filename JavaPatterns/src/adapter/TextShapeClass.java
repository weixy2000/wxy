package adapter;

/**
 *  The Class Adapter in this sample 
 */
/**
 * 适配器模式(Adatper)：把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口原因不匹配而无法一起工作的两个类能够一起工作。
 * 						适配类可以根据参数返还一个合适的实例给客户端。  
 * 包括类形式和实例形式两种
 * 
 * 以下为：类形式
 */
public class TextShapeClass extends Text implements Shape {
    public TextShapeClass() {
    }
    public void Draw() {
        System.out.println("Draw a shap ! Impelement Shape interface !");
    }
    public void Border() {
        System.out.println("Set the border of the shap ! Impelement Shape interface !");
    }
    public static void main(String[] args) {
        TextShapeClass myTextShapeClass = new TextShapeClass();
        myTextShapeClass.Draw();
        myTextShapeClass.Border();
        myTextShapeClass.SetContent("A test text !");
        System.out.println("The content in Text Shape is :" + myTextShapeClass.GetContent());
    }
}