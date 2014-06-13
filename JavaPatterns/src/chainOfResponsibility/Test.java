package chainOfResponsibility;

/**
 *  A client to test
 */
/**
 * 责任链模式(Chain Of Responsibility)：在责任链模式中，很多对象由每一个对象对其下家的引用而接起来形成一条链。
 * 请求在这个链上传递，直到链上的某一个对象决定处理此请求。
 * 客户并不知道链上的哪一个对象最终处理这个请求，系统可以在不影响客户端的情况下动态的重新组织链和分配责任。
 * 处理者有两个选择：承担责任或者把责任推给下家。一个请求可以最终不被任何接收端对象所接受。
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