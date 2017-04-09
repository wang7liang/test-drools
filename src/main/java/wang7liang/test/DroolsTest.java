package wang7liang.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by wang7liang on 2017/4/9.
 */
public class DroolsTest {
    public static final void main(String[] args){
        KieServices kServices = KieServices.Factory.get();
        KieContainer kContainer = kServices.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);

        kSession.insert(message);
        kSession.fireAllRules();

        System.out.println(message.toString());


    }
}
