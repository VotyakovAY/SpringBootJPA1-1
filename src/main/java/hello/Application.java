package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProjectRepository projectRepository;

//	@Bean
//	public CommandLineRunner demo(CustomerRepository customerRepository) {
	public void run(String... args) {
//		return (args) -> {
			// save a couple of customers
			customerRepository.save(new Customer("Jack", "Bauer"));
			customerRepository.save(new Customer("Chloe", "O'Brian"));
			customerRepository.save(new Customer("Kim", "Bauer"));
			customerRepository.save(new Customer("David", "Palmer"));
			customerRepository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = customerRepository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : customerRepository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
//		};
//	}

//	@Bean
//	public CommandLineRunner demo(ProjectRepository projectRepository) {
		//return (args) -> {
			// save a couple of project
			projectRepository.save(new Project("Project1"));
			projectRepository.save(new Project("Project2"));
			projectRepository.save(new Project("Project3"));
			projectRepository.save(new Project("Project4"));
			projectRepository.save(new Project("Project5"));

			// fetch all customers
			log.info("Project found with findAll():");
			log.info("-------------------------------");
			for (Project project : projectRepository.findAll()) {
				log.info(project.toString());
			}
			log.info("");

			// fetch an individual project by ID
			Project project = projectRepository.findOne(1L);
			log.info("Project found with findOne(1L):");
			log.info("--------------------------------");
			log.info(project.toString());
			log.info("");

			// fetch project by name
			log.info("Project found with findByName('Project3'):");
			log.info("--------------------------------------------");
			for (Project project3 : projectRepository.findByName("Project3")) {
				log.info(project3.toString());
			}
			log.info("");
		};
//	}
}
