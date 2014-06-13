package strategy;

/**
 *  A test client
 */
/**
 * ����ģʽ(Strategy)������ģʽ���һ���㷨����ÿһ���㷨��װ�����й�ͬ�ӿڵĶ��������У��Ӷ�ʹ�����ǿ����໥�滻��
 * 					����ģʽʹ���㷨�����ڲ�Ӱ�쵽�ͻ��˵�����·����仯������ģʽ����Ϊ�ͻ����ֿ���
 * 					�����ฺ��ά�ֺͲ�ѯ��Ϊ�࣬�����㷨�ھ���Ĳ��������ṩ��
 * 					�����㷨�ͻ��������������㷨���������޸Ķ�����Ӱ�쵽�����Ϳͻ��ˡ�  
 * 
 * ����ģʽ �ʺ����г��ϣ�
 * 1���Բ�ͬ�ĸ�ʽ�����ļ���
 * 2���Բ�ͬ���㷨ѹ���ļ���
 * 3���Բ�ͬ���㷨�ػ�ͼ�� 
 * 4���Բ�ͬ�ĸ�ʽ���ͬ�����ݵ�ͼ�Σ��������߻��ͼbar��
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
        //ʹ�ò���A
        myContext.setLineWidth(lineWidth);
        myContext.setStrategy(strategyA);
        myContext.drawText();
        //ʹ�ò���B
        myContext.setLineCount(lineCount);
        myContext.setStrategy(strategyB);
        myContext.drawText();
    }
}