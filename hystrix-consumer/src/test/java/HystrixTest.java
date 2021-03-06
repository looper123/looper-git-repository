import com.quark.cloud.ConsumerApplication;
import com.quark.cloud.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZhenpengLu on 2017/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConsumerApplication.class)  //注入spring容器
public class HystrixTest {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RestTemplate restTemplate;

    @Test
   public void testHystrix(){

        String body = restTemplate.getForEntity("http://SAMPLE/hello", String.class).getBody();
//        helloService.helloConsumer();
   }
}
