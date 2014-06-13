package mediator;

/**
 *  A test client
 */
/**
 * 调停者模式(Mediator)：调停者模式包装了一系列对象相互作用的方式，使得这些对象不必相互明显作用。
 * 			从而使他们可以松散偶合。当某些对象之间的作用发生改变时，不会立即影响其他的一些对象之间的作用。
 * 			保证这些作用可以彼此独立的变化。调停者模式将多对多的相互作用转化为一对多的相互作用。
 * 			调停者模式将对象的行为和协作抽象化，把对象在小尺度的行为上与其他对象的相互作用分开处理。  
 */
public class Test  {
    public static void main(String[] args) {
        Mediator myMed = new ConcreteMediator();
        ColleagueA a = new ColleagueA(myMed);
        ColleagueB b = new ColleagueB(myMed);
        ColleagueC c = new ColleagueC(myMed);

        a.Change();
        b.Change();
        c.Change();
    }
}