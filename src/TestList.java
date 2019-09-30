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
	 * 测试add/remove/size/isEmpty/contains/clear/toArrays等方法
	 */
	public static void test01() {
		List<String> list = new ArrayList<String>();
		System.out.println(list.isEmpty()); // true,容器里面没有元素
		//list.add();
		list.add("高淇");
		System.out.println(list.isEmpty()); // false,容器里面有元素
		list.add("高小七");
		list.add("高小八");
		list.add("高小八");
		System.out.println(list);
		System.out.println("list的大小：" + list.size());
		System.out.println("是否包含指定元素：" + list.contains("高小七"));
		list.remove("高淇");
		System.out.println(list);
		Object[] objs = list.toArray();
		System.out.println("转化成Object数组：" + Arrays.toString(objs));

		System.out.println("元素对应索引：" + list.indexOf("高小八"));
		System.out.println("索引对应元素：" + list.get(1));

		list.clear();
		System.out.println("清空所有元素：" + list);
	}

	/**
	 * 测试两个容器之间元素处理
	 */
	public static void test02() {
		List<String> list = new ArrayList<String>();
		list.add("高淇");
		list.add("高小七");
		list.add("高小八");
		List<String> list2 = new ArrayList<String>();
		list2.add("高淇");
		list2.add("张三");
		list2.add("李四");
		System.out.println(list.containsAll(list2)); // false list是否包含list2中所有元素
		System.out.println(list);
		// list.addAll(list2); //将list2中所有元素都添加到list中
		// System.out.println(list);
		// list.removeAll(list2); //从list中删除同时在list中存在的元素
		// System.out.println(list);
		list.retainAll(list2); // 取list和list2的交集
		System.out.println(list);
	}

	/**
     * 测试List中关于索引操作的方法
     */
    public static void   test03(){
       List<String> list = new   ArrayList<String>();
       list.add("A");
       list.add("B");
       list.add("C");
       list.add("D");
       System.out.println(list);   //[A, B, C, D]
       list.add(2,"高");
       System.out.println(list);   //[A, B, 高,   C, D]
       list.remove(2);            
       System.out.println(list);   //[A, B, C, D]
       list.set(2, "c");       
       System.out.println(list);   //[A, B, c, D]
       System.out.println(list.get(1));   //返回：B
       list.add("B");
       System.out.println(list);   //[A, B, c, D, B]
       System.out.println(list.indexOf("B"));    //1    从头到尾找到第一个"B"
       System.out.println(list.lastIndexOf("B"));    //4    从尾到头找到第一个"B"
    }


	
	
	
	
}
