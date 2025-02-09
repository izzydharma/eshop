package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void testProductCreationAndVerification(ChromeDriver driver) {
        // Step 1: Navigate to the product creation page
        navigateToProductCreationPage(driver);

        // Step 2: Verify that we are on the correct page
        verifyProductCreationPageTitle(driver);

        // Step 3: Fill in the product details
        fillProductDetails(driver, "Test Product", "10");

        // Step 4: Submit the form
        submitProductForm(driver);

        // Step 5: Verify redirection to the product list page
        verifyRedirectionToProductListPage(driver);

        // Step 6: Check if the new product appears in the product list
        verifyProductInList(driver, "Test Product", "10");
    }

    private void navigateToProductCreationPage(ChromeDriver driver) {
        driver.get(baseUrl + "/product/create");
    }

    private void verifyProductCreationPageTitle(ChromeDriver driver) {
        assertEquals("Create New Product", driver.getTitle(), "Page title should be 'Create New Product'");
    }

    private void fillProductDetails(ChromeDriver driver, String productName, String productQuantity) {
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.sendKeys(productName);

        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        quantityInput.sendKeys(productQuantity);
    }

    private void submitProductForm(ChromeDriver driver) {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
    }

    private void verifyRedirectionToProductListPage(ChromeDriver driver) {
        assertTrue(driver.getCurrentUrl().contains("/product/list"), "Should be redirected to the product list page");
    }

    private void verifyProductInList(ChromeDriver driver, String expectedProductName, String expectedProductQuantity) {
        WebElement addedProductName = driver.findElement(By.xpath("//td[contains(text(), '" + expectedProductName + "')]"));
        WebElement addedProductQuantity = driver.findElement(By.xpath("//td[contains(text(), '" + expectedProductQuantity + "')]"));

        assertEquals(expectedProductName, addedProductName.getText(), "Product name should match");
        assertEquals(expectedProductQuantity, addedProductQuantity.getText(), "Product quantity should match");
    }
}