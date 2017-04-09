package wang7liang.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Date;

/**
 * Created by wang7liang on 2017/4/9.
 */
public class XSLTest {
    public static void main(String[] args) {
        KieServices kServices = KieServices.Factory.get();
        KieContainer kContainer = kServices.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-dtables2");

        User user = new User();
        user.setName("张学友");
        user.setLevel(1);
        Order order = new Order();
        order.setBookingDate(new Date());
        order.setAmout(999);
        order.setUser(user);
        order.setScore(0);

        kSession.insert(order);
        kSession.fireAllRules();
        kSession.dispose();

        System.out.println(order.getScore());
    }
}

