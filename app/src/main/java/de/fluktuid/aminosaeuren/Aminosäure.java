package de.fluktuid.aminosaeuren;

import android.graphics.drawable.Drawable;

/**
 * Created by fluktuid on 30.08.17.
 */

class Aminosäure {
    private String name;
    private Drawable bitmap;

    Aminosäure(Drawable bitmap, String name) {
        this.bitmap = bitmap;
        this.name = name;
    }

    String getName() {
        return name;
    }

    public Drawable getDrawable() {
        return bitmap;
    }

    @Override
    public String toString() {
        return name;
    }
}
