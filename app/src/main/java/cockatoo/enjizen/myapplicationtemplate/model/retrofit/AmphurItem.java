package cockatoo.enjizen.myapplicationtemplate.model.retrofit;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by streami.t.mobiledeveloper1 on 17/1/2018 AD.
 */

public class AmphurItem implements Parcelable {
    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("label")
    @Expose
    public String label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.label);
    }

    public AmphurItem() {
    }

    protected AmphurItem(Parcel in) {
        this.id = in.readString();
        this.label = in.readString();
    }

    public static final Parcelable.Creator<AmphurItem> CREATOR = new Parcelable.Creator<AmphurItem>() {
        @Override
        public AmphurItem createFromParcel(Parcel source) {
            return new AmphurItem(source);
        }

        @Override
        public AmphurItem[] newArray(int size) {
            return new AmphurItem[size];
        }
    };
}
