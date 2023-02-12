import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Mr.Gao
 * @date: 2022年05月22日 11:13
 * @description:
 */
public class TestScopeBeanCreate {

    private ApplicationContext applicationContext;

    /**
     * 创建Spring容器
     */
    @Before
    public void before() {
        System.out.println("Spring 容器开始启动...!");
        applicationContext = new ClassPathXmlApplicationContext("testBeans.xml");
        System.out.println("Spring 容器启动完毕...!");
    }


    /**
     * 从容器中获取单例Bean
     */
    @Test
    public void test() {
        System.out.println("---------单例bean，每次获取的bean实例都一样---------");
        System.out.println(applicationContext.getBean("beanScopeModel"));
        System.out.println(applicationContext.getBean("beanScopeModel"));
        System.out.println(applicationContext.getBean("beanScopeModel"));
    }
}
