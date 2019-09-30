import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


public class TestMap {
public static void main(String[] args) {
		test01();
	}

//增删改查   遍历
	public static void test01() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("窝窝头", "4");
		map.put("烤面筋", "可好吃了");
		System.out.println(map);
		
		
		//遍历
		for (String key : map.keySet()) {
		    System.out.println(key + " ：" + map.get(key));
		}
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + " ：" + entry.getValue());
		}
		
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext())
		{
			String key = iterator.next();
			System.out.println(key + " ：" + map.get(key));
		}
		

		
		
		
		String valueGet = map.get("key1");
		System.out.println(valueGet);
		map.remove("key1");
		map.clear();
	}
	
	
	
	
	
	
	
	
}