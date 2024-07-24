package starter;

public class Utils {
    public static String[] extractDateParts(String date) {
        return date.split("/");
    }

    public static void waitForSomeTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
