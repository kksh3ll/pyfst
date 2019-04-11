import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jhana.Bean2;

public class DestroyTest {

    @Test
    public void test() {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        Bean2 bean2 = ac.getBean("bean2", Bean2.class);

        System.out.println("bean2 = " + bean2);

        ac.close();
    }

}
