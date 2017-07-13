package com.jwen.login;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jwen.login.dao.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {

        /* userRepository.save(new User("jwen", "1234"));
        userRepository.save(new User("hah", "sss"));
        userRepository.save(new User("zzz", "xxxx"));*/

        /* List<User> users = userRepository.findAll();
        
        
        for (User user : users){
            System.out.println(user.getName() +" , "+user.getPassword());
        }*/
        // Assert.assertEquals(10, userRepository.findAll().size());
        System.err.println("---------------------------");
        System.err.println(userRepository.findByName("jwen").get(0).getName());

        if (userRepository.findByName("jwen").isEmpty()) {

            System.out.println("用户名  " + "jwen" + " 注册成功");

        } else {

            System.out.println("用户名 " + "jwen" + "已被占用！");
        }

    }

}
