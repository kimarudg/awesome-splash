package com.gadiness.kimarudg.awesome.splash.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.gadiness.kimarudg.awesome.splash.R;
import com.gadiness.kimarudg.awesome.splash.util.UIUtil;

/**
 * Created by kimaru on 5/8/18 using Android Studio.
 * Maintainer: David Kimaru
 *
 * @github https://github.com/kimarudg
 * @email kimarudg@gmail.com
 * @phone +254722384549
 * @web gakuu.co.ke
 */
public class EffectsAdapter extends BaseAdapter {

    private Context mContext;

    public EffectsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return Techniques.values().length;
    }

    @Override
    public Object getItem(int position) {
        return Techniques.values()[position].getAnimator();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item, null, false);
        TextView t = (TextView) v.findViewById(R.id.list_item_text);
        t.setText(UIUtil.getTechniqueTitle(getItem(position)));
        v.setTag(Techniques.values()[position]);
        return v;
    }


}