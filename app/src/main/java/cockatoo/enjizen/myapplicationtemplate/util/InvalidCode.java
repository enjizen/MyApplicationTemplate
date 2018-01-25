package cockatoo.enjizen.myapplicationtemplate.util;


/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */
public class InvalidCode {

    private static InvalidCode instance;

    public static InvalidCode getInstance() {
        if (instance == null)
            instance = new InvalidCode();
        return instance;
    }


    private InvalidCode() {

    }

    public String invalidHttpStatusCode(int code) {

        String httpResult;


        switch (code) {
            case 404:
                httpResult = "Bad Request";
                break;
            case 500:
                httpResult = "Internal Server Error";
                break;
            default:
                httpResult = "";
                break;
        }


        return httpResult;
    }


}
