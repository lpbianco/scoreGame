package com.br.pipa.rest.scoreGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.br.pipa.rest.scoreGame.repository.ScoreGameRepository;

@SpringBootApplication
public class ScoreGameApplication {

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ScoreGameRepository scoreGameRepository() {
	    return new ScoreGameRepository();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ScoreGameApplication.class, args);
	}
}
