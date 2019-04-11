package top.jhana;

public class Bean2 {

    public Bean2() {
        System.out.println("Bean2被加载...");
    }

    public void initMethod() {
        System.out.println("init method...");
    }

    public void destroyMethod() {
        System.out.println("destroy method...");
    }
}
