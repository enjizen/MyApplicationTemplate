package cockatoo.enjizen.myapplicationtemplate.dialog;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cockatoo.enjizen.myapplicationtemplate.R;
import cockatoo.enjizen.myapplicationtemplate.constanst.Constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertDialogFragment extends DialogFragment {


    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.btn_positive)
    Button btnPositive;



    public static final  String KEY_MESSAGE = "key message";
    public static final  String KEY_POSITIVE = "key positive";

    private String message;
    private int positive;




    public AlertDialogFragment() {
        // Required empty public constructor
    }

    public static AlertDialogFragment newInstance(String message
                                                    , @StringRes int positive){
        AlertDialogFragment fragment = new AlertDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE, message);
        bundle.putInt(KEY_POSITIVE, positive);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        } else {
            restoreArguments(getArguments());
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alert_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        setupView();

    }


    private void setupView() {
        tvMessage.setText(message);
        btnPositive.setText(positive);

        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogFragment.OnDialogListener listener = getOnDialogListener();
                if(listener != null){
                    listener.onPositiveButtonClick();
                }
                dismiss();
            }
        });




    }



    private OnDialogListener getOnDialogListener() {
        Fragment fragment = getParentFragment();
        try {
            if (fragment != null) {
                return (OnDialogListener) fragment;
            } else {
                return (OnDialogListener) getActivity();
            }
        } catch (ClassCastException ignored) {
        }
        return null;
    }

    private void restoreArguments(Bundle bundle) {
        message = bundle.getString(Constant.KEY_MESSAGE);
        positive = bundle.getInt(Constant.KEY_POSITIVE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(Constant.KEY_MESSAGE, message);
        outState.putInt(Constant.KEY_POSITIVE, positive);

    }

    private void onRestoreInstanceState(Bundle savedInstanceState){
        message = savedInstanceState.getString(Constant.KEY_MESSAGE);
        positive = savedInstanceState.getInt(Constant.KEY_POSITIVE);
    }

    public interface OnDialogListener {
        void onPositiveButtonClick();
    }


    public static class Builder {
        private String message;
        private int positive;

        public Builder() {
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPositive(@StringRes int positive) {
            this.positive = positive;
            return this;
        }


        public AlertDialogFragment build() {
            return  AlertDialogFragment.newInstance(message, positive);
        }
    }

}
