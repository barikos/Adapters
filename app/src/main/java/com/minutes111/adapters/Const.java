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


    public static final int[] RATING = {4,4,5,8,7,8,9,4,8,7,8,8};


    public final static String FRAG_TITLE = "dialogTitle";


    /*public ArrayList getBooksData(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i<AUTHORS.length; i++){
            arrayList.add(new Book()
                    .setImage(IMAGES_BOOK[i])
                    .setName(BOOKS[i])
                    .setAuthor(AUTHORS[i])
                    .setRating(RATING[i]));
        }
        return arrayList;
    }*/

}
