package demo;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class SampleWebFreeMarkerApplicationSubTestsHelper {

    /**
     * call by real test
     * @param port
     * @throws Exception
     */
    public void FreeMarkerTemplate2(int port) throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate()
                .getForEntity("http://localhost:" + port + "/welcomeandy/", String.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.getBody(), containsString("Hello, Andy"));
    }


}