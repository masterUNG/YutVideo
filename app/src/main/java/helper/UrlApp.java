package helper;

public class UrlApp {

    public static final String API = "http://uway.bear-tv.com/api/";
    public static final String API3 = "http://pataya.bear-tv.com/api/";
    public static final String API2 = "http://loa4tv.com/api/";
    public static final String API4 = "http://2654k.com/api/";
    public static final String API5 = "http://2654k.com/api/";


//    public static final String API2 = "http://2654k.com/";

    //token
    public static final String CHECK_TOKEN = API2 + "api/token_check/";
    //user
    public static final String REGISTER = API2 + "register";
    public static final String LOGIN = API2 + "login";
    public static final String CHECK_EXPIRED = API2 + "check_expired/";
    public static final String CHANGEPASS = API2 + "change_password";
    public static final String BANK_ACCOUNT = API2 + "bankaccount";
    public static final String TRANSFER = API2 + "reqtransfer";
    public static final String CHECK_MONEY = API2 + "check_truemoney/";
    //movie
    public static final String MAIN_MOVIE = API + "main_category";
    public static final String CATEGORY_MOVIE = API + "category";
    public static final String LAST_MOVIE = API + "getlastmovie";
    //movie2
    public static final String MAIN_MOVIE2 = API4 + "main_category";
    public static final String CATEGORY_MOVIE2 = API4 + "category";
    public static final String LAST_MOVIE2 = API4 + "getlastmovie";
    //movie3
    public static final String MAIN_MOVIE3 = API5 + "main_category";
    public static final String CATEGORY_MOVIE3 = API5 + "category";
    public static final String LAST_MOVIE3 = API5 + "getlastmovie";
    //series
    public static final String MAIN_Series = API + "series_main_category";
    public static final String CATEGORY_Series = API + "series_sub_category";
    public static final String SEASON_Series = API + "series_season";
    public static final String Series = API + "series";
    //series2
    public static final String MAIN_Series2 = API4 + "series_main_category";
    public static final String CATEGORY_Series2 = API4 + "series_sub_category";
    public static final String SEASON_Series2 = API4 + "series_season";
    public static final String Series2 = API4 + "series";
    //tv
    public static final String MAIN_TV = API + "iptv_main_category";
    public static final String CATEGORY_TV = API + "iptv_sub_category";
    //tv2
    public static final String MAIN_TV2 = API4 + "iptv_main_category";
    public static final String CATEGORY_TV2 = API4 + "iptv_sub_category";
    //search
    public static final String SEARCH = API + "findmovie";
    //search
    //public static final String SEARCHSR = API+"findseries";
    //other
    public static final String OTHER = API2 + "other";
    //slide
    public static final String SLIDE = API2 + "slide";
    //ebook
    public static final String EBOOK_CATEGORY = API + "ebook_category";
    public static final String EBOOK_ID = API + "ebook";
    //ip
    public static final String GET_IP = API2 + "getip";
    public static final String OTP = API2 + "otp";
    //paypal
    public static final String PAY_PAL = API2 + "paypal?id=";
    public static final String KEEP_ALIVE = API2 + "keep_alive";

}
