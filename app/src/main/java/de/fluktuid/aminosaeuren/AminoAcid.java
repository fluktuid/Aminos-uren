package de.fluktuid.aminosaeuren;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by fluktuid on 30.08.17.
 */
class AminoAcid implements StatisticsFragment.Item, Parcelable {
    private String name;
    private String description;
    private String link;
    private int drawableResourceAddress;

    AminoAcid(int drawableResourceAdress, String name, String description, String link) {
        this.drawableResourceAddress = drawableResourceAdress;
        this.name = name;
        this.description = description;
        this.description = description;
        this.link = link;
    }

    private AminoAcid(Parcel in) {
        name = in.readString();
        description = in.readString();
        link = in.readString();
        drawableResourceAddress = in.readInt();
    }

    public static final Creator<AminoAcid> CREATOR = new Creator<AminoAcid>() {
        @Override
        public AminoAcid createFromParcel(Parcel in) {
            return new AminoAcid(in);
        }

        @Override
        public AminoAcid[] newArray(int size) {
            return new AminoAcid[size];
        }
    };

    String getName() {
        return name;
    }

    Drawable getDrawable(Context context) {
        return context.getResources().getDrawable(drawableResourceAddress, context.getTheme());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public View getView(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_amino, null);
        ((ImageView) v.findViewById(R.id.iv_amino)).setImageDrawable(getDrawable(context));
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(link);
        parcel.writeInt(drawableResourceAddress);
    }
}
