package top.jhana;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Containner {

    private Map<String, Object> map = new ConcurrentHashMap<String, Object>();

    public Object getBean(String beanId) {
        return map.get(beanId);
    }

    /**
     * 委托IoC容器创建一个bean
     */
    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {

        // 1. 组装构造方法所需要的参数
        Object[] paramValue = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValue[i] = map.get(paramBeanIds[i]);
        }

        // 2. 调用构造方法来实例化bean
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValue);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }

            if (bean == null) {
                throw new RuntimeException("找不到合适的构造函数实例化bean");
            }
        }

        // 3. 将实例化的bean放入beans
        map.put(beanId, bean);
    }
}
