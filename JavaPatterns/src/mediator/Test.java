package mediator;

/**
 *  A test client
 */
/**
 * ��ͣ��ģʽ(Mediator)����ͣ��ģʽ��װ��һϵ�ж����໥���õķ�ʽ��ʹ����Щ���󲻱��໥�������á�
 * 			�Ӷ�ʹ���ǿ�����ɢż�ϡ���ĳЩ����֮������÷����ı�ʱ����������Ӱ��������һЩ����֮������á�
 * 			��֤��Щ���ÿ��Ա˴˶����ı仯����ͣ��ģʽ����Զ���໥����ת��Ϊһ�Զ���໥���á�
 * 			��ͣ��ģʽ���������Ϊ��Э�����󻯣��Ѷ�����С�߶ȵ���Ϊ��������������໥���÷ֿ�����  
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