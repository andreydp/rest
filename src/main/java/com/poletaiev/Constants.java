package com.poletaiev;

import java.text.DecimalFormat;

public class Constants {
    public static final DecimalFormat ORDER_AMOUNT_FORMAT = new DecimalFormat("#.00");
    public static final String ORDER_DATE_FORMAT_STRING = "yyyy-MM-dd'Z'HH:mm:ss.SSS";

    //Error codes
    public static final int ERR_CODE_ORDER_NOT_FOUND = 100;
    public static final int ERR_CODE_INVALID_ORDER_ID_FORMAT = 102;
    public static final int ERR_CODE_DB_ERROR = 103;
    public static final int ERR_CODE_UNDEFINED = 500;

}
