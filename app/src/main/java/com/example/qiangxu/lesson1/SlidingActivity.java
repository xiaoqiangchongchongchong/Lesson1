package com.example.qiangxu.lesson1;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class SlidingActivity extends AppCompatActivity implements SlidingPaneLayout.PanelSlideListener {

    private SlidingPaneLayout slidingPaneLayout;
    private FrameLayout frameLayout;
    private View menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);

        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sliding);

        frameLayout = (FrameLayout) findViewById(R.id.sliding_main);

        //滑动的监听
        slidingPaneLayout.setPanelSlideListener(this);

        menu = findViewById(R.id.expend_menu);

//        slidingPaneLayout.closePane();
//
//        slidingPaneLayout.openPane();

    }

    /**
     * 滑动中
     * @param panel
     * @param slideOffset  【0 - 1】
     */
    @Override
    public void onPanelSlide(View panel, float slideOffset) {

        //兼容2.0版本
        ViewCompat.setPivotX(frameLayout, frameLayout.getWidth()/2);
        ViewCompat.setPivotY(frameLayout, frameLayout.getHeight() / 2);

        ViewCompat.setScaleX(frameLayout, 1 - slideOffset * 0.5f);
        ViewCompat.setScaleY(frameLayout, 1 - slideOffset * 0.5f);

        ViewCompat.setTranslationX(menu, - menu.getWidth()/2 * (1-slideOffset));


//        frameLayout.setPivotX(0);
//        frameLayout.setPivotY(0);
//        frameLayout.setScaleX(1 - slideOffset * 0.5f);
//        frameLayout.setScaleY(1 - slideOffset * 0.5f);

    }

    @Override
    public void onPanelOpened(View panel) {

    }

    @Override
    public void onPanelClosed(View panel) {

    }
}
