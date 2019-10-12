import java.util.ArrayList;

//�˴�T�������дΪ�����ʶ����������T��E��K��V����ʽ�Ĳ��������ڱ�ʾ����
//��ʵ����������ʱ������ָ��T�ľ�������
public class TestGeneric<T> {

	// key�����Ա����������ΪT,T���������ⲿָ��
    private T key;

    public TestGeneric(T key) { // ���͹��췽���β�key������ҲΪT��T���������ⲿָ��
        this.key = key;
    }




	public TestGeneric( ) {

	}

    public T getKey() { // ���ͷ���getKey�ķ���ֵ����ΪT��T���������ⲿָ��
        return key;
    }


    public static <T> T testT(T tempT) {
        System.out.println(tempT.getClass().getName());
        return tempT;
    }

    public static void test4() {
        TestGeneric.testT(6);
    }



/*        public static T one;   //�������
        public static T show(T one) { //�������
            return null;
        }*/



    public static void test1() {
        // ���͵����Ͳ���ֻ���������ͣ������Զ����ࣩ�������Ǽ�����
        // �����ʵ���������뷺�͵����Ͳ���������ͬ����ΪInteger.
        TestGeneric<Integer> genericInteger = new TestGeneric<Integer>(123456);

		TestGeneric<?> g = new TestGeneric<>();

		//TestGeneric<Integer>[] table = new TestGeneric<Integer>[10];
		System.out.println(g.key);

        // �����ʵ���������뷺�͵����Ͳ���������ͬ����ΪString.
/*
        TestGeneric<String> genericString = new TestGeneric<String>("key_vlaue");
        System.out.println("���Ͳ���:key is " + genericInteger.getKey());
        System.out.println("���Ͳ���:key is " + genericString.getKey());
*/

    }

    //δ���뷺�Ͳ���
    public static void test2() {
        int tempA = 001;
        TestGeneric gint = new TestGeneric(001);
        TestGeneric gstring = new TestGeneric("002");
        System.out.println(gint.key);
        System.out.println(gstring.key);
    }


    //�����ڱ���׶���Ч
    public static void test3() {

        ArrayList<String> a = new ArrayList<String>();  //��������
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add("001");
        b.add(666);

        Class c1 = a.getClass();  //��ȡ���͵�����
        Class c2 = b.getClass();
        System.out.println(c1); //���true
        System.out.println(c2);
    }


    public static void main(String[] args) {
        //TestGeneric.test3();
        test1();
    }

}
