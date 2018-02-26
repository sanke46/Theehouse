package com.teamtreehouse.testingbase;

/**
 * Created by ilafedoseev on 26.02.2018.
 */

public interface MainActivityView {
    void changeTextViewText(String text);
    void changeBackgroundColor(int color);
    void launchOtherActivity(Class activity);
}
