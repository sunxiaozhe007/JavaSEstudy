import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 读取Person对象
 * @author Administrator
 *
 */
public class ReadObject {
	public static void main(String[] args) throws ClassNotFoundException {
		try(
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.txt")))
		{
			Person p = (Person)ois.readObject();
			System.out.println("姓名："+p.getName()+"\n年龄:"+p.getAge());
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
