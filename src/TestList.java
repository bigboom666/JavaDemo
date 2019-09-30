import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.*;



public class TestList {
	
//	 String s ="ssss";
	

	public static void main(String[] args) {
		test01();
		

	}

	/**
	 * ����add/remove/size/isEmpty/contains/clear/toArrays�ȷ���
	 */
	public static void test01() {
		List<String> list = new ArrayList<String>();
		System.out.println(list.isEmpty()); // true,��������û��Ԫ��
		//list.add();
		list.add("���");
		System.out.println(list.isEmpty()); // false,����������Ԫ��
		list.add("��С��");
		list.add("��С��");
		list.add("��С��");
		System.out.println(list);
		System.out.println("list�Ĵ�С��" + list.size());
		System.out.println("�Ƿ����ָ��Ԫ�أ�" + list.contains("��С��"));
		list.remove("���");
		System.out.println(list);
		Object[] objs = list.toArray();
		System.out.println("ת����Object���飺" + Arrays.toString(objs));

		System.out.println("Ԫ�ض�Ӧ������" + list.indexOf("��С��"));
		System.out.println("������ӦԪ�أ�" + list.get(1));

		list.clear();
		System.out.println("�������Ԫ�أ�" + list);
	}

	/**
	 * ������������֮��Ԫ�ش���
	 */
	public static void test02() {
		List<String> list = new ArrayList<String>();
		list.add("���");
		list.add("��С��");
		list.add("��С��");
		List<String> list2 = new ArrayList<String>();
		list2.add("���");
		list2.add("����");
		list2.add("����");
		System.out.println(list.containsAll(list2)); // false list�Ƿ����list2������Ԫ��
		System.out.println(list);
		// list.addAll(list2); //��list2������Ԫ�ض���ӵ�list��
		// System.out.println(list);
		// list.removeAll(list2); //��list��ɾ��ͬʱ��list�д��ڵ�Ԫ��
		// System.out.println(list);
		list.retainAll(list2); // ȡlist��list2�Ľ���
		System.out.println(list);
	}

	/**
     * ����List�й������������ķ���
     */
    public static void   test03(){
       List<String> list = new   ArrayList<String>();
       list.add("A");
       list.add("B");
       list.add("C");
       list.add("D");
       System.out.println(list);   //[A, B, C, D]
       list.add(2,"��");
       System.out.println(list);   //[A, B, ��,   C, D]
       list.remove(2);            
       System.out.println(list);   //[A, B, C, D]
       list.set(2, "c");       
       System.out.println(list);   //[A, B, c, D]
       System.out.println(list.get(1));   //���أ�B
       list.add("B");
       System.out.println(list);   //[A, B, c, D, B]
       System.out.println(list.indexOf("B"));    //1    ��ͷ��β�ҵ���һ��"B"
       System.out.println(list.lastIndexOf("B"));    //4    ��β��ͷ�ҵ���һ��"B"
    }


	
	
	
	
}
