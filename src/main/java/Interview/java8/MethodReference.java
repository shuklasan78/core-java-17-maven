package Interview.java8;
interface Sayable{
    void say();
}
public class MethodReference {
    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }
    public static void main(String[] args) {
        Sayable sayable = MethodReference::saySomething;
        // Calling interface method
        sayable.say();

        sayable = MethodReference::saySomething2;
        sayable.say();
        //TODO
        //sayable = MethodReference::saySomething3;
        //sayable.say();
    }

    public static void saySomething2(){
        System.out.println("Hello, this is static method 2.");
    }

    public static void saySomething3(String s){
        System.out.println("Hello, this is static method 3.");
    }
}
