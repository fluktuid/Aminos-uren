package de.fluktuid.aminosaeuren;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by fluktuid on 30.08.17.
 */

class Aminosäure implements StatisticsFragment.Item {
    private String name;
    private Drawable drawable;
    private String description;
    private String link;

    /**
     * @deprecated
     */
    Aminosäure(Drawable drawable, String name) {
        this.drawable = drawable;
        this.name = name;
    }

    Aminosäure(Drawable drawable, String name, String description, String link) {
        this.drawable = drawable;
        this.name = name;
        this.description = description;
        this.description = description;
        this.link = link;
    }

    String getName() {
        return name;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public View getView(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_amino, null);
        ((ImageView) v.findViewById(R.id.iv_amino)).setImageDrawable(drawable);
        ((TextView) v.findViewById(R.id.tv_amino)).setText(name);
        return v;
    }

    @Override
    public boolean isHeading() {
        return false;
    }

    String getDescription() {
        return description;
    }

    String getLink() {
        return link;
    }
}
