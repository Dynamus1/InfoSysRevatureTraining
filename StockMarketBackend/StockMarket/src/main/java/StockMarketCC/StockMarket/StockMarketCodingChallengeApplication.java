package StockMarketCC.StockMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EntityScan("com.revature.models")
@EnableTransactionManagement
@EnableJpaRepositories("com.revature.repo")
@EnableJpaAuditing
@SpringBootApplication
public class StockMarketCodingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketCodingChallengeApplication.class, args);
	}

}
