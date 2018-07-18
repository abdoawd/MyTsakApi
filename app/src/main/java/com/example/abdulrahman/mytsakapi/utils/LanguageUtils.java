package com.example.abdulrahman.mytsakapi.utils;

import java.util.Locale;

public class LanguageUtils {

    public static boolean isArabicLanguage() {
        return Locale.getDefault().getLanguage().equals("ar");
    }
}
