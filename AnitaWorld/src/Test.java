/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arvin
 */
public class Test {

    public static void main(String[] args) {
        Cow[] c = new Cow[5];
        c[0] = new Cow(0, 1);
        if (c[0] == null) {
            System.out.println("gggggggg");
        }
        A a = new A();
        a.a();
        if (a instanceof B) {
            System.out.println("test");
        }
    }
}

class A {
    public void a() {
        System.out.println("a");
    }
}

class B extends A {
    @Override
    public void a() {
        System.out.println("b");
    }
}
