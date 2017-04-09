package wang7liang.test;

import org.drools.compiler.kproject.ReleaseIdImpl;
import org.drools.core.io.impl.UrlResource;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wang7liang on 2017/4/9.
 */
public class RemoteTest {
    public static void main(String[] args) throws IOException {
        String url = "http://192.168.1.100:8080/kie-drools/maven2/wang7liang/test/test-drools/1.0.0/test-drools-1.0.0.jar";
        ReleaseIdImpl releaseId = new ReleaseIdImpl("wang7liang.test","test-drools","LATEST");
        KieServices ks = KieServices.Factory.get();
        KieRepository kr = ks.getRepository();
        UrlResource urlResource = (UrlResource) ks.getResources().newUrlResource(url);
        urlResource.setUsername("tomcat");
        urlResource.setPassword("tomcat");
        urlResource.setBasicAuthentication("enabled");
        InputStream is = urlResource.getInputStream();
        KieModule kModule = kr.addKieModule(ks.getResources().newInputStreamResource(is));
        KieContainer kContainer = ks.newKieContainer(kModule.getReleaseId());
        StatelessKieSession kSession = kContainer.newStatelessKieSession("defaultStatelessKieSession");

        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);

        kSession.execute(message);

        System.out.println(message.toString());
    }
}
