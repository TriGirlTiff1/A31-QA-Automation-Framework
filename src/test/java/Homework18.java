import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends MyBaseTest{

    @Test
    public void playSongTest(){
        navigateToPage();
        login("ghoulishgirl@hotmail.com", "te$t$tudent");
        playSong();
        isSongPlaying();

    }

    public void playSong(){
        WebElement playNext = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNext.click();
        playButton.click();

    }
    public void isSongPlaying(){

        WebElement soundBar = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

}
