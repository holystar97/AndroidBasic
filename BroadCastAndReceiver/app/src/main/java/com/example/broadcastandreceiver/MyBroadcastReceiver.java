package com.example.broadcastandreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    interface OnSmsReceived{
        void onReceived(String msg);
    }

    public String getMessage;
    private OnSmsReceived onSmsReceived =null;

    public void setOnSmsReceived(OnSmsReceived smsReceived){
        onSmsReceived =smsReceived;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if(Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())){
            SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

            if(messages != null){
                if(messages.length==0){
                    return;
                }
                StringBuilder sb=new StringBuilder();
                for(SmsMessage smsMessage : messages){
                    sb.append(smsMessage.getMessageBody());
                }
                String sender=messages[0].getOriginatingAddress();
                String message=sender + " : " + sb.toString();

                getMessage=message;

                if(onSmsReceived !=null){
                    onSmsReceived.onReceived(getMessage);
                }

            }


        }
    }
}
