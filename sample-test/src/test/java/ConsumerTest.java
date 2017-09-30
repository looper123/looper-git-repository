import com.quark.cloud.SampleTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZhenpengLu on 2017/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleTestApplication.class)
public class ConsumerTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test1(){
        ResponseEntity<String> entity = restTemplate.
                getForEntity("http://SAMPLE/hello", String.class);
        System.out.println("result---------------"+entity.getBody());
    }



}
