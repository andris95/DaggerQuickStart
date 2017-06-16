package com.boost.daggerquickstart.screens.main;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.boost.daggerquickstart.R;
import com.boost.daggerquickstart.data.SPDataSource;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.edt_data)
    EditText edtData;

    @BindView(R.id.pb)
    ProgressBar pb;

    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainPresenter = new MainPresenter(this, new SPDataSource(MainActivity.this));
        mMainPresenter.loadData();
        showProgress();

    }

    @OnClick(R.id.btn_save)
    public void onClickSave() {
        showProgress();
        String data = edtData.getText().toString();
        mMainPresenter.saveData(data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMainPresenter.onAttachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMainPresenter.onDetachView();
    }

    @Override
    public void onDataSaved(String data) {
        makeToast("saved data: " + data);
        hideProgress();
    }

    @Override
    public void onDataLoaded(String data) {
        edtData.setText(data);
        hideProgress();
    }

    @Override
    public void onError() {
        makeToast("onError");
        hideProgress();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }

    private void showProgress() {
        pb.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        pb.setVisibility(View.GONE);
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
