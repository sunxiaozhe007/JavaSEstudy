package AWT;
/**
 * 使用Frame创建窗口
 */
import java.awt.Frame;

public class FrameTest {
	public static void main(String[] args) {
		Frame f = new Frame("测试窗口");
		//设置窗口位置大小
		f.setBounds(50,50,800,800);
		//将窗口显示出来（Frame对象默认处于隐藏状态）
		f.setVisible(true);
	}

}
