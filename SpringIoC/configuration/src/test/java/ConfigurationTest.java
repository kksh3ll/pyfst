import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jhana.Bean2;
import top.jhana.MyConfiguration;


public class ConfigurationTest {

    @Test
    public void test() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Bean2 bean2 = ac.getBean("bean2", Bean2.class);
        System.out.println("bean2 = " + bean2);
    }

}
