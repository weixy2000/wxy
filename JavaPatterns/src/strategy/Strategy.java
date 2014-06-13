package strategy;

/**
 * 公共接口，支持多种多样的策略算法
 * </p>
 * The public interface to support varies arithmetic
 */
public interface Strategy {
	/**
	 * 绘制文本方法
	 * 
	 * @param s
	 *            绘制内容
	 * @param lineWidth
	 *            行宽
	 * @param lineCount
	 *            行数
	 */
	public void drawText(String s, int lineWidth, int lineCount);
}