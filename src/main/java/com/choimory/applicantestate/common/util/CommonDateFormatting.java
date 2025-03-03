package com.choimory.applicantestate.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommonDateFormatting {
    public static String to(String regex, String date) {
        String formattedDate = date.replaceAll(regex, "");
        SimpleDateFormat input = new SimpleDateFormat("yyyy년M월d일");
        SimpleDateFormat output = new SimpleDateFormat("yyyy.MM.dd");

        try {
            formattedDate = output.format(input.parse(formattedDate));
        } catch (ParseException ignored) {
        }

        return formattedDate;
    }
}
