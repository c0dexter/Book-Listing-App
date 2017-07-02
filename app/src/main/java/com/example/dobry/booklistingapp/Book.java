package com.example.dobry.booklistingapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dobry on 01.07.17.
 */

public class Book implements Parcelable {

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
    /**
     * Title of the book
     */
    private final String title;
    /**
     * Author of the book
     */
    private final String author;
    /**
     * URL address of an image cover of the book
     */
    private final String imageUrl;
    /**
     * Price of the book
     */
    private final Double price;
    /**
     * Price of the book
     */
    private final String currency;
    /**
     * Country code of language
     */
    private final String language;
    /**
     * Url of the book
     */
    private String urlBook;

    /**
     * @param bookTitle     - (String) name of the book i.e.: "Harry Potter i Kamień Filozoficzny"
     * @param authorName    - (String) name of author i.e.: "J.K. Rowling"
     * @param urlImageCover - (String) URL address of an image cover i.e.: "http://books.google.com/books/(...)"
     * @param bookPrice     - (Double) price of the book i.e.: 39.00
     * @param currency      - (String) currency code for amount, i.e: "PLN"
     * @param languageCode  - (String) country code i.e.: "PL"
     * @param buyLink       - (String) url for buying page on Google Play
     */
    public Book(String bookTitle, String authorName, String urlImageCover, Double bookPrice, String currency, String languageCode, String buyLink) {
        this.title = bookTitle;
        this.author = authorName;
        this.imageUrl = urlImageCover;
        this.price = bookPrice;
        this.currency = currency;
        this.language = languageCode;
        this.urlBook = buyLink;

    }

    protected Book(Parcel in) {
        this.title = in.readString();
        this.author = in.readString();
        this.imageUrl = in.readString();
        this.price = (Double) in.readValue(Double.class.getClassLoader());
        this.currency = in.readString();
        this.urlBook = in.readString();
        this.language = in.readString();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getLanguage() {
        return language;
    }

    public String getUrlBook() {
        return urlBook;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.imageUrl);
        dest.writeValue(this.price);
        dest.writeString(this.currency);
        dest.writeString(this.urlBook);
        dest.writeString(this.language);
    }
}
