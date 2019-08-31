package springbooth2.demo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    private UserRepository userRepository;

//    @Test
//    public void testSave() throws Exception {
//        User user = new User();
//        user.setName("ay");
//        user.setUrl("https://huangwenyi.com");
//        User result = userRepository.save(user);
//        Assertions.assertThat(result).isNotNull();
//    }
//
//    @Test
//    public void testFindOne() throws Exception{
//        User user = userRepository.findById(1L).get();
//        Assertions.assertThat(user).isNotNull();
//        Assertions.assertThat(user.getId()).isEqualTo(1);
//    }
//
//    @Test
//    public void testFindByName() throws Exception{
//        User user = userRepository.findByName("ay");
//        Assertions.assertThat(user).isNotNull();
//        Assertions.assertThat(user.getName()).isEqualTo("ay");
//    }

}
