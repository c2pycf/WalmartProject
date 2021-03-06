package com.example.fang.walmartproject.data;

public class Product {
    String id;
    String pname;
    String quantity;
    String prize;
    String discription;
    String image;
    int userAmount;

    public Product(String id, String pname, String quantity, String prize, String discription, String image) {
        this.id = id;
        this.pname = pname;
        this.quantity = quantity;
        this.prize = prize;
        this.discription = discription;
        this.image = image;
    }

    public int getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(int userAmount) {
        this.userAmount = userAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscriptiom(String discription) {
        this.discription = discription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
