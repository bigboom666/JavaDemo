import java.io.*;
import java.text.MessageFormat;

public class TestIO {

    public static void main(String[] args) throws Exception {

        testSerialize();


    }

    //�ļ� �ֽ���  FileInputStream FileOutputStream
    public static void test01() throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //�����ֽ����������

            fileInputStream = new FileInputStream(new File("./IO/test.txt"));
            fileOutputStream = new FileOutputStream(new File("./IO/test2.txt"));

            int hasRead;
            byte[] fileArray = new byte[1024];
            byte[] b = new byte[]{1,2,3,4,5,6,7,8,9,10,11};
            while ((hasRead = fileInputStream.read(fileArray)) > 0) {
                //System.out.println(new String(fileArray, 0, hasRead));
                System.out.println(new String(b));
            }

            String a = "abc123";

            fileOutputStream.write(b);//û�л�����������Ҫflush   �ֽ���Ĭ�ϲ�ʹ�û�����


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //�ļ� �ַ���  fileReader      Ϊʲô�������룿��������������������������������������������������������
    public static void test02() throws FileNotFoundException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //�����ֽ�������
            fileReader = new FileReader(new File("./IO/test.txt"));
            fileWriter = new FileWriter(new File("./IO/test2.txt"));

            int hasRead;
            char[] fileArray = new char[1024];
            while ((hasRead = fileReader.read(fileArray)) > 0) {
                //System.out.println(new String(fileArray, 0, hasRead));
                System.out.println(fileArray);
            }

            //OutputStreamWriter
            fileWriter.write(fileArray);
            fileWriter.flush();    //Ϊʲô���Ҫflush��OutputStreamWriter��  �����и���������
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //������
    public static void test03() throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("./IO/test.txt"));
            fileOutputStream = new FileOutputStream(new File("./IO/test2.txt"));
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] byteArray = new byte[1024];
            int hasRead = 0;

            if ((hasRead = bufferedInputStream.read(byteArray)) > 0) ;

            bufferedOutputStream.write(byteArray);
            bufferedOutputStream.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
                //�������������ʹ���˻��������ļ�������������ֻ�ر��˻������������Ҫע��һ�£�������ʹ�ô������׽ӵ��ڵ����ϵ�ʹ�õ�ʱ��ֻ��Ҫ�ر����ϲ�Ĵ���Ϳ����ˡ�java���Զ������ǹر��²�Ľڵ�����
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


//DataInputStream  DataOutputStream
// ����ļ��Ƿ���ڣ����򴴽�
    public static void checkFile(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();// �����༶Ŀ¼
            try {
                file.createNewFile();// �����ļ����˴���Ҫ�����쳣
                System.out.println("�����ļ��ɹ���");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
// ��ȷԴ�ļ���Ŀ���ļ�
    public static void test04() throws IOException {
        myWrite();
        myReader();
    }


    private static void myWrite() throws IOException {
// TODO Auto-generated method stub
// �����������������
        File o = new File("./IO/test.txt");// Դ�ļ�
        File t = new File("./IO/test2.txt");// Ŀ���ļ�
        checkFile(o);
        checkFile(t);
        FileOutputStream fos = new FileOutputStream(o);
        DataOutputStream dos = new DataOutputStream(fos);
// д����
        dos.writeByte(10);
        dos.writeShort(100);
        dos.writeInt(1000);
        dos.writeLong(10000);
        dos.writeFloat(12.34F);
        dos.writeDouble(12.56);
        dos.writeChar('a');
        dos.writeBoolean(true);
// �ͷ���Դ
        dos.close();
    }


    private static void myReader() throws IOException {
// TODO Auto-generated method stub
// ������������������
        File o = new File("./IO/test.txt");// Դ�ļ�
        FileInputStream fis = new FileInputStream(o);
        DataInputStream dis = new DataInputStream(fis);
// ������
        byte b = dis.readByte();
        short s = dis.readShort();
        int i = dis.readInt();
        long l = dis.readLong();
        float f = dis.readFloat();
        double d = dis.readDouble();
        char c = dis.readChar();
        boolean bl = dis.readBoolean();
// �ͷ���Դ
        dis.close();
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(bl);
    }


//ת����

    //ʹ�������ֽ�����ת����ָ�������ж�ȡ�ļ�����      ��ʾ�����ַ��ܷ���
    public static void readTest2() throws IOException{
        File file = new File("./IO/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //�����ֽ�����ת��������ָ�������ж�ȡ
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
        char[] buf = new char[1024];
        int length = 0;
        while((length = inputStreamReader.read(buf))!=-1){
            System.out.println(new String(buf,0,length));
        }
    }

    //ʹ������ֽ�����ת����ָ�����д������
    public static void writeTest2() throws IOException{
        File file = new File("./IO/test2.txt");
        //�������ݵ����ͨ��
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //������ֽ���ת�����ַ�������ָ�������
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
        outputStreamWriter.write("���й��ð�");
        //�ر���Դ
        outputStreamWriter.close();
    }

    //����׼���룬����ת����
    public static void readTest() throws IOException{
        InputStream in = System.in; //��ȡ�˱�׼����������
//      System.out.println("���� ���ַ���"+ (char)in.read());  //read()һ��ֻ�ܶ�ȡһ���ֽڡ�
        //��Ҫ���ֽ���ת�����ַ�����
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        //ʹ���ַ����Ļ�����
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = null;
        while((line = bufferedReader.readLine())!=null){
            System.out.println("���ݣ�"+ line);
        }
    }



    //������  ���л�

    /**
     * <p>ClassName: TestObjSerializeAndDeserialize<p>
     * <p>Description: ���Զ�������л��ͷ�����<p>
     * @author xudp
     * @version 1.0 V
     * @createTime 2014-6-9 ����03:17:25
     */


        public static void testSerialize() throws Exception {

            Person person = new Person();
            person.setName("linchong");
            person.setAge(25);
            person.setSex("��");
            item itemA = new item("pen");
            person.itemA= itemA;



            SerializePerson(person);//���л�Person����
            Person p = DeserializePerson();//������Perons����

            System.out.println("personitem"+person.itemA.hashCode());
            System.out.println("pitem"+p.itemA.hashCode());

            System.out.println("person"+person.hashCode());
            System.out.println("p"+p.hashCode());


            System.out.println(MessageFormat.format("name={0},age={1},sex={2}", p.getName(), p.getAge(), p.getSex()));
        }

        /**
         * MethodName: SerializePerson
         * Description: ���л�Person����
         * @author xudp
         * @throws FileNotFoundException
         * @throws IOException
         */
        private static void SerializePerson(Person person) throws FileNotFoundException, IOException {

            // ObjectOutputStream �������������Person����洢��E�̵�Person.txt�ļ��У���ɶ�Person��������л�����
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("./IO/Person.txt")));
            oo.writeObject(person);
            System.out.println("Person�������л��ɹ���");
            oo.close();
        }

        /**
         * MethodName: DeserializePerson
         * Description: ������Perons����
         * @author xudp
         * @return
         * @throws Exception
         * @throws IOException
         */
        private static Person DeserializePerson() throws Exception, IOException {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                    new File("./IO/Person.txt")));
            Person person = (Person) ois.readObject();
            System.out.println("Person�������л��ɹ���");
            return person;
        }


}






/**
 * <p>ClassName: Person<p>
 * <p>Description:���Զ������л��ͷ����л�<p>
 * @author xudp
 * @version 1.0 V
 * @createTime 2014-6-9 ����02:33:25
 */
 class Person implements Serializable {

    /**
     * ���л�ID
     */
    private static final long serialVersionUID = -5809782578272943999L;


    private int age;
    private String name;
    private String sex;
    private int neverUse;
    public item itemA;


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}


class item implements Serializable{
    private String name;
    public item(String a){
        this.name =a ;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}