package strategy;

/**
 * �����ӿڣ�֧�ֶ��ֶ����Ĳ����㷨
 * </p>
 * The public interface to support varies arithmetic
 */
public interface Strategy {
	/**
	 * �����ı�����
	 * 
	 * @param s
	 *            ��������
	 * @param lineWidth
	 *            �п�
	 * @param lineCount
	 *            ����
	 */
	public void drawText(String s, int lineWidth, int lineCount);
}