package br.com.springbootconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Value("${my.greeting: default value}")
	private String greetingMessage;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	@Value("#{${my.db.values}}")
	private Map<String, String> mapValues;
	
	@Autowired
	private DbSettings dbSettings;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/greeting")
	public String greeting() {
//		return this.greetingMessage + this.listValues + this.mapValues;
		return this.dbSettings.getConnection() + this.dbSettings.getHost();
	}
	
	@GetMapping("/envdetails")
	public String envdetails() {
		return this.environment.toString();
	}

}
