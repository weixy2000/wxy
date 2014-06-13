package abstractFactory;

/*
 * A Room Maker to test our simple Room Abstract Factory
 */
/**
 * 工厂模式(Factory)：客户类和工厂类分开。消费者任何时候需要某种产品，只需向工厂请求即可。
 * 			消费者无须修改就可以接纳新产品。缺点是当产品修改时，工厂类也要做相应的修改。
 * 			如：如何创建及如何向客户端提供。 
 */
public class RoomMaker  {
    public Room CreateRoom(String roomType) {
        if(roomType.equals("LivingRoom")) {
            return new LivingRoom();
        } else if(roomType.equals("BedRoom")) {
            return new BedRoom();
        } else {
            return new LivingRoom();
        }
    }

    public static void main(String[] args) {
        RoomMaker myMaker = new RoomMaker();
        //-----  Create Living Room
        Room myLivingRoom = myMaker.CreateRoom("LivingRoom");
        //-----  Create a door in living room
        Door livingDoor = myLivingRoom.makeDoor();
        System.out.println("Living room door name is:" + livingDoor.getName() );
        //-----  Create a wall in living room
        Wall livingWall = myLivingRoom.makeWall();
        System.out.println("Living room wall name is:" + livingWall.getName() );

        //-----  Create Bed Room
        Room myBedRoom = myMaker.CreateRoom("BedRoom");
        //-----  Create a door in bedroom
        Door BedDoor = myBedRoom.makeDoor();
        System.out.println("Bed room door name is:" + BedDoor.getName() );
        //-----  Create a wall in bedroom
        Wall BedWall = myBedRoom.makeWall();
        System.out.println("Bed room wall name is:" + BedWall.getName() );

    }
}