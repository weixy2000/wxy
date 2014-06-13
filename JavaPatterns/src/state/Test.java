package state;

/**
 *  A test client
 */
/**
 * ״̬ģʽ(State)��״̬ģʽ����һ�����������ڲ�״̬�ı��ʱ��ı���Ϊ�����������ȥ���Ǹı���������һ����
 * 					״̬ģʽ�����о��Ķ������Ϊ��װ�ڲ�ͬ��״̬�����ÿһ��״̬��������һ������״̬���һ�����ࡣ
 * 					״̬ģʽ����ͼ����һ�����������ڲ�״̬�ı��ʱ������ΪҲ��֮�ı䡣
 * 					״̬ģʽ��Ҫ��ÿһ��ϵͳ����ȡ�õ�״̬����һ��״̬������ࡣ��ϵͳ��״̬�仯ʱ��ϵͳ��ı���ѡ�����ࡣ 
 */
public class Test  {
    public static void main(String[] args) {
        ShopContext myContext = new ShopContext();
        ShopState myShop = Shop.getInstance();
        ShopState myGenBill = GenerateBill.getInstance();
        ShopState myPay = Pay.getInstance();
        
        myContext.changeState(myShop);//ѡ����Ʒ
        myContext.shop();

        myContext.changeState(myGenBill);//���ɶ���
        myContext.generateBill();
        
        myContext.changeState(myPay);//����ȡ��
        myContext.pay();

        myShop.changeState(myContext, myPay);
        myContext.pay();
    }
}