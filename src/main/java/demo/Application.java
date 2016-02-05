package demo;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.TxRunnable;
import org.avaje.agentloader.AgentLoader;
import org.example.domain.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    protected static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);


        if (!AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent", "debug=1;packages=org.example.**")) {
            System.out.println("avaje-ebeanorm-agent not found in classpath - not dynamically loaded");
        }

        EbeanServer server = Ebean.getServer(null);
        server.execute(new TxRunnable() {
            public void run() {
                Country c = new Country();
                c.setCode("NZ");
                c.setName("New Zealand");
                server.save(c);

                Country au = new Country();
                au.setCode("AU");
                au.setName("Australia");
                server.save(au);
            }
        });
    }

}