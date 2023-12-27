package spring.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringAngularApplication {

    @Bean
    @ServiceConnection(name = "symptoma/activemq")
    GenericContainer<?> activeMQContainer() {
        return new GenericContainer<>(DockerImageName.parse("symptoma/activemq:latest")).withExposedPorts(61616);
    }

    @Bean
    @ServiceConnection
    KafkaContainer kafkaContainer() {
        return new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
    }
//
//    @Bean
//    @ServiceConnection
//    MariaDBContainer<?> mariaDbContainer() {
//        return new MariaDBContainer<>(DockerImageName.parse("mariadb:latest"));
//    }

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
    }

    public static void main(String[] args) {
        SpringApplication.from(SpringAngularApplication::main).with(TestSpringAngularApplication.class).run(args);
    }

}
