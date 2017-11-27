package org.kevin.Main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.kevin.dao.mapper.UserMapper;
import org.kevin.dao.model.User;
import org.kevin.dao.model.UserExample;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Kevin.Z on 2017/11/27.
 */
public class Tet {
    public static void main(String[] args) {
        try {
            String source="mybatis-config.xml";
            InputStream is = Tet.class.getClassLoader().getResourceAsStream(source);
            SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = fac.openSession();

            UserMapper userMapper = session.getMapper(UserMapper.class);
            /*User u = new User();
            u.setEmail("229270808@qq.com");
            u.setName("kevin");
            u.setPhone("18814127752");
            int insert = userMapper.insert(u);
            session.commit();
            System.out.println(insert);*/

            UserExample userExample = new UserExample();
            userExample.createCriteria().andEmailEqualTo("229270808@qq.com");
            List<User> models = userMapper.selectByExample(userExample);
            for(User ur:models){
                System.err.println(ur.getName() + " - " + ur.getId());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
