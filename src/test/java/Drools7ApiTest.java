import com.drools.model.Car;
import com.drools.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class Drools7ApiTest {
    
    @Test
    public void testDrool7Api(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("all-rules");

        Person p1 = new Person();
        p1.setAge(30);
        Car c1 = new Car();
        c1.setPerson(p1);

        Person p2 = new Person();
        p2.setAge(70);
        Car c2 = new Car();
        c2.setPerson(p2);

        kieSession.insert(c1);
        kieSession.insert(c2);

        int count = kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("Fire"+count+" rule(s)!");
        System.out.println("The discount of c1 is "+c1.getDiscount()+"%");
        System.out.println("The discount of c2 is "+c2.getDiscount()+" %");

    }
}
