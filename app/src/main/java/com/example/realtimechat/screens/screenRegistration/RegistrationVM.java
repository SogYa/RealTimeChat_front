package com.example.realtimechat.screens.screenRegistration;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bumptech.glide.Glide;
import com.example.realtimechat.app.App;
import com.example.realtimechat.datalayer.AuthRepo;
import com.example.realtimechat.datalayer.SPControl;
import com.example.realtimechat.instruments.Constants;
import com.example.realtimechat.instruments.myCallBack;
import com.example.realtimechat.screens.screenChat.MainActivity;

public class RegistrationVM extends AndroidViewModel {

    private final AuthRepo authRepo;
    private final App app;

    public RegistrationVM(@NonNull Application application) {
        super(application);
        authRepo = new AuthRepo();
        app = new App();
    }

    //Метод регистрации пользователя
    public void registration(String name, String email, String password, myCallBack<Object> myCallBack) {
        authRepo.registration(email, password, new AuthRepo.DataListener<String>() {
            @Override
            public void data(String o) {
                authRepo.createNewUser(name);
                SPControl.getInstance().updatePrefs(Constants.APP_PREFS_IS_AUTH, true);
                SPControl.getInstance().updatePrefs(Constants.APP_PREFS_USER_ID, o);
                getApplication().startActivity(new Intent(getApplication(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                Toast.makeText(getApplication(), "Добро пожаловать!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void error(String error) {
                myCallBack.data(true);
                Toast.makeText(getApplication(), error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setAvatar(ImageView avatarView, Activity o) {
        app.setImage(avatarView, o);

    }

    public void sendImage(Uri uri, ImageView imageView) {
        SPControl.getInstance().updatePrefs(Constants.AVATAR_URI, uri.toString());
        Glide.with(getApplication().getApplicationContext())
                .load(uri)
                .into(imageView);
    }
}
