package com.teamtreehouse.testingbase;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    @Mock
    private MainActivityView view;
    private MainActivityPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void editTextUpdated() throws Exception {
        String givenString = "test123";

        presenter.editTextUpdated(givenString);

        Mockito.verify(view).changeTextViewText(givenString);
    }

    @Test
    public void colorSelected() throws Exception {
        int index = 2;
        int givenColor = Color.GREEN;

        presenter.colorSelected(index);

        Mockito.verify(view).changeBackgroundColor(givenColor);
    }

    @Test
    public void launchOtherActivityButtonOnClicked() throws Exception {
        Class clazz = OtherActivity.class;

        presenter.launchOtherActivityButtonOnClicked(clazz);

        Mockito.verify(view).launchOtherActivity(clazz);
    }

}