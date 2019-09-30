import java.io.*;

public class TestIO {
	
    public static void main(String[] args) throws IOException {
        // ����̨  BufferedReader
        //test01();
        //test02();
        //test03();
    	//�������ļ�  
        //test04();
        //test05();
    	//�ı�д��Ͷ�ȡ  write() ������ append()
    	//test06();
    	//test07();
    	//test08();
    	//test09();
    	//�ı�д��Ͷ�ȡ InputStreamReader �� OutputStreamWriter       �ļ������ڻ��Զ�����
    	test10();
    	test11();
    }

    public static void test01() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("������һ���ַ�");
        char c;
        c = (char) bufferedReader.read();
        System.out.println("��������ַ�Ϊ"+c);
    }

    public static void test02() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("������һ���ַ����� q ������");
        char c;
        do {
            c = (char) bufferedReader.read();
            System.out.println("��������ַ�Ϊ"+c);
        } while (c != 'q');
    }

    public static void test03() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("������һ���ַ�");
        String str = bufferedReader.readLine();
        System.out.println("��������ַ�Ϊ" + str);
    }


    public static void test04() throws IOException {
        byte[] bytes = {12,21,34,11,21};
        createFile(new File("").getAbsolutePath()+"/io/test.txt") ;
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath()+"/io/test.txt");
        // д��������ļ���ֱ�Ӵ򿪻��������
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }


    public static void test05() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath()+"/io/test.txt");
        int c;
        // ��ȡд��Ķ������ļ�������ֽ�����
        while ((c = fileInputStream.read()) != -1) {
            System.out.print(c);
        }
    }
    
    

    public static void test06() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath()+"/io/test.txt");
        fileWriter.write("Hello��world��\n��ӭ���� java ����\n");
        fileWriter.write("���Ḳ���ļ�ԭ��������\n");
//        fileWriter.write(null); ����ֱ��д�� null
        fileWriter.append("������׷��һ�����ݣ���Ҫ���������Ի�\n");
        fileWriter.append(null);
        fileWriter.flush();
        System.out.println("�ļ���Ĭ�ϱ���Ϊ" + fileWriter.getEncoding());
        fileWriter.close();
    }


    public static void test07() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("").getAbsolutePath()+"/io/test.txt", false); // �ر�׷��ģʽ����Ϊ����ģʽ
        fileWriter.write("Hello��world����ӭ���� java ����\n");
        fileWriter.write("���������ļ�ԭ��������");
        fileWriter.append("������һ��");
        fileWriter.flush();
        System.out.println("�ļ���Ĭ�ϱ���Ϊ" + fileWriter.getEncoding());
        fileWriter.close();
    }


    public static void test08() throws IOException {
        FileReader fileReader = new FileReader(new File("").getAbsolutePath()+"/io/test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        fileReader.close();
        bufferedReader.close();
    }

    public static void test09() throws IOException {
        FileReader fileReader = new FileReader(new File("").getAbsolutePath()+"/io/test.txt");
        int c;
        while ((c = fileReader.read()) != -1) {
            System.out.print((char) c);
        }
    }

    
//�ļ������ڻ��Զ�����
    public static void test10() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath()+"/io/test2.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK"); // ʹ�� GBK �����ļ�
        outputStreamWriter.write("Hello��world��\n��ӭ���� java ����\n");
        outputStreamWriter.append("����һ������");
        outputStreamWriter.flush();
        System.out.println("�ļ��ı���Ϊ" + outputStreamWriter.getEncoding());
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    public static void test11() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath()+"/io/test2.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK"); // ʹ�� GBK �����ļ�
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
    }

    
    
    
    
//�����ļ�
      static boolean createFile(String destFileName) {
        File file = new File(destFileName);
        //�ж�Ŀ���ļ����ڵ�Ŀ¼�Ƿ����
        if(!file.getParentFile().exists()) {
            //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼
            System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");
            if(!file.getParentFile().mkdirs()) {
                System.out.println("����Ŀ���ļ�����Ŀ¼ʧ�ܣ�");
                return false;
            }
        }
        //����Ŀ���ļ�
        try {
            if (file.createNewFile()) {
                System.out.println("���������ļ�" + destFileName + "�ɹ���");
                return true;
            } else {
                System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("���������ļ�" + destFileName + "ʧ�ܣ�" + e.getMessage());
            return false;
        }
    }
	

	
}
