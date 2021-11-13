package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.poj.ChatPage;
import com.udacity.jwdnd.c1.review.poj.LoginPage;
import com.udacity.jwdnd.c1.review.poj.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private String baseUrl;

	private SignupPage signupPage;
	private LoginPage loginPage;
	private ChatPage chatPage;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	static void afterAll() {
		driver.quit();
	}

	@BeforeEach
	void beforeEach() {
		baseUrl = "http://localhost:"+port;
	}

	@Test
	void testSignupToChat() {
		String firstname = "Selenium";
		String lastname = "Test";
		String username = "jasetest";
		String password = "password";
		String message = "Hello! spring";

		driver.get(baseUrl+"/signup");
		signupPage = new SignupPage(driver);
		signupPage.signup(firstname, lastname, username, password);

		driver.get(baseUrl+ "/login");
		loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		chatPage = new ChatPage(driver);
		chatPage.setMessageField(message);
		chatPage.submitChat();

		ChatMessage sentMessage = chatPage.getChatMessage();

		assertEquals(username, sentMessage.getUsername());
		assertEquals(message, sentMessage.getMessage());
	}

}
