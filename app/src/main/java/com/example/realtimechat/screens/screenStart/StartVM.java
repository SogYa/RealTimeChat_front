package com.example.realtimechat.screens.screenStart;

import static com.example.realtimechat.instruments.Constants.APP_PREFS_IS_AUTH;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.realtimechat.MainActivity;
import com.example.realtimechat.datalayer.SPControl;
import com.example.realtimechat.instruments.NavigationConstants;
import com.example.realtimechat.screens.screenChat.ChatActivity;
import com.example.realtimechat.screens.screenSignIn.SignInActivity;

public class StartVM extends AndroidViewModel {

    private final MutableLiveData<String> hintsData;
    private final MutableLiveData<NavigationConstants> navigationLiveData;

    public StartVM(@NonNull Application application) {
        super(application);
        hintsData = new MutableLiveData<>();
        navigationLiveData = new MutableLiveData<>();
        String[] hints = new String[]{
                "Котика на логотипе зовут Марик",
                "Лиля - самая милая кошка",
                "У котиков самые красивые глазки",
                "Котики всегда приземляются на лапки",
                "Прогружаем хвостики и лапки",
                "У котиков 9 жизней, каждую из которых они готовы провести с тобой",
                "Что такое красота? Дом, где два кота",
                "Запускаем мурчало"
        };
        hintsData.setValue(hints[(int) (Math.random() * 7)]);
         checkStatus();
    }

    public void checkStatus() {

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            //Проверка на авторизацию пользователя
            if (SPControl.getInstance().getBoolPrefs(APP_PREFS_IS_AUTH)) {
                navigationLiveData.postValue(NavigationConstants.CHAT);
            } else {
                navigationLiveData.postValue(NavigationConstants.LOGIN);
            }
        }, 1500);
    }

    public MutableLiveData<String> getHintsData() {
        return hintsData;
    }
    public MutableLiveData<NavigationConstants> getNavigationLiveData(){return navigationLiveData;}
}


