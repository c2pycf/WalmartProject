package com.example.fang.walmartproject.login;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.fang.walmartproject.AppController;
import com.example.fang.walmartproject.data.UserImformation;
import com.example.fang.walmartproject.data.source.UserDataSource;
import com.example.fang.walmartproject.data.source.UserRepository;
import com.example.fang.walmartproject.data.source.remote.network.RetrofitClientInstance;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class LoginPresenter implements LoginContract.LoginPresenter {
    LoginContract.LoginView mView;
    Retrofit mRetrofit;
    AppController volley;
    UserDataSource dataSource;

    static final String TAG = "LoginPresenter";

    public LoginPresenter(LoginActivity activity) {
        this.mView = activity;
        mRetrofit = RetrofitClientInstance.getInstance();

        volley = AppController.getInstance();
        dataSource = new UserRepository(activity);
    }

    @Override
    public void onLoginHandled(final String phone, final String password) {
        String url = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_login.php?mobile="+phone+"&password="+password;
        //Post url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    List<UserImformation> userInformationList = new ArrayList<>();
                    JSONArray userArray = new JSONArray(response);
                    for(int i=0;i<userArray.length();i++){
                        JSONObject user =  userArray.getJSONObject(i);
                        String message = user.getString("msg");
                        String userId = user.getString("id");
                        String fname = user.getString("firstname");
                        String lname = user.getString("lastname");
                        String email = user.getString("email");
                        String mobile = user.getString("mobile");
                        String userApiKey = user.getString("appapikey ");
                        Log.d(TAG,user.toString() );
                        UserImformation userImformation = new UserImformation(message,userId,fname,lname,email,mobile,userApiKey);
                        userInformationList.add(userImformation);
                    }
                    Log.d(TAG,userInformationList.get(0).getLoginMessage());
                    mView.showToast(userInformationList.get(0).getLoginMessage());
                    saveUser(userInformationList.get(0));
                    volley.setSignFlag();
                    mView.finishSignIn();

                } catch (JSONException e) {
                    e.printStackTrace();
                    mView.showToast("Unable to login\nPlease retry..");
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.getMessage());
            }
        });

       volley.addToRequestQueue(stringRequest,"SignIn");








        /*GetDataService dataService = mRetrofit.create(GetDataService.class);

        Call<List<UserImformation>> call = dataService.getLoginResult(phone,password);
        call.enqueue(new Callback<List<UserImformation>>() {
            @Override
            public void onResponse(Call<List<UserImformation>> call, Response<List<UserImformation>> response) {
                List<UserImformation> userList = response.body();
                String message = userList.get(0).getLoginMessage();
                Log.d(TAG,message);
                if(message=="success" ){
                    UserImformation newUser = userList.get(0);
                    saveUser(newUser);
                    mView.showToast(message);
                }

            }

            @Override
            public void onFailure(Call<List<UserImformation>> call, Throwable t) {
                Log.e(TAG,t.getMessage());
            }
        });*/


    }

    private void saveUser(UserImformation newUser) {
        dataSource.saveUser(newUser);
    }

    @Override
    public void onForgetHandled() {
        //findpassowrd page
        mView.startFindPassword();
    }

    @Override
    public void onCreateHandled() {
        //Jump to register
        mView.startRegistration();
    }
}
