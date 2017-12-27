package cockatoo.enjizen.myapplicationtemplate.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

public class ProvinceItemModel implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("label")
    @Expose
    private String label;

    protected ProvinceItemModel(Parcel in) {
        id = in.readString();
        label = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(label);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProvinceItemModel> CREATOR = new Creator<ProvinceItemModel>() {
        @Override
        public ProvinceItemModel createFromParcel(Parcel in) {
            return new ProvinceItemModel(in);
        }

        @Override
        public ProvinceItemModel[] newArray(int size) {
            return new ProvinceItemModel[size];
        }
    };

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
    public String toString() {

        return getLabel();
    }
}
