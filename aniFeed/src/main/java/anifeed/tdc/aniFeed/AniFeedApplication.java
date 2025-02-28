package anifeed.tdc.aniFeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AniFeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AniFeedApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot(){
		return "Welcome to AniFeed!";
	}
}
