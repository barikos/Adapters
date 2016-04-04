package com.minutes111.adapters.model;

import com.minutes111.adapters.R;

import java.util.ArrayList;

/**
 * Created by barikos on 04.04.16.
 */
public class Data {

    private static final String[] AUTHORS = {
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Энтони Берджес","Джорж Оруэлл","Михаил Шолохов",
            "Братья Стругацкие","Братья Стругацкие","Братья Стругацкие",
            "Антон Чехов","Антон Чехов"};

    private static final String[] BOOKS = {
            "Морфий","Белая гвардия","Прощай оружие","По ком звонит колокол",
            "Заводной апельсин","1984","Тихий Дон",
            "Понедельник начинается в субботу","Пикник на обочине","Трудно быть богом",
            "Палата №6","Жалобная книга"};

    private static final int[] IMAGES_BOOK = {
            R.drawable.img_book_morphine,
            R.drawable.img_book_white,
            R.drawable.img_book_farewell_to_arms,
            R.drawable.img_book_fom_whom,
            R.drawable.img_book_orange,
            R.drawable.img_book_1984,
            R.drawable.img_book_don,
            R.drawable.img_book_monday,
            R.drawable.img_book_picnic,
            R.drawable.img_book_hard_to_be,
            R.drawable.img_book_ward,
            R.drawable.img_book_comp};

    private static final int[] RATING = {4,4,5,8,7,8,9,4,8,7,8,8};

    private static final String[] GENRE = {"Фэнтези","Приключения","Детектив","Фантастика",
            "История","Киберпанк","Антиутопия","Сатира"};

    private static final int[] IMAGES_GENRE = {
            R.drawable.img_genre_fantasy,
            };

    public ArrayList getBooksData(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i<AUTHORS.length; i++){
            arrayList.add(new Book()
                    .setImage(IMAGES_BOOK[i])
                    .setTitle(BOOKS[i])
                    .setAuthor(AUTHORS[i])
                    .setProgress(RATING[i]));
        }
        return arrayList;
    }

    public ArrayList getGenreData(){
        ArrayList arrayList = new ArrayList();
        for (int i=0; i<GENRE.length; i++){
            arrayList.add(new Genre()
                    .setImage(R.drawable.img_genre_fantasy)
                    .setName(GENRE[i]));
        }
        return arrayList;
    }
}
