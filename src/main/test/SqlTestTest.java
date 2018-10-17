import com.happy.PropertyApiApplication;
import com.happy.dao.impl.SqlTestDao;
import com.happy.entity.bo.SqlTestBo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjun
 * @Title: SqlTestTest
 * @ProjectName newHappy
 * @Description: TODO
 * @date 2018/10/15 12:10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PropertyApiApplication.class)
@WebAppConfiguration
public class SqlTestTest {

    @Autowired
    private SqlTestDao sqlTestDao;

    private Integer pageSize = 100;

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        List<SqlTestBo> sqlTestBoList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            SqlTestBo sqlTestBo = new SqlTestBo();
            sqlTestBo.setName("wangjun");
            sqlTestBo.setNumber("007");
            sqlTestBo.setAge(30);
            sqlTestBo.setSex("男");
            sqlTestBo.setProfession("it程序员");
            sqlTestBoList.add(sqlTestBo);
        }
        /*for (int i = 0; i < 2000/pageSize; i++) {
            List<SqlTestBo> sqlTestBoList = new ArrayList<>();
            for (int j = 0; j < pageSize; j++) {
                SqlTestBo sqlTestBo = new SqlTestBo();
                sqlTestBo.setName("wangjun");
                sqlTestBo.setNumber("001");
                sqlTestBo.setAge(30);
                sqlTestBo.setSex("男");
                sqlTestBo.setProfession("it程序员");
                sqlTestBoList.add(sqlTestBo);
            }
            sqlTestDao.insertBatch(sqlTestBoList);
        }*/
        sqlTestDao.insertBatch(sqlTestBoList);
        long endTime = System.currentTimeMillis();
        System.out.println("time=" + (endTime-startTime));
    }

    @Test
    public void mssqlTest() {
        long startTime = System.currentTimeMillis();
        int size = 90000;
        if (size/pageSize == 0) {
            List<SqlTestBo> sqlTestBoList = new ArrayList<>();
            for (int j = 0; j < 50; j++) {
                SqlTestBo sqlTestBo = new SqlTestBo();
                sqlTestBo.setName("wangjun");
                sqlTestBo.setNumber("001");
                sqlTestBo.setAge(30);
                sqlTestBo.setSex("男");
                sqlTestBo.setProfession("it程序员");
                sqlTestBoList.add(sqlTestBo);
            }
            sqlTestDao.insertBatch(sqlTestBoList);
            long endTime = System.currentTimeMillis();
            System.out.println("time=" + (endTime-startTime));
            return;
        }
        for (int i = 0; i < size/pageSize; i++) {
            List<SqlTestBo> sqlTestBoList = new ArrayList<>();
            for (int j = 0; j < pageSize; j++) {
                SqlTestBo sqlTestBo = new SqlTestBo();
                sqlTestBo.setName("wangjun");
                sqlTestBo.setNumber("001");
                sqlTestBo.setAge(30);
                sqlTestBo.setSex("男");
                sqlTestBo.setProfession("it程序员");
                sqlTestBoList.add(sqlTestBo);
            }
            sqlTestDao.insertBatch(sqlTestBoList);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time=" + (endTime-startTime));
    }
}
