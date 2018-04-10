package TestMap;
/**
 * Map基本功能
 * 
 */
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

public class MapTest1 {
	public static void main(String[] args) {
		Map map = new HashMap();
		//成对放入多个key-value对
		map.put("sunxiaozhe", 99);
		map.put("xiao", 1000);
		map.put("zhe", 89);
		map.put("sssss", 78);
		//value可以重复
		map.put("dddddd", 78);
		//多次放入的key相同时value会被覆盖
		System.out.println(map.put("zhe", 999));
		System.out.println(map);
		//判断是否包含指定key
		System.out.println(map.containsKey("zhe"));
		//判断是否包含指定value
		System.out.println(map.containsValue(999));
		//获取map集合的所有key集合，通过遍历key实现遍历所有key-value对
		for(Object key : map.keySet()) {
			System.out.println(key + "-->" + map.get(key));
		}
		//根据key删除key-value对
		map.remove("zhe");
		System.out.println(map);
	}

}
