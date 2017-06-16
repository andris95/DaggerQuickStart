package com.boost.daggerquickstart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.edt_data)
    EditText edtData;

    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainPresenter = new MainPresenter(this);
    }

    @OnClick(R.id.btn_save)
    public void onClickSave() {
        String data = edtData.getText().toString();
        //makeToast(data);
        mMainPresenter.saveData(data);
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataSaved(String data) {
        makeToast("saved data: " + data);
    }
}
