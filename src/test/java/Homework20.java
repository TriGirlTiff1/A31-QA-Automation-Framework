import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework20 extends MyBaseTest {

    @Test
    public void DeletePlaylistTest() throws InterruptedException {
        String playlistName = "Tiff's New Stuff";

        login("ghoulishgirl@hotmail.com", "te$t$tudent");
        clickPlaylistIcon();
        clickNewPlaylistOption();


        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);

        WebElement testPlaylist = driver.findElement(By.xpath("//li[@class='playlist playlist']//a[1]"));
        testPlaylist.click();

        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();

        WebElement deletePopUpMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(deletePopUpMessage.isDisplayed());

    }


    public void clickPlaylistIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='Create a new playlist']")));
        WebElement addPlaylistIcon = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        addPlaylistIcon.click();
    }

    public void clickNewPlaylistOption(){
//        added this workaround for the issue that clicks the playlist icon but no options
        try {
            WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
            newPlaylist.click();
        }
        catch (Exception e){
        refreshCurrentPage();
            clickPlaylistIcon();
            WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
            newPlaylist.click();
        }
    }







}
