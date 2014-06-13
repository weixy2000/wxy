package facade;
/**
 *  A very simple test
 */

class Wall {
    public Wall() {
        System.out.println("Create a wall !");
    }
}

class Door {
    public Door() {
        System.out.println("Create a door !");
    }
}

class FacadeRoom {
    public void createRoom() {
        Wall wall1 = new Wall();
        Wall wall2 = new Wall();
        Wall wall3 = new Wall();
        Wall wall4 = new Wall();
        Door door = new Door();
    }

}
/**
 * ����ģʽ(Facade)�� �ⲿ��һ����ϵͳ��ͨ�ű���ͨ��һ��ͳһ�����������С�
 * 					����ģʽ�ṩһ���߲�εĽӿڣ�ʹ����ϵͳ������ʹ�á�
 * 					ÿһ����ϵͳֻ��һ�������࣬���Ҵ�������ֻ��һ��ʵ����Ҳ����˵����һ������ģʽ��
 * 					������ϵͳ�����ж�������ࡣ  
 */
public class Test  {
    public static void main(String[] args) {
        FacadeRoom room = new FacadeRoom();
        room.createRoom();
    }
}