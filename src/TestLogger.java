import java.util.logging.*;

public class TestLogger {
	public static void main(String[] args) {
		
		//全局日志记录器
		Logger.getGlobal().info("全局日志记录器");  
		
		
		Logger log = Logger.getLogger("com");
		
		log.setLevel(Level.WARNING);
		Logger log2 = Logger.getLogger("com.xiya");
		log2.info("111");
		log2.severe("222");
		log2.warning("333");

		log2.setLevel(Level.ALL);
		
		log2.severe("严重");
		log2.warning("警告");
		log2.info("信息");
		log2.config("配置");
		log2.fine("良好");
		log2.finer("较好");
		log2.finest("最好");

		
	}
}
