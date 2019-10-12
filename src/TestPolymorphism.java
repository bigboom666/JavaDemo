public class TestPolymorphism {


    public static void main(String[] args) {
        Father son = new Son();

        System.out.println(son.name);//father
        //子类的对象(由父类的引用handle)调用到的是父类的成员变量。所以必须明确，运行时（动态）绑定针对的范畴只是对象的方法。
        //怎么得到子类的成员变量？
        //既然动态绑定针对方法，那就整个方法。
        System.out.println(son.getName());//son
    }
}

class Father {
    String name = "father";

    public String getName() {
        return name;
    }
}

class Son extends Father{
    String name = "son";

    @Override
    public String getName() {
        return name;
    }
}