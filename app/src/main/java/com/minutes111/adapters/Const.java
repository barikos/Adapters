package com.minutes111.adapters;

/**
 * Created by barikos on 04.04.16.
 */
public class Const {

    public static final String LOG_TAG = "myLogs";

    public static final String[] AUTHORS = {
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Энтони Берджес","Джорж Оруэлл","Михаил Шолохов",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Антон Чехов","Антон Чехов"};

    public static final String[] BOOKS = {
            "Морфий","Белая гвардия","Прощай оружие","По ком звонит колокол",
            "Заводной апельсин","1984","Тихий Дон",
            "Игра престолов","Пикник на обочине","Трудно быть богом",
            "Палата №6","Жалобная книга"};

    public static final int[] IMAGES_BOOK = {
            R.drawable.img_book_morphine,
            R.drawable.img_book_white,
            R.drawable.img_book_farewell_to_arms,
            R.drawable.img_book_fom_whom,
            R.drawable.img_book_orange,
            R.drawable.img_book_1984,
            R.drawable.img_book_don,
            R.drawable.img_book_game,
            R.drawable.img_book_picnic,
            R.drawable.img_book_hard_to_be,
            R.drawable.img_book_ward,
            R.drawable.img_book_comp};

    public static final float[] RATING = {3,3,4,5,4,5,5,3,4,5,4,4};

    public final static String FRAG_TITLE = "dialogTitle";

    public static int RESULT_CODE_PIKER = 1;
    public static int RESULT_CODE_ADD_BOOK = 2;

    public static String ATTR_BOOK_NAME = "name";
    public static String ATTR_BOOK_AUTH = "author";
    public static String ATTR_BOOK_IMG = "img";
    public static String ATTR_BOOK_RATING = "rating";


}
