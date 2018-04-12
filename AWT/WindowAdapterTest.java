package AWT;
/**
 * 重写WindowClosing方法
 * @author Administrator
 *
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import java.awt.TextArea;


public class WindowAdapterTest {
	private Frame f = new Frame("test");
	private TextArea t = new TextArea(6,40);
    public void init() {
		f.addWindowListener(new MyListener());
		f.add(t);
		f.pack();
		f.setVisible(true);
		
	}
	class MyListener extends WindowAdapter
	{
		public void windowClosing(WindowEvent e) {
			System.out.println("关闭窗口");
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new WindowAdapterTest().init();
	}
	
	

}
