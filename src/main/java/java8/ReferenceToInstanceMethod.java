package java8;

interface i1 {
    void s1();
}
public class ReferenceToInstanceMethod {

    public static void main(String[] args) {
        ReferenceToInstanceMethod o1 = new ReferenceToInstanceMethod();
        i1 o2 = o1::sayHello;
        o2.s1();
    }


    private void sayHello() {
        System.out.println("I am saying hello and I am not implementing th interface in the class");
    }

}
