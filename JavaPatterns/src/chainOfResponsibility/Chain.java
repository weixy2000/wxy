package chainOfResponsibility;

/**
 * �����������ӿڣ������ͨ��AddChain������̬�޸�������
 */
public interface Chain {
	/**
	 * ������������
	 * 
	 * @param c
	 *            ���
	 */
	public abstract void addChain(Chain c);

	/**
	 * ���ݵ��¸����������
	 * 
	 * @param mesg
	 *            ��Ϣ
	 */
	public abstract void sendToChain(String mesg);

	/**
	 * ��ȡ���������
	 * 
	 * @return
	 */
	public abstract Chain getChain();
}