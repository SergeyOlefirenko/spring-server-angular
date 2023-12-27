package spring.angular;

//import lombok.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.angular.model.Task;
import spring.angular.repository.TaskRepository;
import java.util.stream.Stream;
//@Data
@SpringBootApplication
public class SpringAngularApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringAngularApplication.class, args);
    }

    @Bean
    CommandLineRunner init(TaskRepository taskRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Task task = new Task(name, name.toLowerCase() + "@test.mail");
                taskRepository.save(task);
            });
            taskRepository.findAll().forEach(System.out::println);
        };
    }

}
