package details;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class DataFileApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DataFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Welcome to Spring boot app!");

//		DbService service = new DbService();
//		service.createTable();
//		service.insertDataFromCSV();

	}
}
