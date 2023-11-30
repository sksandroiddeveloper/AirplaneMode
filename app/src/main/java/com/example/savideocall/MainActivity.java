package com.example.savideocall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallConfig;
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallFragment;
import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   EditText editText;
   Button join_btns;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextTextPersonName);
        join_btns = findViewById(R.id.join_btn);

        join_btns.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String userid = editText.getText().toString().trim();
                if (userid.isEmpty()) {
                    return;
                }
addCallFragment(userid);
           Intent intent = new Intent(MainActivity.this,CallActivity.class);
           intent.putExtra("userId",userid);
           startActivity(intent);

            }
        });


        }

        public void addCallFragment(String userId){
        long appID = 1112216281;
        String appSign = "5ca348b9facba4db4090ada1bc2a3936ea285aac9965c0a7bea1df398ea00a55";
        String userName = userId;
        Application application = getApplication(); // Android's application context
            ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        callInvitationConfig.notifyWhenAppRunningInBackgroundOrQuit = true;
        ZegoNotificationConfig notificationConfig = new ZegoNotificationConfig();
        notificationConfig.sound = "zego_uikit_sound_call";
        notificationConfig.channelID = "CallInvitation";
        notificationConfig.channelName = "CallInvitation";
        ZegoUIKitPrebuiltCallInvitationService.init(getApplication(), appID, appSign, userId, userName, callInvitationConfig);


    }

    @Override
    protected void onDestroy() {
     super.onDestroy();
        ZegoUIKitPrebuiltCallInvitationService.unInit();
    }
}