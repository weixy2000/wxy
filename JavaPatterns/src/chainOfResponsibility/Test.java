package chainOfResponsibility;

/**
 *  A client to test
 */
/**
 * ������ģʽ(Chain Of Responsibility)����������ģʽ�У��ܶ������ÿһ����������¼ҵ����ö��������γ�һ������
 * ������������ϴ��ݣ�ֱ�����ϵ�ĳһ������������������
 * �ͻ�����֪�����ϵ���һ���������մ����������ϵͳ�����ڲ�Ӱ��ͻ��˵�����¶�̬��������֯���ͷ������Ρ�
 * ������������ѡ�񣺳е����λ��߰������Ƹ��¼ҡ�һ������������ղ����κν��ն˶��������ܡ�
 */
public class Test  {
    public static void main(String[] args) {
        Manager aManager = new Manager();
        ProjectManager aPM = new ProjectManager();
        Programmer aProgrammer = new Programmer();
        QA aQA = new QA();
        Others others = new Others();

        aManager.addChain(aPM);
        aPM.addChain(aProgrammer);
        aProgrammer.addChain(aQA);
        aQA.addChain(others);

        aManager.sendToChain("Get Project");
        aManager.sendToChain("Design");
        aManager.sendToChain("Coding");
        aManager.sendToChain("Test");
        aManager.sendToChain("Kill La Deng !");
    }
}