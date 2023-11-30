package com.example.savideocall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallConfig;
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallFragment;
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class CallActivity extends AppCompatActivity {

    EditText useredit;
    ZegoSendCallInvitationButton videocall , voicecall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        useredit = findViewById(R.id.editTextTextPersonNam);
      videocall = findViewById(R.id.videobutton);
      voicecall = findViewById(R.id.voicecall);

String userid = getIntent().getStringExtra("userId");

useredit.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
String userid = useredit.getText().toString().trim();
setVideocall(userid);
setVoicecall(userid);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
});
    }

    public void setVoicecall(String targetuserid){
        voicecall.setIsVideoCall(false);
        voicecall.setResourceID("zego_uikit_call");
        voicecall.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetuserid)));
    }
    public void setVideocall(String targetuserid){
        videocall.setIsVideoCall(true);
        videocall.setResourceID("zego_uikit_call");
        videocall.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetuserid)));
    }


}
