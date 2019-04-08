package top.jhana;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jhana.beans.Bean2;

public class BeanTest {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        Bean2 bean2_1 = ac.getBean(bean2, Bean2.class);

        Bean2 bean2_2 = ac.getBean(bean2, Bean2.class);
    }
}
