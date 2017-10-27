import com.quark.cloud.service.MyDiscovery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZhenpengLu on 2017/10/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractTest {



    @Test
    public void testPriority(){
        MyDiscovery.MyTransport transport =new MyDiscovery.MyTransport();
        transport.myInter.register("info");
    }
}
