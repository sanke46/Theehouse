package com.teamtreehouse.musicmachine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ilafedoseev on 21/02/2018.
 */

public class NetworkConnectionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(NetworkConnectionReceiver.class.getSimpleName(), intent.getAction());
    }
}
