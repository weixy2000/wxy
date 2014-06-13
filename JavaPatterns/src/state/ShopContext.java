package state;

/**
 *  �û�ʹ�õ������Ļ���
 */
public class ShopContext  {
    private ShopState currentState;//��ǰ״̬������״̬�ı��ʱ�򣬸ı�����Ϊ
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