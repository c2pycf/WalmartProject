package com.example.fang.walmartproject.data.source.local.WishListDb;

import android.provider.BaseColumns;

import com.example.fang.walmartproject.data.WishList;

public final class WishListpersisteceContract {
    private WishListpersisteceContract() {}

    /* Inner class that defines the table contents */
    public static abstract class CartEntry implements BaseColumns {
        public static final String TABLE_NAME = "product";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TITLE = "name";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
        public static final String COLUMN_NAME_PRISE = "prise";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_IMAGEURL = "image";
        public static final String COLUMN_NAME_AMOUNT = "amount";
    }
}
