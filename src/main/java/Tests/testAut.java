package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class testAut {
    public static void main (String[] args){

        System.setProperty("webdriver.chrome.driver", "D:\\pruebasMoyano\\pruebaAut\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        try {


            // Navegar a la página de login
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");



            // Maximizar la ventana del navegador
            driver.manage().window().maximize();

            // Esperar un poco para asegurarse de que la página se carga completamente
            Thread.sleep(2000);

            // Encontrar los campos de usuario y contraseña
            WebElement usernameField = driver.findElement(By.name("username"));
            WebElement passwordField = driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

            // Ingresar las credenciales
            usernameField.sendKeys("Admin");
            passwordField.sendKeys("admin123");

            // Hacer clic en el botón de login
            loginButton.click();

            Thread.sleep(3000);

            if (driver.getCurrentUrl().contains("dashboard")) {
                System.out.println("Inicio de sesión exitoso.");
            } else {
                System.out.println("Error al iniciar sesión.");
                return;
            }

            // Acceder a la pestaña "Reclutamiento"
            WebElement recruitmentTab = driver.findElement(By.xpath("//span[text()='Recruitment']"));
            recruitmentTab.click();

            Thread.sleep(2000);

            // Verificar que se abrió la pestaña "Reclutamiento"
            if (driver.getCurrentUrl().contains("recruitment")) {
                System.out.println("Accediste a la pestaña 'Reclutamiento'.");
            } else {
                System.out.println("Error al acceder a la pestaña 'Reclutamiento'.");
            }
            // Localizar el botón "Add"
            WebElement addButton = driver.findElement(By.xpath("//button[contains(., 'Add')]"));
            addButton.click();

            Thread.sleep(2000);

            // Localizar los campos de entrada en el formulario
            WebElement firstNameField = driver.findElement(By.name("firstName"));
            WebElement middleNameField = driver.findElement(By.name("middleName"));
            WebElement lastNameField = driver.findElement(By.name("lastName"));

            // Ingresar los datos en los campos
            firstNameField.sendKeys("Oscar");
            middleNameField.sendKeys("Andres");
            lastNameField.sendKeys("Roa");

            // Localizar el botón "Save" y hacer clic
            WebElement saveButton = driver.findElement(By.xpath("//button[contains(., 'Save')]"));
            saveButton.click();

            Thread.sleep(2000);

            // Verificar si el candidato se agrego exitosamente
            if (driver.getCurrentUrl().contains("viewCandidates")) {
                System.out.println("Candidato agregado con éxito.");
            } else {
                System.out.println("Error al guardar el candidato.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            //driver.quit();
        }
    }
    }

