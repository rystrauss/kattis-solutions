import java.io.File;
import java.util.*;

public class WheresMyInternet {

    public WheresMyInternet(Scanner s) {
    
    }

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(System.in);
            WheresMyInternet i = new WheresMyInternet(s);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
    }

}
