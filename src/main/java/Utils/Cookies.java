package Utils;

import org.openqa.selenium.Cookie;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

public class Cookies {
    SeleniumDriver seleniumDriver = new SeleniumDriver();

    File file = new File("Cookies.data");
    public void getCookie() {
        try {
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            for (Cookie ck : seleniumDriver.driver.manage().getCookies()) {
                Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCookie() {
        try{

            File file = new File("Cookies.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while((strline=Buffreader.readLine())!=null){
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if(!(val=token.nextToken()).equals("null"))
                    {
                        expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken()).
                            booleanValue();
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    System.out.println(ck);
                    seleniumDriver.driver.manage().addCookie(ck); // This will add the stored cookie to the current session
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
