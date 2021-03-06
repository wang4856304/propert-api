package user;

import com.alibaba.fastjson.JSONObject;
import com.happy.PropertyApiApplication;
import com.happy.entity.Response;
import com.happy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PropertyApiApplication.class)
@WebAppConfiguration
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        String token = "0208A19992E8C1D3F0CDBE5E4FAFFE50";
        String userId = userService.getUserIdByToken(token);
        System.out.println(userId);
        Response response = userService.getUserInfo(token);
        System.out.println(JSONObject.toJSONString(response));
    }
}
