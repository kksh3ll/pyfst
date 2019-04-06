package top.jhana;

import org.junit.Before;
import org.junit.Test;
import top.jhana.car.Audio;
import top.jhana.car.Buick;
import top.jhana.human.Human;
import top.jhana.human.Lisi;
import top.jhana.human.Zhansan;

public class SpringIoCTest {

    private Containner containner = new Containner();

    @Before
    public void before() {
        containner.setBean(Audio.class, "audio");
        containner.setBean(Buick.class, "buick");
        containner.setBean(Zhansan.class, "zhangsan", "audio");
        containner.setBean(Lisi.class, "lisi", "buick");
    }

    @Test
    public void test() {
        Human zhangsan = (Human) containner.getBean("zhangsan");
        zhangsan.gohome();
        Human lisi = (Human) containner.getBean("lisi");
        lisi.gohome();
    }
}
