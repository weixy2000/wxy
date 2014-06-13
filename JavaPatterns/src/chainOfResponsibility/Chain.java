package chainOfResponsibility;

/**
 * 定义责任链接口，你可以通过AddChain方法动态修改责任链
 */
public interface Chain {
	/**
	 * 添加责任链结点
	 * 
	 * @param c
	 *            结点
	 */
	public abstract void addChain(Chain c);

	/**
	 * 传递到下个责任链结点
	 * 
	 * @param mesg
	 *            消息
	 */
	public abstract void sendToChain(String mesg);

	/**
	 * 获取责任链结点
	 * 
	 * @return
	 */
	public abstract Chain getChain();
}