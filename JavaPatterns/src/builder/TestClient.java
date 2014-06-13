package builder;

/*
 *  A test client to create a house
 *  but we do not know how the room and door be created
 */
/**
 * 建造模式(Builder)：将产品的内部表象和产品的生成过程分割开来，从而使一个建造过程生成具有不同的内部表象的产品对象。
 * 					 建造模式使得产品内部表象可以独立的变化，客户不必知道产品内部组成的细节。
 * 					 建造模式可以强制实行一种分步骤进行的建造过程。 
 */
public class TestClient  {
    public TestClient() {
    }

    public static void main(String[] args) {
        House myHouse = new House();
        ConcreteHouseBuilderA myHouseBuilder = new ConcreteHouseBuilderA();
        HouseDirector myHouseDirector = new HouseDirector();
        myHouseDirector.CreateHouse(myHouseBuilder);
        myHouse = myHouseBuilder.getHouse();

        System.out.println("My house has room :" + myHouse.getRoomNumber());
        System.out.println("My house has door :" + myHouse.getDoorNumber());
    }
}