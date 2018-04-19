package br.edu.utfpr.web2.util;

import javax.servlet.http.HttpSession;

public class Util {

    public static boolean isEmail(String s) {
        return s.indexOf("@") > 1 && s.indexOf(".") > s.indexOf("@");
    }

    public static boolean isLoggedin(HttpSession session) {
        return !session.getAttribute("usuarioLogado").equals("");
    }

}
