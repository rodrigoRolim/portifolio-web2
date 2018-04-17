package util;

public class Util {

    public static boolean isEmail(String s) {
        return s.indexOf("@") > 1 && s.indexOf(".") > s.indexOf("@");
    }
}
