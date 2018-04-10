package TestMap;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * Map常用默认方法的功能和用法
 * @author Administrator
 *
 */
public class MapTest2 {
	public static void main(String[] args) {
		Map map = new HashMap();
		//放入key-value对
		map.put("sun", 4444);
		map.put("xiao", 5555);
		map.put("zhe", 6666);
		//尝试替换key为“sun”的value，map中没有对应的key，所以不会添加新的 key-value对
		map.replace("ssss", 8888);
		System.out.println(map);
		//使用原value与传入参数计算出来的结果覆盖原有的value
		map.merge("sun", 4, (oldval,param) -> (Integer)oldval + (Integer)param);//sun的value增加了4
		System.out.println(map);
		//当key为aaa对应的value不存在时，使用计算结果做为新的value
		map.computeIfAbsent("aaa", (key) -> ((String)key).length());
		//map中添加了key=aaa；value=3的key-value对
		System.out.println(map);
		//当key为aaa对应的value存在时，使用计算结果为新的value
		map.computeIfPresent("aaa", (key,value) -> (Integer)value*(Integer)value);
		//map中aaa的value由3变为9
		System.out.println(map);
	}

}
