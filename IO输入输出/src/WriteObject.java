import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 使用ObjectOutputStream将Person对象写入磁盘文件
 * @author Administrator
 *
 */
public class WriteObject {
	public static void main(String[] args){
		try(
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.txt")))
		{
			Person per = new Person("sunxiaozhe", 1000);
			oos.writeObject(per);
		}
		catch (IOException e) {
				e.printStackTrace();
		}
	}

}
