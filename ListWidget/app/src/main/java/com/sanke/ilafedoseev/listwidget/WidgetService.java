package com.sanke.ilafedoseev.listwidget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by ilafedoseev on 27.02.2018.
 */

public class WidgetService extends RemoteViewsService{

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new WidgetAdapter(this);
    }
}
