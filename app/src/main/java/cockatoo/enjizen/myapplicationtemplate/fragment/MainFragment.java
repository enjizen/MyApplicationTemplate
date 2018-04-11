package cockatoo.enjizen.myapplicationtemplate.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.constanst.Constant;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.AmphurModel;
import cockatoo.enjizen.myapplicationtemplate.model.retrofit.ProvinceModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment{


    // Element Member Variable

    @BindView(R.id.spinner_province)
    AppCompatSpinner spinnerProvince;

    @BindView(R.id.text_view_test)
    TextView textViewTest;


    private String provinceId;



    public MainFragment() {
        super();
    }

    public static MainFragment newInstance(){
        MainFragment fragment= new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            onRestoreInstanceState(savedInstanceState);  // Restore Instance
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this,view);

        textViewTest.setText(R.string.label_test_butter_knife);
        if(savedInstanceState == null) {
            getApiService().getProvince();

        }
        else{
            ProvinceModel provinceModel =  getArguments().getParcelable(Constant.PROVINCE_LIST_ARGUMENT);

            if(provinceModel != null){
                setDataProvinceSpinner(provinceModel);
            }

        }
    }

    @Override
    public void callbackProvinceModelResponse(ProvinceModel provinceModel) {
        super.callbackProvinceModelResponse(provinceModel);


        if(provinceModel != null && provinceModel.getProvinceItemModelList() != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.PROVINCE_LIST_ARGUMENT, provinceModel);
            setArguments(bundle);
            setDataProvinceSpinner((ProvinceModel) getArguments().getParcelable(Constant.PROVINCE_LIST_ARGUMENT));

            getApiService().getAmphur(Integer.parseInt(provinceModel.getProvinceItemModelList().get(0).getId()));
        }


    }





    private void setDataProvinceSpinner(final ProvinceModel provinceModel) {
        ArrayAdapter dataAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_dropdown_item, provinceModel.getProvinceItemModelList());

        spinnerProvince.setAdapter(dataAdapter);

        spinnerProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 provinceId = provinceModel.getProvinceItemModelList().get(position).getId();
                 //provinceName = provinceModel.getProvinceItemModelList().get(position).getLabel();

                toast(provinceId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void onRestoreInstanceState(Bundle savedInstanceState){

    }

}
