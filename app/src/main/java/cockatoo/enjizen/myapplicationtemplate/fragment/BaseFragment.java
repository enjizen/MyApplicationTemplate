package cockatoo.enjizen.myapplicationtemplate.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;
import cc.cloudist.acplibrary.ACProgressPie;

/**
 * Created by streami.t.mobiledeveloper1 on 27/12/2017 AD.
 */

public class BaseFragment extends Fragment {

    private ACProgressFlower dialog;


    public void showLoadingDialog() {
        if(dialog == null) {
            dialog = new ACProgressFlower.Builder(getContext())
                    .build();

           // dialog.setCanceledOnTouchOutside(false);

        }
        dialog.show();
    }

    public void hideLoadingDialog(){
        dialog.dismiss();
    }
}
