import java.util.logging.*;

public class TestLogger {
	public static void main(String[] args) {
		
		//ȫ����־��¼��
		Logger.getGlobal().info("ȫ����־��¼��");  
		
		
		Logger log = Logger.getLogger("com");
		
		log.setLevel(Level.WARNING);
		Logger log2 = Logger.getLogger("com.xiya");
		log2.info("111");
		log2.severe("222");
		log2.warning("333");

		log2.setLevel(Level.ALL);
		
		log2.severe("����");
		log2.warning("����");
		log2.info("��Ϣ");
		log2.config("����");
		log2.fine("����");
		log2.finer("�Ϻ�");
		log2.finest("���");

		
	}
}
