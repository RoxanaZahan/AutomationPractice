package Utils;

import org.openqa.selenium.Cookie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

public class Cookies {

    SeleniumDriver seleniumDriver = new SeleniumDriver();
    //TODO : Please don't import cookies from certain files. Create a class and create your own cookies as Strings

    File file = new File("Cookies.data");

    //TODO : Something like this. Don't over complicate things. FileWriter and BufferedWritter are pretty advanced Java classes.

    public void addHeaderCookie() {
        final Cookie name = new Cookie("LS-5958_NewDesktopHeader_USCA:LS-5958_NewDesktopHeader_USCA:Variant",
                                       "Treatment");
        this.seleniumDriver.getDriver().manage().addCookie(name);
        this.seleniumDriver.getDriver().navigate().refresh();
        //Print all of them after you set whatever you want.
        final Set<Cookie> cookiesList = this.seleniumDriver.getDriver().manage().getCookies();

        for (final Cookie getCookies : cookiesList) {
            System.out.println(getCookies);
        }
    }

    public void getCookie() {
        try {
            this.file.createNewFile();
            final FileWriter fileWrite = new FileWriter(this.file);
            final BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            for (final Cookie ck : this.seleniumDriver.driver.manage().getCookies()) {
                Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck
                        .isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void setCookie() {
        try {

            final File file = new File("Cookies.data");
            final FileReader fileReader = new FileReader(file);
            final BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while ((strline = Buffreader.readLine()) != null) {
                final StringTokenizer token = new StringTokenizer(strline, ";");
                while (token.hasMoreTokens()) {
                    final String name = token.nextToken();
                    final String value = token.nextToken();
                    final String domain = token.nextToken();
                    final String path = token.nextToken();
                    Date expiry = null;

                    final String val;
                    if (!(val = token.nextToken()).equals("null")) {
                        expiry = new Date(val);
                    }
                    final Boolean isSecure = new Boolean(token.nextToken()).
                                                                                   booleanValue();
                    final Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                    System.out.println(ck);
                    this.seleniumDriver.driver.manage()
                                              .addCookie(ck); // This will add the stored cookie to the current session
                }
            }
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
