package com.bubble.swcamp.android.items;

import io.realm.RealmObject;

/**
 * Created by geni on 2017. 9. 1..
 */

public class Manager extends RealmObject {
    private String email = "";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
