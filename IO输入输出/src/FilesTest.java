import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Files类的用法
 * @author Administrator
 *
 */
public class FilesTest {
	public static void main(String[] args) throws Exception {
		//复制文件
		Files.copy(Paths.get("D:\\JAVA文件\\IO输入输出\\src\\FilesTest.java"), new FileOutputStream("a.txt"));
		//判断FilesTest.java文件是否为隐藏文件
		System.out.println("FilesTest.java是否为隐藏文件：" + Files.isHidden(Paths.get("D:\\JAVA文件\\IO输入输出\\src\\FilesTest.java")));
		//一次性读取FilesTest.java文件的所有行
		List<String> lines = Files.readAllLines(Paths.get("FilesTest.java") , Charset.forName("gbk"));
		System.out.println(lines);
		//判断指定文件的大小
		System.out.println("FilesTest.java的大小为：" + Files.size(Paths.get("D:\\JAVA文件\\IO输入输出\\src\\FilesTest.java")));
		List<String> poem = new ArrayList<>();
		poem.add("sssssssss");
		poem.add("xxxxxxxxxxx");
		//直接将多个字符串内容写入指定文件中
		Files.write(Paths.get("poem.txt"), poem, Charset.forName("gbk"));
		//列出当前目录下所有为文件和子目录
		Files.list(Paths.get(".")).forEach(path->System.out.println(path));
		//读取文件内容
		Files.lines(Paths.get("FilesTest.java") , Charset.forName("gbk")).forEach(line-> System.out.println(lines));
		FileStore cStore = Files.getFileStore(Paths.get("C:"));
		//判断C盘总空间和可用空间
		System.out.println("C:共有空间：" + cStore.getTotalSpace());
		System.out.println("C:可用空间：" + cStore.getUsableSpace());
		
	}

}
