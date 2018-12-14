package com.example.qis_rnd.neoly.View;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.StringRes;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.qis_rnd.neoly.R;


public class TitleBar extends CardView {

    TextView mTxtTitle;
    ImageView mActionButtonBack;
    ImageView mActionButtonShare;
    ImageView mActionButtonMenu;
    ProgressBar mProgressBar;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.titlebar, this, true);
        if (isInEditMode())
            return;

        mTxtTitle = (TextView) findViewById(R.id.titlebar_title);
        mActionButtonBack = (ImageView) findViewById(R.id.titlebar_action_button_back);
        mActionButtonShare = (ImageView) findViewById(R.id.titlebar_action_button_share);
        mActionButtonMenu = (ImageView) findViewById(R.id.titlebar_action_button_menu);
        mProgressBar = (ProgressBar) findViewById(R.id.titlebar_progress)  ;


        // Optional: Prevent pre-L from adding inner card padding
        setPreventCornerOverlap(false);
        // Optional: make Lollipop and above add shadow padding to match pre-L padding
        setUseCompatPadding(true);
        setRadius(0f);
        setCardElevation(16f);
    }

    public void setTitle(@StringRes int resId) {
        mTxtTitle.setText(resId);
    }

    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }

    public void setTitleMaxLength(int length) {
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(length);
        mTxtTitle.setFilters(fArray);
    }

    public void setActionButtonBackClick(OnClickListener onActionButtonClick) {
        mActionButtonBack.setOnClickListener(onActionButtonClick);
    }

    public void setActionButtonShareClick(OnClickListener onActionButtonClick) {
        Log.e("SHARE", "SETCLICK");
        mActionButtonShare.setOnClickListener(onActionButtonClick);
    }

    public void setActionButtonMenuClick(OnClickListener onActionButtonClick) {
        mActionButtonMenu.setOnClickListener(onActionButtonClick);
    }

    public void hideBack() {
        mActionButtonBack.setVisibility(GONE);
    }

    public void showBack() {
        mActionButtonBack.setVisibility(VISIBLE);
    }

    public void hideShare() {
        mActionButtonShare.setVisibility(GONE);
    }

    public void showShare() {
        mActionButtonShare.setVisibility(VISIBLE);
    }

    public void hideMenu() {
        mActionButtonMenu.setVisibility(GONE);
    }

    public void showMenu() {
        mActionButtonMenu.setVisibility(VISIBLE);
    }

    public void showProgress(String action, Integer progress) {
        mProgressBar.setVisibility(VISIBLE);
        if (progress != null) {
            setTitle(action + " (" + Integer.toString(progress) + "%)");
            mProgressBar.setIndeterminate(false);
            mProgressBar.getProgressDrawable().setColorFilter(Color.BLACK, android.graphics.PorterDuff.Mode.SRC_IN);
            mProgressBar.setProgress(progress);
        }
        else {
            setTitle(action);
            mProgressBar.setIndeterminate(true);
            mProgressBar.getIndeterminateDrawable().setColorFilter(Color.BLACK, android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }

    public void hideProgress(String title) {
        setTitle(title);
        mProgressBar.setVisibility(GONE);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        // FIX shadow padding
        if (params instanceof MarginLayoutParams) {
            MarginLayoutParams layoutParams = (MarginLayoutParams) params;
            layoutParams.bottomMargin -= (getPaddingBottom() - getContentPaddingBottom());
            layoutParams.leftMargin -= (getPaddingLeft() - getContentPaddingLeft());
            layoutParams.rightMargin -= (getPaddingRight() - getContentPaddingRight());
            layoutParams.topMargin -= (getPaddingTop() - getContentPaddingTop());
        }

        super.setLayoutParams(params);
    }
}
