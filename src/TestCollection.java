import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        testTreeSet();
    }

    static void test1() {
        Collection<Integer> c = new ArrayList<Integer>();
        for (Integer i = 0; i < 10; i++) {
            c.add(i);
        }
        for (Integer i : c) {
            System.out.println(i);
        }
    }

    static void test2() {
        Collection<Integer> c = new HashSet<Integer>();
        for (Integer i = 0; i < 10; i++) {
            c.add(0);
        }
        for (Integer i : c) {
            System.out.println(i);
        }
        System.out.println(c);
    }

    static void testAdding() {
        //add()  addAll()
        //Collections.addAll和Arrays.asList，是工具类，使用的是可变参数列表。

        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        // Runs significantly faster, but you can't
        // construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element
        // list.add(21); // Runtime error because the
        // underlying array cannot be resized.

        System.out.println(list);
    }


    static void testHashSet( ) {
        HashSet h=new HashSet();
        h.add("1st");
        h.add("2nd");
        h.add(new Integer(3));
        h.add(new Double(4.0));
        h.add("2nd");            //重复元素，未被添加
        h.add(new Integer(3));      //重复元素，未被添加
        h.add(new Date());
        System.out.println("开始：size="+h.size());
        Iterator it=h.iterator();
        while(it.hasNext())
        {
            Object o=it.next();
            System.out.println(o);
        }

        h.remove("2nd");
        System.out.println("移除元素后：size="+h.size());
        System.out.println(h);
    }





    static void testTreeSet( ) {
        Collection h=new TreeSet();
       // h.add("1st");
       // h.add("2nd");
        h.add(new Integer(3));
        h.add(new Integer(4));
        h.add(new Integer(9));
        //h.add(new Double(4.0));
      //  h.add("2nd");            //重复元素，未被添加
        h.add(new Integer(3));      //重复元素，未被添加
       // h.add(new Date());
        System.out.println("开始：size="+h.size());
        Iterator it=h.iterator();
        while(it.hasNext())
        {
            Object o=it.next();
            System.out.println(o);
        }

        h.remove(3);
        System.out.println("移除元素后：size="+h.size());
        System.out.println(h);
    }


}
