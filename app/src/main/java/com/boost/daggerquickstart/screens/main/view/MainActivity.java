package com.boost.daggerquickstart.screens.main.view;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.boost.daggerquickstart.DaggerQuickstartApplication;
import com.boost.daggerquickstart.R;
import com.boost.daggerquickstart.screens.main.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.edt_data)
    EditText edtData;

    @BindView(R.id.pb)
    ProgressBar pb;

    @Inject MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //mMainPresenter = new MainPresenterImpl(new SPDataSource(MainActivity.this));
        DaggerQuickstartApplication.dependencyGraph.initMainComponent().inject(this);
        mMainPresenter.attach(this);
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
        mMainPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMainPresenter.detach();
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
    public void onLoadDataError() {
        makeToast("onLoadError");
        hideProgress();
    }

    @Override
    public void onSaveDataError() {
        makeToast("onSaveDataError");
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

    private void makeToast(int messageRes) {
        Toast.makeText(MainActivity.this, messageRes, Toast.LENGTH_SHORT).show();
    }
}
