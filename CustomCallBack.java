
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import org.json.JSONObject;

import io.ideaction.slipzz.LoadingDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomCallBack<T> implements Callback<T> {

    LoadingDialog mLoadingDialog;
    Context context;

    public CustomCallBack(Context context) {
        this.context = context;
        mLoadingDialog = new LoadingDialog();
        mLoadingDialog.show(((AppCompatActivity)context).getSupportFragmentManager() , "");
        ((AppCompatActivity) context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        mLoadingDialog.dismiss();
        ((AppCompatActivity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        if (!response.isSuccessful()) {
            try {
                JSONObject jObjError = new JSONObject(response.errorBody().string());
                Toast.makeText(context, jObjError.getString("message"), Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        mLoadingDialog.dismiss();
        ((AppCompatActivity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        Toast.makeText(context , "We are unable to connect you. Please try again or check network settings" , Toast.LENGTH_LONG).show();
        Log.d("retrofitError" , t.getMessage());
    }
}
