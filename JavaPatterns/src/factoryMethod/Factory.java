package factoryMethod;

/**
 * 工厂方法模式(FactoryMethod)：核心工厂类不再负责所有产品的创建，而是将具体创建的工作交给子类去做，成为一个抽象工厂角色，
 * 								仅负责给出具体工厂类必须实现的接口，而不接触哪一个产品类应当被实例化这种细节。  
 */
public class Factory {
    public Window CreateWindow (String type) {
        if(type.equals("Big")) {
            return new WindowBig();
        } else if(type.equals("Small")) {
            return new WindowSmall();
        } else {
            return new WindowBig();
        }
    }

    // The Main function only for our test
    public static void main(String[] args) {
        Factory myFactory = new Factory();
        Window myBigWindow = myFactory.CreateWindow("Big");
        myBigWindow.func();

        Window mySmallWindow = myFactory.CreateWindow("Small");
        mySmallWindow.func();
    }
}