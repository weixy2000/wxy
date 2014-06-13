package decorator;

/**
 *  A simple test
 */
/**
 * 装饰模式(Decorator)：装饰模式以对客户端透明的方式扩展对象的功能，是继承关系的一个替代方案，提供比继承更多的灵活性。
 * 					动态给一个对象增加功能，这些功能可以再动态的撤消。	
 * 					增加由一些基本功能的排列组合而产生的非常大量的功能。  
 */
public class Test1  {
    public static void main(String[] args) {
        Component myComponent = new ConcreteComponent();
        myComponent.PrintString("A test String");
        Decorator myDecorator = new ConcreteDecoratorA(myComponent);
        myDecorator.PrintString("A test String");
    }
}