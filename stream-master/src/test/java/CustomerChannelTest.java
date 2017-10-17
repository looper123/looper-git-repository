import com.quark.cloud.StreamApplication;
import com.quark.cloud.receiver.MySink;
import com.quark.cloud.receiver.MySource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZhenpengLu on 2017/10/13.
 * 自定义通道接口发送消息
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StreamApplication.class)  //注入spring容器
public class CustomerChannelTest {

    @Autowired
    private MySource mySource;

//    注入通道名称
    @Autowired @Qualifier(MySink.CHANNEL_NAME)
    private MessageChannel channel;

    @Test
    public void testOutputMessage(){
        boolean sendFlag = mySource.myOutput().send(MessageBuilder.withPayload("from my customer output").build());
        System.out.println("MessageChannel---------"+channel+"----sendFlag------"+sendFlag);
    }
}
