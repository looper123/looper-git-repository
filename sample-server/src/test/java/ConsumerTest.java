import com.quark.cloud.SampleServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZhenpengLu on 2017/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleServerApplication.class)
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
