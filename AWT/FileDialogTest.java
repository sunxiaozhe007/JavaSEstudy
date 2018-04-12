package AWT;
/**
 * 使用FileDialog来创建打开/保存文件的对话框
 */
import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Frame;
import javax.swing.JButton;


public class FileDialogTest {
	Frame f = new Frame("测试");
	//创建两个对话框
	FileDialog d1 = new FileDialog(f,"选择需要打开文件", FileDialog.LOAD);
    FileDialog d2 = new FileDialog(f, "选择保存文件的路径", FileDialog.SAVE);
    JButton b1 = new JButton("打开文件");
    JButton b2 = new JButton("保存文件");
    
    public void init() {
    	b1.addActionListener(e -> {
    		d1.setVisible(true);
    		//打印用户选择的文件路径和文件名
    		System.out.println(d1.getDirectory()+d1.getFile());
    	});
    	b2.addActionListener(e ->{
    		d2.setVisible(true);
    		System.out.println(d2.getDirectory()+d2.getFile());
    	});
    	f.add(b1);
    	f.add(b2,BorderLayout.SOUTH);
    	f.pack();
    	f.setVisible(true);
    	
    }
    
    public static void main(String[] args) {
		new FileDialogTest().init();
	}
	

}
