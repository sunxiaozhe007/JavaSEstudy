package AWT;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.List;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * 
 * @author Administrator
 *
 */
public class DropTargetTest {
	final int DESKTOP_WIDTH = 480;
	final int DESKTOP_HEIGHT = 360;
	final int FRAME_DISTANCE = 30;
	JFrame jf = new JFrame("测试");
	private JDesktopPane desktop = new JDesktopPane();
	private int nextFrameX;
	private int nextFrameY;
	private int width = DESKTOP_WIDTH / 2;
	private int height = DESKTOP_HEIGHT / 2;
	
	public void init() {
		desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));
		new DropTarget(jf, DnDConstants.ACTION_COPY, new ImageDropTargetListener());
		jf.add(desktop);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	class ImageDropTargetListener extends DropTargetAdapter {
		public void drop(DropTargetDragEvent event) {
			event.acceptDrag(DnDConstants.ACTION_COPY);
			Transferable transferable = event.getTransferable();
			DataFlavor[] flavors = transferable.getTransferDataFlavors();
			for (int i = 0; i < flavors.length; i++) {
				DataFlavor d = flavors[i];
				try
				{
					if (d.equals(DataFlavor.javaFileListFlavor)) {
						List fileList =(List) transferable.getTransferData(d);
						for(Object f : fileList) {
							showImage((File)f , event);
						}
					}
						
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				 event.getDropTargetContext();
				}
		}
		private void showImage(java.io.File f , DropTargetDragEvent event)throws IOException {
			Image image = ImageIO.read(f);
			if (image == null) {
				 event.getDropTargetContext();
				JOptionPane.showInternalMessageDialog(desktop, "系统不支持的文件类型");
				return;
			}
			ImageIcon icon = new ImageIcon(image);
			JInternalFrame iframe = new JInternalFrame(f.getName(), true, true, true, true);
			JLabel imageLabel = new JLabel(icon);
			iframe.add(new JScrollPane(imageLabel));
			desktop.add(iframe);
			iframe.reshape(nextFrameX, nextFrameY, width, height);
			iframe.show();
			nextFrameX += FRAME_DISTANCE;
			nextFrameY += FRAME_DISTANCE;
			if(nextFrameX + width > desktop.getWidth()) {
				nextFrameX = 0;
			}
			if(nextFrameY + height > desktop.getHeight()) {
				nextFrameY = 0;
			}
			
		}
	}
	public static void main(String[] args) {
		new DropTargetTest().init();
	}

}
