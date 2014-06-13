package strategy;

/**
 *  A test client
 */
/**
 * 策略模式(Strategy)：策略模式针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。
 * 					策略模式使得算法可以在不影响到客户端的情况下发生变化。策略模式把行为和环境分开。
 * 					环境类负责维持和查询行为类，各种算法在具体的策略类中提供。
 * 					由于算法和环境独立开来，算法的增减，修改都不会影响到环境和客户端。  
 * 
 * 策略模式 适合下列场合：
 * 1、以不同的格式保存文件；
 * 2、以不同的算法压缩文件；
 * 3、以不同的算法截获图像 
 * 4、以不同的格式输出同样数据的图形，比如曲线或框图bar等
 */
public class Test  {
    public static void main(String[] args) {
        int lineCount = 4;
        int lineWidth = 12;
        
        Context myContext = new Context();
        StrategyA strategyA = new StrategyA();
        StrategyB strategyB = new StrategyB();
        String s = "This is a test string ! This is a test string ! This is a test string ! This is a test string ! This is a test string ! This is a test string !";
        myContext.setText(s);
        //使用策略A
        myContext.setLineWidth(lineWidth);
        myContext.setStrategy(strategyA);
        myContext.drawText();
        //使用策略B
        myContext.setLineCount(lineCount);
        myContext.setStrategy(strategyB);
        myContext.drawText();
    }
}