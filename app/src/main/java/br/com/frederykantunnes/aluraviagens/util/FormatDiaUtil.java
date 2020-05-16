package br.com.frederykantunnes.aluraviagens.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatDiaUtil {
    public static String getDiasFormat(int dias){
        if (dias==1){
            return " dia";
        }else{
            return " dias";
        }
    }
    public static String getFormatData(Calendar data) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dataformat = new SimpleDateFormat("dd/MM");
        return dataformat.format(data.getTime());
    }

    public static String getTimeDuration(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        return FormatDiaUtil.getFormatData(dataIda) +" - "+ FormatDiaUtil.getFormatData(dataVolta);
    }
}
