package decorator;

/**
 *  A simple test
 */
/**
 * װ��ģʽ(Decorator)��װ��ģʽ�ԶԿͻ���͸���ķ�ʽ��չ����Ĺ��ܣ��Ǽ̳й�ϵ��һ������������ṩ�ȼ̳и��������ԡ�
 * 					��̬��һ���������ӹ��ܣ���Щ���ܿ����ٶ�̬�ĳ�����	
 * 					������һЩ�������ܵ�������϶������ķǳ������Ĺ��ܡ�  
 */
public class Test1  {
    public static void main(String[] args) {
        Component myComponent = new ConcreteComponent();
        myComponent.PrintString("A test String");
        Decorator myDecorator = new ConcreteDecoratorA(myComponent);
        myDecorator.PrintString("A test String");
    }
}