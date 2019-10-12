import java.io.*;
import java.text.MessageFormat;

public class TestIO {

    public static void main(String[] args) throws Exception {

        testSerialize();


    }

    //文件 字节流  FileInputStream FileOutputStream
    public static void test01() throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //创建字节输入输出流

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

            fileOutputStream.write(b);//没有缓冲区，不需要flush   字节流默认不使用缓冲区


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //文件 字符流  fileReader      为什么汉字乱码？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
    public static void test02() throws FileNotFoundException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //创建字节输入流
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
            fileWriter.flush();    //为什么这个要flush？OutputStreamWriter看  里面有个缓冲区。
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //缓存流
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
                //上面代码中我们使用了缓存流和文件流，但是我们只关闭了缓存流。这个需要注意一下，当我们使用处理流套接到节点流上的使用的时候，只需要关闭最上层的处理就可以了。java会自动帮我们关闭下层的节点流。
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


//DataInputStream  DataOutputStream
// 检查文件是否存在，否则创建
    public static void checkFile(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();// 创建多级目录
            try {
                file.createNewFile();// 创建文件，此处需要处理异常
                System.out.println("创建文件成功！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
// 明确源文件和目标文件
    public static void test04() throws IOException {
        myWrite();
        myReader();
    }


    private static void myWrite() throws IOException {
// TODO Auto-generated method stub
// 创建数据输出流对象
        File o = new File("./IO/test.txt");// 源文件
        File t = new File("./IO/test2.txt");// 目标文件
        checkFile(o);
        checkFile(t);
        FileOutputStream fos = new FileOutputStream(o);
        DataOutputStream dos = new DataOutputStream(fos);
// 写数据
        dos.writeByte(10);
        dos.writeShort(100);
        dos.writeInt(1000);
        dos.writeLong(10000);
        dos.writeFloat(12.34F);
        dos.writeDouble(12.56);
        dos.writeChar('a');
        dos.writeBoolean(true);
// 释放资源
        dos.close();
    }


    private static void myReader() throws IOException {
// TODO Auto-generated method stub
// 创建数据输入流对象
        File o = new File("./IO/test.txt");// 源文件
        FileInputStream fis = new FileInputStream(o);
        DataInputStream dis = new DataInputStream(fis);
// 读数据
        byte b = dis.readByte();
        short s = dis.readShort();
        int i = dis.readInt();
        long l = dis.readLong();
        float f = dis.readFloat();
        double d = dis.readDouble();
        char c = dis.readChar();
        boolean bl = dis.readBoolean();
// 释放资源
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


//转换流

    //使用输入字节流的转换流指定码表进行读取文件数据      显示中文字符很方便
    public static void readTest2() throws IOException{
        File file = new File("./IO/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //创建字节流的转换流并且指定码表进行读取
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
        char[] buf = new char[1024];
        int length = 0;
        while((length = inputStreamReader.read(buf))!=-1){
            System.out.println(new String(buf,0,length));
        }
    }

    //使用输出字节流的转换流指定码表写出数据
    public static void writeTest2() throws IOException{
        File file = new File("./IO/test2.txt");
        //建立数据的输出通道
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //把输出字节流转换成字符流并且指定编码表。
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
        outputStreamWriter.write("新中国好啊");
        //关闭资源
        outputStreamWriter.close();
    }

    //读标准输入，放入转换流
    public static void readTest() throws IOException{
        InputStream in = System.in; //获取了标准的输入流。
//      System.out.println("读到 的字符："+ (char)in.read());  //read()一次只能读取一个字节。
        //需要把字节流转换成字符流。
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        //使用字符流的缓冲类
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = null;
        while((line = bufferedReader.readLine())!=null){
            System.out.println("内容："+ line);
        }
    }



    //对象流  序列化

    /**
     * <p>ClassName: TestObjSerializeAndDeserialize<p>
     * <p>Description: 测试对象的序列化和反序列<p>
     * @author xudp
     * @version 1.0 V
     * @createTime 2014-6-9 下午03:17:25
     */


        public static void testSerialize() throws Exception {

            Person person = new Person();
            person.setName("linchong");
            person.setAge(25);
            person.setSex("男");
            item itemA = new item("pen");
            person.itemA= itemA;



            SerializePerson(person);//序列化Person对象
            Person p = DeserializePerson();//反序列Perons对象

            System.out.println("personitem"+person.itemA.hashCode());
            System.out.println("pitem"+p.itemA.hashCode());

            System.out.println("person"+person.hashCode());
            System.out.println("p"+p.hashCode());


            System.out.println(MessageFormat.format("name={0},age={1},sex={2}", p.getName(), p.getAge(), p.getSex()));
        }

        /**
         * MethodName: SerializePerson
         * Description: 序列化Person对象
         * @author xudp
         * @throws FileNotFoundException
         * @throws IOException
         */
        private static void SerializePerson(Person person) throws FileNotFoundException, IOException {

            // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("./IO/Person.txt")));
            oo.writeObject(person);
            System.out.println("Person对象序列化成功！");
            oo.close();
        }

        /**
         * MethodName: DeserializePerson
         * Description: 反序列Perons对象
         * @author xudp
         * @return
         * @throws Exception
         * @throws IOException
         */
        private static Person DeserializePerson() throws Exception, IOException {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                    new File("./IO/Person.txt")));
            Person person = (Person) ois.readObject();
            System.out.println("Person对象反序列化成功！");
            return person;
        }


}






/**
 * <p>ClassName: Person<p>
 * <p>Description:测试对象序列化和反序列化<p>
 * @author xudp
 * @version 1.0 V
 * @createTime 2014-6-9 下午02:33:25
 */
 class Person implements Serializable {

    /**
     * 序列化ID
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