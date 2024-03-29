//自定义异常
class MyException extends Exception
{
	//构造方法里传递msg
	public MyException(String msg)
	{
		super(msg);
		System.err.println("MyException");
	}
}

public class ThinkingInJavaExceptionEx1
{
	//清楚写的是啥 在类里  在哪个类里  还是在方法里
	public static void f() throws MyException
	{
		throw new MyException("e1");
	}
	
	public static void main (String[] args) 
	{
	//MyException e1 =new MyException("mye1");
	//怎么throw    1.try里 throw跟异常对象  2.方法名跟throws 异常类
	try{
		 f();
	}
	catch (MyException e){
		System.out.println("catch MyException");
	}
	finally {
		System.out.println("this is finally block");
	}
	}
}





// exceptions/Ex1.java
// TIJ4 Chapter Exceptions, Exercise 1, page 452
/* Create a class with a main(0 that throws an object of class Exception
* inside a try block. Give the constructor for Exception a String argument.
* Catch the exception inside a catch clause and print the String argument.
* Add a finally clause and print a message to prove you were there.
*/
/*
class Exception1 extends Exception {
	public Exception1(String msg) {
		super(msg);
		System.out.println("Exception1(String msg)");
	}
}

public class Ex1 {
	public static void f() throws Exception1  {
		System.out.println("Throwing MyException from f()");
		throw new Exception1("From f()");
	}
	public static void main(String[] args) {
		try {
			f();
		} catch(Exception1 e) {
			System.err.println("Caught Exception1");
			e.printStackTrace();
		} finally {
			System.out.println("Made it to finally");
		}

	}
}

*/