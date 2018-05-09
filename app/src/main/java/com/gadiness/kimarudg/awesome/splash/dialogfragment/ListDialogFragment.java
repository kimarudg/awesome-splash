package com.gadiness.kimarudg.awesome.splash.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.gadiness.kimarudg.awesome.splash.R;
import com.gadiness.kimarudg.awesome.splash.activity.MainActivity;
import com.gadiness.kimarudg.awesome.splash.adapters.EffectsAdapter;
import com.gadiness.kimarudg.awesome.splash.util.Constants;
import com.gadiness.kimarudg.awesome.splash.util.UIUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.Unbinder;

/**
 * Created by kimaru on 5/8/18 using Android Studio.
 * Maintainer: David Kimaru
 *
 * @github https://github.com/kimarudg
 * @email kimarudg@gmail.com
 * @phone +254722384549
 * @web gakuu.co.ke
 */
public class ListDialogFragment extends AppCompatDialogFragment {

    @BindView(R.id.txtTitle)
    TextView mTxtTitle;
    @BindView(R.id.lvTechn)
    ListView mLlvTechn;

    private EffectsAdapter mAdapter;
    private int forWhat;
    Unbinder unbinder;


    public static ListDialogFragment newInstance(int flag) {
        ListDialogFragment dialogFragment = new ListDialogFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.FOR_WHAT, flag);
        dialogFragment.setArguments(args);
        return dialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_fragment_list, container, false);
        unbinder = ButterKnife.bind(this, v);

        initUI();

        return v;
    }


    public void initUI() {
        setCancelable(true);

        mAdapter = new EffectsAdapter(getActivity());
        mLlvTechn.setAdapter(mAdapter);

        forWhat = getArguments().getInt(Constants.FOR_WHAT);
    }


    @OnItemClick(R.id.lvTechn)
    public void onListClick(AdapterView<?> parent, View view, int position, long id) {
        Techniques t = Techniques.values()[position];
        MainActivity a = ((MainActivity) getActivity());
        String selected = UIUtil.getTechniqueTitle(mAdapter.getItem(position));
        if (forWhat == Constants.FOR_LOGO) {
            a.getConfigSplash().setAnimLogoSplashTechnique(t);
            a.setTechnique(Constants.FOR_LOGO, selected);
        } else {
            a.getConfigSplash().setAnimTitleTechnique(t);
            a.setTechnique(Constants.FOR_TEXT, selected);
        }


        dismiss();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
