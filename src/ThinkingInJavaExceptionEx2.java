
class MyObj
{
	//构造方法里传递msg
	String name;
	public MyObj (String msg ) {
		this.name = msg;
	}
	
	public void PrintMyObj (){
		System.out.println(this.name);
	}
	
}

public class ThinkingInJavaExceptionEx2
{
	
	
	public static void main (String[] args) 
	{
		//MyObj obj1 = new MyObj("obj001");
		MyObj obj1 = null;
	try{
		obj1.PrintMyObj();
	}
	catch (Exception e){
		System.out.println("catch MyException");
		System.out.println(e);
	}
	finally {
		System.out.println("this is finally block");
	}
	}
}
