package cockatoo.enjizen.myapplicationtemplate.dialog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class ConfirmDialogFragment extends DialogFragment {


    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.btn_positive)
    Button btnPositive;
    @BindView(R.id.btn_negative)
    Button btnNegative;



    private String message;
    private int positive;
    private int negative;




    public ConfirmDialogFragment() {
        // Required empty public constructor
    }

    public static ConfirmDialogFragment newInstance( String message
                                                    , @StringRes int positive
                                                    , @StringRes int negative){
        ConfirmDialogFragment fragment = new ConfirmDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.KEY_MESSAGE, message);
        bundle.putInt(Constant.KEY_POSITIVE, positive);
        bundle.putInt(Constant.KEY_NEGATIVE, negative);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            restoreArguments(getArguments());
        }
        else{
            onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        setupView();

    }


    private void setupView() {
        tvMessage.setText(message);
        btnPositive.setText(positive);
        btnNegative.setText(negative);

        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnDialogListener listener = getOnDialogListener();
                if(listener != null){
                    listener.onPositiveButtonClick();
                }
                dismiss();

            }
        });

        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnDialogListener listener = getOnDialogListener();
                if(listener != null){
                    listener.onNegativeButtonClick();
                }
                dismiss();
            }
        });


    }



    private OnDialogListener getOnDialogListener() {
        Fragment fragment = getParentFragment();
        try {
            if (fragment != null) {
                Log.i("Return","Result = Fragment");
                return (OnDialogListener) fragment;
            } else {
                Log.i("Return","Result = Activity" );
                return (OnDialogListener) getActivity();
            }
        } catch (ClassCastException ignored) {
        }
        return null;
    }

    private void restoreArguments(Bundle bundle) {
        message = bundle.getString(Constant.KEY_MESSAGE);
        positive = bundle.getInt(Constant.KEY_POSITIVE);
        negative = bundle.getInt(Constant.KEY_NEGATIVE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(Constant.KEY_MESSAGE, message);
        outState.putInt(Constant.KEY_POSITIVE, positive);
        outState.putInt(Constant.KEY_NEGATIVE,negative);

    }

    private void onRestoreInstanceState(Bundle savedInstanceState){
        message = savedInstanceState.getString(Constant.KEY_MESSAGE);
        positive = savedInstanceState.getInt(Constant.KEY_POSITIVE);
        negative = savedInstanceState.getInt(Constant.KEY_NEGATIVE);
    }

    public interface OnDialogListener {
        void onPositiveButtonClick();

        void onNegativeButtonClick();
    }


    public static class Builder {
        private String message;
        private int positive;
        private int negative;

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

        public Builder setNegative(@StringRes int negative) {
            this.negative = negative;
            return this;
        }

        public ConfirmDialogFragment build() {
            return ConfirmDialogFragment.newInstance(message, positive, negative);
        }
    }

}
