package AutomationPracticeLyrics;

import Utils.SeleniumDriver;
import Utils.WaitMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLostOnYou extends SeleniumDriver {
    LostOnYouLyricsPage lostOnYouLyricsPage;
    WaitMethods waitMethods = new WaitMethods();

    @BeforeMethod
    public void beforeTest() {
        lostOnYouLyricsPage = PageFactory.initElements(driver,LostOnYouLyricsPage.class);
    }

    // BEFORE RUNNING THIS, MAKE SURE TO PUT YOU HEADPHONES ON AND LISTEN TO THE SONG!!!!
    // I made sure to put the Youtube link here to make it easier for you. So just hit RUN.
    // I intentionally commented the driver.quit command so I will let you the opportunity to listen the entire song if you want.

    @Test
    public void isThatLostOnYou() {
        goToUrl("https://www.youtube.com/watch?v=hn3wJ1_1Zsg");
        waitMethods.sleep(5);
        switchToNewTab();
        goToUrl("https://www.lyrics.com/lyric/32484149/LP/Lost+on+You");

        System.out.println("You are listening to " + lostOnYouLyricsPage.countLetters(lostOnYouLyricsPage.getLyrics()) + " letters....");
        System.out.println("...that make up beautiful lyrics containing the word 'you' " + lostOnYouLyricsPage.countOccurrences("you", lostOnYouLyricsPage.getLyrics()) + " times." );
        System.out.println("\nNow take your favourite lyric and rephrase it...");
        System.out.println("like: 'And you're still mine'");
        System.out.println("\nI rephrased it like this: ");
        System.out.println(lostOnYouLyricsPage.rephraseLyrics("And you're still mine"));
        System.out.println("\nKidding...the randomizer did that :D\n");
        System.out.println("\nNow let me present you THE AMAZING HASHMAP:\n");
        lostOnYouLyricsPage.makeHashmap(lostOnYouLyricsPage.makeListFromLyrics("And you're still mine").get(3).toString());


    }
}
