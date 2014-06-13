package iterator;

/**
 *	������ģʽ(Iterator)��������ģʽ����˳�����һ���ۼ��е�Ԫ�ض����ر�¶�ۼ����ڲ�����
 *				����������һ���γɵ������֮Ϊ�ۼ����ۼ��������ܹ�����һ��������������
 *				������ģʽ�������߼���װ��һ���������Ӷ����У��Ӷ���ۼ����������������ģʽ���˾ۼ��Ľ��档
 *				ÿһ���ۼ����󶼿�����һ����һ�����ϵĵ����Ӷ���ÿһ�������ӵĵ���״̬�����Ǳ˴˶����ġ�
 *				�����㷨���Զ����ھۼ���ɫ�仯��  
 */
public class Test  {
    public static void main(String[] args) {
        String fileName = "d:\\JavaProject\\Iterator\\src\\data.txt";
        DataVector dataVector = new DataVector(fileName);
        Iterator iVector = dataVector.CreateIterator();
        for(iVector.First(); ! iVector.IsDone(); iVector.Next()) {
            iVector.CurrentItem();
        }
    }
}