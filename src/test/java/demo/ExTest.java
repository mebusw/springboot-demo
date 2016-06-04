package demo;

import demo.web.CustomerController;
import demo.web.HomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ExTest {

    @Autowired
    HomeController homeController;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test1() {
        assertEquals(1, 1);
    }

    @Test
    public void testSpringBean() {
        assertNotNull(homeController);
    }


    /**
     * Spring boot encapsulate mockMvc as TestRestTemplate
     *
     * @throws Exception
     */
    @Test
    public void testCustomerController() throws Exception {
        final String BASE_URL = "http://localhost:8080/";
        MockMvc mockMvc;
        mockMvc = standaloneSetup(new CustomerController()).build();

        mockMvc.perform(get("/customers/")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string("[1,2,3]"));

        mockMvc.perform(get("/customers/987")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().string("CustomerController = 987"));

    }
}
