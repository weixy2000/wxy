package template;

/**
 *  A test client
 */
/**
 * ������ģʽ(Template)������һ�����Ժ󣬽�����ģʽ���Զ�������ķ���һ�ֱ�ʾ����ͬʱ�ṩһ����������
 * 					�ͻ��˿���ʹ�������������������������еľ��ӡ�������ģʽ����������������һ���򵥵��ķ���ʹ��ģʽ��ƽ�����Щ��䡣
 * 					�ڽ�����ģʽ�����ᵽ��������ָ�κν����������ܹ����͵��κ���ϡ�
 * 					�ڽ�����ģʽ����Ҫ����һ�������ķ���������ĵȼ��ṹ��Ҳ����һϵ�е���Ϲ���
 * 					ÿһ�����������һ�����ͷ�����������������Ľ��͡��������ĵȼ��ṹ�еĶ�����κ�������϶���һ�����ԡ�
 */
public class Test  {
    public static void main(String[] args) {
        // You should change the path of "test.txt" in your local machine
        String fileName = "d:\\javaproject\\TemplateMethod\\src\\test.txt";
        String url = "http://www.the9.com/main.htm";
        
        AbstractRead fileRead = new ReadFile();
        AbstractRead htmlRead = new ReadHtml();

        fileRead.setResource(fileName);
        htmlRead.setResource(url);
        
        System.out.println("-----  Read from a file  -----");        
        fileRead.getContent();
        System.out.println("-----  Read from a url  -----");
        htmlRead.getContent();
    }
}