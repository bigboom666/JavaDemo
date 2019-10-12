import java.util.ArrayList;

public class TestClone {

    public static void main(String[] args) {

        test1();
    }


    private static void test1() {
        // ԭʼ����
        Student stud = new Student("���", "���潣��");
        System.out.println("ԭʼ����: " + stud.getName() + " - " + stud.getSubj().getName());

        // ��������
        Student clonedStud = (Student) stud.clone();
        System.out.println("��������: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());

        // ԭʼ����Ϳ��������Ƿ�һ����
        System.out.println("ԭʼ����Ϳ��������Ƿ�һ��: " + (stud == clonedStud));
        // ԭʼ����Ϳ��������name�����Ƿ�һ��
        System.out.println("studname: " + stud.getName().hashCode() );
        System.out.println("studname: " + clonedStud.getName().hashCode() );
        System.out.println("ԭʼ����Ϳ��������name�����Ƿ�һ��: " + (stud.getName().hashCode() == clonedStud.getName().hashCode()));
        // ԭʼ����Ϳ��������subj�����Ƿ�һ��
        System.out.println("ԭʼ����Ϳ��������subj�����Ƿ�һ��: " + (stud.getSubj() == clonedStud.getSubj()));

        stud.setName("С���");
        stud.getSubj().setName("���潣�����");
        System.out.println("���º��ԭʼ����: " + stud.getName() + " - " + stud.getSubj().getName());
        System.out.println("����ԭʼ�����Ŀ�¡����: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());
    }

    private static void test2(){
        //���ϵ�ǳ����
        ArrayList<Student> studentArray = new ArrayList<>();
        Student studentA = new Student("�ֳ�","����ͷ");
        Student studentB = new Student("�����","��ʥ");
        studentArray.add(studentA);
        studentArray.add(studentB);

        ArrayList<Student> dalaoArray = (ArrayList<Student>) studentArray.clone();
        System.out.println(studentArray);
        System.out.println(dalaoArray);


    }

    private static void test3(){

        ArrayList<Student> studentArray = new ArrayList<>();
        Student studentA = new Student("�ֳ�","����ͷ");
        Student studentB = new Student("�����","��ʥ");
        studentArray.add(studentA);
        studentArray.add(studentB);

        ArrayList<Student> dalaoArray = new ArrayList<>();

        //add����ǳ����
/*        for(Student c:studentArray){
            dalaoArray.add(c);
        }*/

        //���ϵ����
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
            // ֱ�ӵ��ø����clone()����
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

class Student implements Cloneable {
    // ��������
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
        //���
        try {
            Student newStudent = (Student)super.clone();
            newStudent.subj = (Subject) this.subj.clone();
            return newStudent;

        } catch (CloneNotSupportedException e) {
            return null;
        }

/*        // ����������������һ���¶��������ͺ�ԭʼ�����໥����
        Student s = new Student(name, subj.getName());
        return s;
        */

    }




}