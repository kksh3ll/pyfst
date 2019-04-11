package top.jhana;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyInitTest {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("Context被加载...");

        Bean2 bean2 = ac.getBean("bean2", Bean2.class);
        System.out.println("bean2 = " + bean2);
    }

}
