package state;

/**
 *  A test client
 */
/**
 * 状态模式(State)：状态模式允许一个对象在其内部状态改变的时候改变行为。这个对象看上去象是改变了它的类一样。
 * 					状态模式把所研究的对象的行为包装在不同的状态对象里，每一个状态对象都属于一个抽象状态类的一个子类。
 * 					状态模式的意图是让一个对象在其内部状态改变的时候，其行为也随之改变。
 * 					状态模式需要对每一个系统可能取得的状态创立一个状态类的子类。当系统的状态变化时，系统便改变所选的子类。 
 */
public class Test  {
    public static void main(String[] args) {
        ShopContext myContext = new ShopContext();
        ShopState myShop = Shop.getInstance();
        ShopState myGenBill = GenerateBill.getInstance();
        ShopState myPay = Pay.getInstance();
        
        myContext.changeState(myShop);//选择商品
        myContext.shop();

        myContext.changeState(myGenBill);//生成订单
        myContext.generateBill();
        
        myContext.changeState(myPay);//付款取货
        myContext.pay();

        myShop.changeState(myContext, myPay);
        myContext.pay();
    }
}