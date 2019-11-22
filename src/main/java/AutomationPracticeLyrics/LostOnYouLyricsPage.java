package AutomationPracticeLyrics;

import Utils.WaitMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class LostOnYouLyricsPage {
    @FindBy(xpath = "//pre[@id = 'lyric-body-text']")
    private WebElement lostOnYouLyrics;

    @FindBy(xpath = "//i[@class = 'fa fa-play']")
    private List<WebElement> playButtons;

    @FindBy(xpath = "//h1[@id='lyric-title-text']")
    private WebElement lostOnYouTitle;

    WaitMethods waitMethods = new WaitMethods();

    public String getLyrics() {
        this.waitMethods.isElementDisplayed(this.lostOnYouLyrics, 5);
        return this.lostOnYouLyrics.getText();
    }

    public int countLetters(String lyrics) {
        int count = 0;
        for (int i = 0; i < lyrics.length(); i++) {
            if (Character.isLetter(lyrics.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public int countOccurrences(String word, String lyrics) {
        int count = (lyrics.split(word, -1).length) - 1;
        return count;
    }

    public ArrayList<String> makeListFromLyrics (String lyrics) {
        String[] words1 = lyrics.split(" ");
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(words1));
        return words;
    }

    public String rephraseLyrics(String lyrics) {
        ArrayList<String> words = makeListFromLyrics(lyrics);
        Collections.shuffle(words);
        return words.toString().replace("[", "").replace("]","").replace(",", " ");
    }

    public HashMap<Character, String> makeHashmap(String word) {
        char[] keys = word.toCharArray();
        String value0 = "Confutatis";
        String value1 = "Maledictis";
        String value2 = "Rex Tremendae";
        String value3 = "Timelapse";

        HashMap<Character,String> myHashMap = new HashMap<>();
        myHashMap.put(keys[0], value0);
        myHashMap.put(keys[1], value1);
        myHashMap.put(keys[2], value2.substring(4));
        myHashMap.put(keys[3], value3);

        for (Map.Entry<Character, String> entry : myHashMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        return myHashMap;
    }
}
