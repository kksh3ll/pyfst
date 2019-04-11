import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jhana.Bean2;

public class InitTest {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        Bean2 bean2 = ac.getBean("bean2", Bean2.class);

        System.out.println("bean2 = " + bean2);
    }
}
