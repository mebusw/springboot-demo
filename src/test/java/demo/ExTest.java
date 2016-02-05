package demo;

import demo.web.Home;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ExTest {

    @Autowired
    Home home;

    RestTemplate template = new TestRestTemplate();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test1() {
        assertEquals(1, 1);
    }

//    @Test
//    public void testRequest() throws Exception {
//        MockMvc mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//
//    }

    @Test
    public void testSpringBean() {
        assertNotNull(home);
    }

}
