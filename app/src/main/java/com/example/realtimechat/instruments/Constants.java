package com.example.realtimechat.instruments;

import com.example.realtimechat.app.App;
import com.example.realtimechat.datalayer.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Objects;

public class Constants {

    private static final FirebaseStorage mStorage = FirebaseStorage.getInstance();

    public static final String APP_PREFS_IS_AUTH = "isAuth";
    public static final String APP_ERROR_NETWORK_UNENABLE = "Сервис временно не доступен.";
    public static final String APP_PREFS_USER_NAME = "userName";
    public static final String APP_PREFS_USER_ID = "userId";
    public static final String APP_PREFS_IS_ACTIVE = "isActive";
    public static final int NOTIFY_ID = 10;
    public static final String APP_PREFS_IS_AVATAR_CREATED = "isCreated";
    public static final String CHANNEL_ID = "Message channel";
    public static final String NODE_USERS = "Users";
    public static final String STORAGE_USER_IMAGE = "UsersAvatars";
    public static final String CHILD_PHOTO_URL = "photoUrl";
    public static final String AVATAR_URI = "gs://realtimechat-7de91.appspot.com/UsersAvatars/kisspng-royalty-free-domestic-animal-lucky-cat-cartoon-5ae12e98552014.0393762415247069683487.png";
    public static final User USER = new User();

    private static final FirebaseAuth fbAuthReference = FirebaseAuth.getInstance();

    public static final FirebaseDatabase mDat = FirebaseDatabase.getInstance();



    public static final StorageReference STORAGE_PATH_TO_AVATARS = mStorage.getReference()
            .child(Constants.STORAGE_USER_IMAGE)
            .child(Objects.requireNonNull(fbAuthReference.getCurrentUser()).getUid());
    public static final StorageReference STORAGE_PATH_TO_AVATAR = mStorage.getReference()
            .child(Constants.STORAGE_USER_IMAGE);

    public static final DatabaseReference PATH_TO_USER = mDat.getReference().child("Users");
    public static final DatabaseReference PATH_TO_MESSAGES = mDat.getReference().child("Messages");
    public static final DatabaseReference PATH_TO_USER_STATUS = mDat.getReference().child("Users").child(fbAuthReference.getCurrentUser().getUid()).child("status");



//    //метод для получения максимальной ширины экрана
//    public static int getMaxDisplayWight() {
//        return App.getAppContext().getResources().getDisplayMetrics().widthPixels;
//    }
//
//    //Метод получения пикселей ширины с учетом отступов в ДП
//    public static int getMaxDisplayWightWithPadding(float dp) {
//        float px = TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP,
//                dp,
//                App.getAppContext().getResources().getDisplayMetrics()
//        );
//        return (int) (App.getAppContext().getResources().getDisplayMetrics().widthPixels - px);
//    }


//    //метод для получения максимальной ширины экрана
//    public static int getMaxDisplayHeight() {
//        return App.getAppContext().getResources().getDisplayMetrics().heightPixels;
//    }
//
//    //Метод получения пикселей ширины с учетом отступов в ДП
//    public static int getMaxDisplayHeightWithPadding(float dp) {
//        float px = TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP,
//                dp,
//                App.getAppContext().getResources().getDisplayMetrics()
//        );
//        return (int) (App.getAppContext().getResources().getDisplayMetrics().heightPixels - px);
//    }

    //Метод для получения строки по ID
    public static String getStringById(int stringId) {
        return App.getAppContext().getResources().getString(stringId);
    }
}
