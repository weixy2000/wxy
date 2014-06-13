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
 * 门面模式(Facade)： 外部与一个子系统的通信必须通过一个统一的门面对象进行。
 * 					门面模式提供一个高层次的接口，使得子系统更易于使用。
 * 					每一个子系统只有一个门面类，而且此门面类只有一个实例，也就是说它是一个单例模式。
 * 					但整个系统可以有多个门面类。  
 */
public class Test  {
    public static void main(String[] args) {
        FacadeRoom room = new FacadeRoom();
        room.createRoom();
    }
}