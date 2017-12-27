package cockatoo.enjizen.myapplicationtemplate.util;

import android.util.Log;


/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class LogUtil {

    private static LogUtil instance;
    private boolean show = true;

    public static LogUtil getInstance() {
        if (instance == null)
            instance = new LogUtil();
        return instance;
    }

   public void i(String tag, String msg){
        if (show)
            Log.i(tag,msg);
   }

   public void d(String tag, String msg){
       if (show)
           Log.d(tag,msg);
   }

   public void e(String tag, String msg){
       if (show)
           Log.e(tag,msg);
   }

   public void v(String tag, String msg){
       if (show)
           Log.v(tag,msg);
   }



}
