import java.util.ArrayList;

public class TestClone {

    public static void main(String[] args) {

        test1();
    }


    private static void test1() {
        // 原始对象
        Student stud = new Student("杨充", "潇湘剑雨");
        System.out.println("原始对象: " + stud.getName() + " - " + stud.getSubj().getName());

        // 拷贝对象
        Student clonedStud = (Student) stud.clone();
        System.out.println("拷贝对象: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());

        // 原始对象和拷贝对象是否一样：
        System.out.println("原始对象和拷贝对象是否一样: " + (stud == clonedStud));
        // 原始对象和拷贝对象的name属性是否一样
        System.out.println("studname: " + stud.getName().hashCode() );
        System.out.println("studname: " + clonedStud.getName().hashCode() );
        System.out.println("原始对象和拷贝对象的name属性是否一样: " + (stud.getName().hashCode() == clonedStud.getName().hashCode()));
        // 原始对象和拷贝对象的subj属性是否一样
        System.out.println("原始对象和拷贝对象的subj属性是否一样: " + (stud.getSubj() == clonedStud.getSubj()));

        stud.setName("小杨逗比");
        stud.getSubj().setName("潇湘剑雨大侠");
        System.out.println("更新后的原始对象: " + stud.getName() + " - " + stud.getSubj().getName());
        System.out.println("更新原始对象后的克隆对象: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());
    }

    private static void test2(){
        //集合的浅拷贝
        ArrayList<Student> studentArray = new ArrayList<>();
        Student studentA = new Student("林冲","豹子头");
        Student studentB = new Student("孙悟空","大圣");
        studentArray.add(studentA);
        studentArray.add(studentB);

        ArrayList<Student> dalaoArray = (ArrayList<Student>) studentArray.clone();
        System.out.println(studentArray);
        System.out.println(dalaoArray);


    }

    private static void test3(){

        ArrayList<Student> studentArray = new ArrayList<>();
        Student studentA = new Student("林冲","豹子头");
        Student studentB = new Student("孙悟空","大圣");
        studentArray.add(studentA);
        studentArray.add(studentB);

        ArrayList<Student> dalaoArray = new ArrayList<>();

        //add都是浅拷贝
/*        for(Student c:studentArray){
            dalaoArray.add(c);
        }*/

        //集合的深拷贝
        for(Student c:studentArray){
            dalaoArray.add((Student) c.clone());
        }

        System.out.println(studentArray);
        System.out.println(dalaoArray);


    }



}


class Subject implements Cloneable {

    private String name;
    public Subject(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }
    public void setName(String s) {
        name = s;
    }
    public Object clone() {
        try {
            // 直接调用父类的clone()方法
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

class Student implements Cloneable {
    // 对象引用
    private Subject subj;
    private String name;
    public Student(String s, String sub) {
        name = s;
        subj = new Subject(sub);
    }
    public Subject getSubj() {
        return subj;
    }
    public String getName() {
        return name;
    }
    public void setName(String s) {
        name = s;
    }

    public Object clone() {
        //深拷贝
        try {
            Student newStudent = (Student)super.clone();
            newStudent.subj = (Subject) this.subj.clone();
            return newStudent;

        } catch (CloneNotSupportedException e) {
            return null;
        }

/*        // 深拷贝，创建拷贝类的一个新对象，这样就和原始对象相互独立
        Student s = new Student(name, subj.getName());
        return s;
        */

    }




}