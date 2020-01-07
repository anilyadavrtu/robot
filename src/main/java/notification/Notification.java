package notification;

/**
 *Notification
 *  Error Messages
 */
public class Notification {

    public boolean display(String errorCode) {
        boolean isError = false;
        if (errorCode.equals("redLight")) {
            System.out.println("Low Battery");
            isError = true;
        } else if (errorCode.equals("overweight")) {
            System.out.println("Over weight");
            isError = true;
        } else if (errorCode.equals("failure")) {
            System.out.println("Cant reach to destination:battery will be discharge before destination");
            isError = true;
        } else if (errorCode.equals("barcode")) {
            System.out.println("Scan failure");
            isError = true;
        }
        return isError;
    }
}
