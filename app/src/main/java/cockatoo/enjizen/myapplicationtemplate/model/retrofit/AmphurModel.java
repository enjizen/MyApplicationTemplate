package cockatoo.enjizen.myapplicationtemplate.model.retrofit;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import cockatoo.enjizen.myapplicationtemplate.model.MessageResponse;

/**
 * Created by Inspiron 3458 on 10/26/2016.
 */

public class AmphurModel extends MessageResponse implements Parcelable {
    @SerializedName("amphur")
    @Expose
    public List<AmphurItem> amphurItemList;

    public List<AmphurItem> getAmphurItemList() {
        return amphurItemList;
    }

    public void setAmphurItemList(List<AmphurItem> amphurItemList) {
        this.amphurItemList = amphurItemList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.amphurItemList);
    }

    public AmphurModel() {
    }

    protected AmphurModel(Parcel in) {
        this.amphurItemList = in.createTypedArrayList(AmphurItem.CREATOR);
    }

    public static final Parcelable.Creator<AmphurModel> CREATOR = new Parcelable.Creator<AmphurModel>() {
        @Override
        public AmphurModel createFromParcel(Parcel source) {
            return new AmphurModel(source);
        }

        @Override
        public AmphurModel[] newArray(int size) {
            return new AmphurModel[size];
        }
    };
}
