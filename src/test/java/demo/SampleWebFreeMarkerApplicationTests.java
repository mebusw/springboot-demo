package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;


/**
 * Basic integration tests for FreeMarker application.
 *
 * @author Phillip Webb
 * @author Andy Wilkinson
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SampleWebFreeMarkerApplicationTests {

    @Autowired
    private HttpSession httpSession;

    @Value("${local.server.port}")
    private int port;


    @Component
    @EnableWebSecurity
    @Order(0)
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest().permitAll();
        }
    }

    @Test
    public void testFreeMarkerTemplate() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate()
                .getForEntity("http://localhost:" + this.port + "/welcomeandy/", String.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.getBody(), containsString("Hello, Andy"));
    }

    @Test
    public void testFreeMarkerErrorTemplate() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

        ResponseEntity<String> responseEntity = new TestRestTemplate("jacky", "123").exchange(
                "http://localhost:" + this.port + "/does-not-exist", HttpMethod.GET,
                requestEntity, String.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.NOT_FOUND));
        assertThat(responseEntity.getBody(), containsString("Something went wrong: 404 Not Found"));
    }

}