package com.example.fang.walmartproject.data.source;

import android.content.Context;

import com.example.fang.walmartproject.data.Cart;
import com.example.fang.walmartproject.data.Product;
import com.example.fang.walmartproject.data.source.local.cartDb.CartLocalDataSource;

public class CartRepository implements CartDataSource {
    CartLocalDataSource localDataSource;


    public CartRepository(Context context) {
        this.localDataSource = new CartLocalDataSource(context);
    }

    @Override
    public void saveCart(Product product) {
        localDataSource.saveCart(product);
    }

    @Override
    public Cart getCarts() {
        return localDataSource.getCarts();
    }

    @Override
    public void clearCart() {
        localDataSource.clearCart();
    }

    @Override
    public void deleteProduct(String id) {
        localDataSource.deleteProduct(id);
    }

    @Override
    public void update(Product product) {
        localDataSource.update(product);

    }
}
