package org.vaadin.tunis.blood_donation;


import org.persistence.User;
import org.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * SpringBootApplication's Entry point
 * 
 * @author HaithemMosbahi
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages={"org.persistence.repository"})
@EntityScan(basePackages={"org.persistence"})
public class BloodDonationApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		// Test DataBase ( memory DataBase )..Add user
		User user=new User();
		user.setFullName("TestUser");
		user.setEmail("elmosbahihaithem@gmail.com");
		userRepository.save(user);
		
	}
}
