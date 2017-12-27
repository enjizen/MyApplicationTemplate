package cockatoo.enjizen.myapplicationtemplate.fragment;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
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
import android.widget.Toast;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.manager.CallApiServiceManager;
import cockatoo.enjizen.myapplicationtemplate.model.ProvinceItemModel;
import cockatoo.enjizen.myapplicationtemplate.model.ProvinceModel;
import cockatoo.enjizen.myapplicationtemplate.util.LogUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    private static MainFragment fragment;
    @BindView(R.id.spinner_province)
    AppCompatSpinner spinnerProvince;
    @BindView(R.id.text_view_test)
    TextView textViewTest;


    private String provinceId = "";
    private String provinceName = "";


    public MainFragment() {
        super();
    }

    public static MainFragment newInstance(){
        fragment= new MainFragment();
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

       LogUtil.getInstance().i("provinceName",provinceName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewTest.setText(R.string.label_test_butter_knife);
        if(savedInstanceState == null) {
            new FeedProvince().execute();
        }
    }



    @SuppressLint("StaticFieldLeak")
    private class FeedProvince extends AsyncTask<String,Void,ProvinceModel>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            showLoadingDialog();

        }

        @Override
        protected ProvinceModel doInBackground(String... strings) {
            ProvinceModel provinceModel =  CallApiServiceManager.getInstance().getProvince();
            return provinceModel;
        }

        @Override
        protected void onPostExecute(ProvinceModel provinceModel) {
            super.onPostExecute(provinceModel);
            hideLoadingDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("provinceList",provinceModel);
            fragment.setArguments(bundle);
            setDataProvinceSpinner((List<ProvinceItemModel>) getArguments().getParcelable("provinceList"));
        }
    }



    private void setDataProvinceSpinner(final List<ProvinceItemModel> provinceItemModelList) {
        ArrayAdapter dataAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_dropdown_item, provinceItemModelList);

        spinnerProvince.setAdapter(dataAdapter);

        spinnerProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 provinceId = provinceItemModelList.get(position).getId();
                 provinceName = provinceItemModelList.get(position).getLabel();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("provinceId", provinceId);
        outState.putString("provinceName", provinceName);

    }

    private void onRestoreInstanceState(Bundle savedInstanceState){
        provinceId = savedInstanceState.getString("provinceId");
        provinceName = savedInstanceState.getString("provinceName");
    }
}
