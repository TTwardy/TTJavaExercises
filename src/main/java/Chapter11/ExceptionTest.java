package Chapter11;

public class ExceptionTest {
    public static void main(String[] args) {
//        try{
//            method1();
//        }
//        catch (ExceptionA exception){
//            System.out.println("exceptionA caught");
//        }
//        try{
//            method2();
//        }
//        catch (ExceptionA exception){
//            System.out.println("exceptionB caught");
//        }
//        try{
//            method3();
//        }
//        catch (ExceptionA exception){
//            System.out.println("exceptionC caught");
//        }

//Next EXERCISE

//        try{
//            method1();
//        }
//        catch (Exception exception){
//            System.out.println("Exception caught");
//        }
//        try{
//            NPEthrower();
//        }
//        catch (Exception exception){
//            System.out.println("NPE caught");
//            exception.printStackTrace();
//        }

//Next EXERCISE
        try {
            callerMethod();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception caught");
        }

    }

    public static void callerMethod (){
        try {
            newPhone();
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }
    public static void newPhone () throws ValidationException {
        Phone phone = new Phone("test", "");
//            System.out.println("done");
//        try{
//            Phone phone = new Phone("test", "");
//            System.out.println("done");
//        }
//        catch (ValidationException e){
//            System.out.println("ValidationException caught");
//        }
    }
    public static void method1 () throws ExceptionA{
        throw new ExceptionA();
    }
    public static void method2 () throws ExceptionB{
        throw new ExceptionB();
    }
    public static void method3 () throws ExceptionC{
        throw new ExceptionC();
    }
    public static void NPEthrower () throws NullPointerException{
        throw new NullPointerException();
    }
}
