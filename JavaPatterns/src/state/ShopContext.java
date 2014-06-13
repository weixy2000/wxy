package state;

/**
 *  用户使用的上下文环境
 */
public class ShopContext  {
    private ShopState currentState;//当前状态，当其状态改变的时候，改变其行为
    public ShopContext() {
    }
    public void changeState(ShopState s) {
        currentState = s;
    }
    public void shop() {
        currentState.shop();
    }
    public void generateBill() {
        currentState.generateBill();
    }
    public void pay() {
        currentState.pay();
    }
}