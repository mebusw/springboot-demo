package demo;

import org.avaje.agentloader.AgentLoader;
import org.example.service.LoadExampleData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class Application {

    protected static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);


        if (!AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent", "debug=1;packages=org.example.**")) {
            logger.warn("avaje-ebeanorm-agent not found in classpath - not dynamically loaded");
        }

        LoadExampleData.load();
    }

}