package cockatoo.enjizen.myapplicationtemplate.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Inspiron 3458 on 10/26/2016.
 */

public class ProvinceModel implements Parcelable {
    @SerializedName("provinces")
    @Expose
    private List<ProvinceItemModel> provinceItemModelList;

    protected ProvinceModel(Parcel in) {
        provinceItemModelList = in.createTypedArrayList(ProvinceItemModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(provinceItemModelList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProvinceModel> CREATOR = new Creator<ProvinceModel>() {
        @Override
        public ProvinceModel createFromParcel(Parcel in) {
            return new ProvinceModel(in);
        }

        @Override
        public ProvinceModel[] newArray(int size) {
            return new ProvinceModel[size];
        }
    };

    public List<ProvinceItemModel> getProvinceItemModelList() {
        return provinceItemModelList;
    }

    public void setProvinceItemModelList(List<ProvinceItemModel> provinceItemModelList) {
        this.provinceItemModelList = provinceItemModelList;
    }


}
