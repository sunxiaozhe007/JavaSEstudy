package AWT;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public  class LocalObjectSelection implements Transferable {
	private Object obj;
	public LocalObjectSelection(Object obj) {
		this.obj = obj;
	}
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor[] flavors = new DataFlavor[2];
		Class clazz = obj.getClass();
		String mimeType = "application/x-java-jvm-local-objectref;"+"class="+clazz.getName();
		try
		{
			flavors[0] = new DataFlavor(mimeType);
			flavors[1] = new DataFlavor().stringFlavor;
			return flavors;
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException{
		if (!isDataFlavorSupported(flavor)) {
			throw new UnsupportedFlavorException(flavor);
		}
		if (flavor.equals(DataFlavor.stringFlavor)) {
			return obj.toString();
		}
		return obj;
	}
	
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.equals(DataFlavor.stringFlavor)|| flavor.getPrimaryType().equals("application") && flavor.getSubType().equals("x-java-jvm-local-objectref") && flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
		
	}
	
	

}
