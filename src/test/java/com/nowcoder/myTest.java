package com.nowcoder;

import com.nowcoder.dao.LoginTicketDAO;
import com.nowcoder.dao.NewsDAO;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.dao.studentDAO;
import com.nowcoder.model.LoginTicket;
import com.nowcoder.model.News;
import com.nowcoder.model.Student;
import com.nowcoder.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
public class myTest {
    @Autowired
    UserDAO userDAO;
    @Autowired
    studentDAO studentDao;

    @Test
    public void test() {
      /*  User user = new User();
        user.setPassword("ppp");
        user.setId(36);
        userDAO.updatePassword(user);
        Assert.assertEquals("ppp", userDAO.selectById(36).getPassword());
        Assert.assertEquals("ppp",userDAO.selectBypassword("ppp").getPassword());*/
   /*     Student student =new Student();
        student.setStudentName("张三");
        student.setStudentTercher("冯源");
        student.setStudentClass("一班");

//        Assert.assertNotNull( studentDao.addStudent(student));
        Assert.assertEquals("张三",studentDao.selectByStudentId(1).getStudentName());
        studentDao.deletStudentByid(1);

        Assert.assertNull(studentDao.selectByStudentId(1));
*/

    }
}
