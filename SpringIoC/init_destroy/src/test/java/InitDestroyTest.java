import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDestroyTest {

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        ac.getBean();
    }
}
