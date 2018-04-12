package AWT;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 
 * @author Administrator
 *
 */
public class WindowListenerTest {
    private Frame f  = new Frame("test");
    private TextArea ta = new TextArea(5,30);
    public void init()
    {
    	f.addWindowListener(new MyListener());
        f.addWindowListener(new MyListener());//addWindowListener报错，
        f.add(ta,BorderLayout.NORTH);
        f.pack();
        f.setVisible(true);
    }
class MyListener implements WindowListener{

	 public void windowActivated(WindowEvent e) {
		 ta.append("窗口激活!\n");
	 }
	 public void windowClosed(WindowEvent e) {
		 ta.append("窗口关闭\n");
	 }
	 public void windowClosing(WindowEvent e) {
		 ta.append("用户关闭窗口\n");
		 System.exit(0);
	 }
	 public void windowDeactivated(WindowEvent e) {
		 ta.append("窗口失去焦点\n");
	 }
	 public void windowDeiconified(WindowEvent e) {
		 ta.append("窗口被回复\n");
	 }
	 public void windowIconified(WindowEvent e) {
		 ta.append("窗口被最小化\n");
	 }
	 public void windowOpened(WindowEvent e) {
		 ta.append("窗口初次被打开\n");
	 }
}
 
public static void main(String []args)
    {
        new  WindowListenerTest().init();
    }    
}
