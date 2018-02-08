package everything;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /*
    @Bean
    public CommandLineRunner addressBookRepository(AddressBookRepository repository) {
        return (args) -> {

        };
    }

    @Bean
    public CommandLineRunner buddyInfoRepository(BuddyInfoRepository repository) {
        return (args) -> {
            repository.save(new BuddyInfo("a", 1));
            repository.save(new BuddyInfo("b", 2));
            repository.save(new BuddyInfo("c", 3));

            log.info("Buddies found with findAll():");
            log.info("-----------------------------");
            for (BuddyInfo buddyInfo : repository.findAll()) {
                log.info(buddyInfo.toString());
            }
            log.info("");

            BuddyInfo buddyInfo = repository.findOne(1L);
            log.info("Buddy found with findOne(1L):");
            log.info("-----------------------------");
            log.info(buddyInfo.toString());
            log.info("");

            log.info("Buddy found with findByName('a'):");
            log.info("---------------------------------");
            for (BuddyInfo a : repository.findByName("a")) {
                log.info(a.toString());
            }
            log.info("");
        };
    }
    */
}
