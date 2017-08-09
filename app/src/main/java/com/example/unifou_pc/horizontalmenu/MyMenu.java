package com.example.unifou_pc.horizontalmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by unifou-PC on 2017/8/9.
 */

public class MyMenu extends HorizontalScrollView{

    private LinearLayout mView;
    private ViewGroup mMenu;
    private ViewGroup mContext;
    private int screenwidth;
    private int menuWidth;
    private int rightPading;
    private boolean once = false;

    public MyMenu(Context context) {
        this(context,null);
    }

    public MyMenu(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public MyMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        WindowManager mwindow = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        mwindow.getDefaultDisplay().getRealMetrics(metrics);
        screenwidth = metrics.widthPixels;

        rightPading = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,context.getResources().getDisplayMetrics());

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if(!once){
            mView = (LinearLayout) getChildAt(0);
            mContext = (ViewGroup)mView.getChildAt(1);
            mMenu = (ViewGroup)mView.getChildAt(0);

           menuWidth =  mMenu.getLayoutParams().width = screenwidth-rightPading;
            mContext.getLayoutParams().width = screenwidth;
            once = true;
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed){
            this.scrollTo(menuWidth,0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if(scrollX>screenwidth/2){
                    smoothScrollTo(menuWidth,0);
                }else{
                    smoothScrollTo(0,0);
                }
                return true;
        }

        return super.onTouchEvent(ev);
    }
}
