package com.shang.moduleswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.shang.moduleswitch.view.ModeListView;

import java.util.ArrayList;

public class SwitchActivity extends AppCompatActivity {

    private ModeListView modeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        modeListView = (ModeListView)findViewById(R.id.mode_list_layout);
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        modeListView.init(integers);
        modeListView.setModeSwitchListener(new ModeListView.ModeSwitchListener() {
            @Override
            public void onModeSelected(int modeIndex) {
                modeListView.startModeSelectionAnimation();
                Toast.makeText(SwitchActivity.this,"你选中了第"+modeIndex+"个",Toast.LENGTH_SHORT).show();
            }

            @Override
            public int getCurrentModeIndex() {
                return 0;
            }

            @Override
            public void onSettingsSelected() {

            }
        });

    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (modeListView != null) {
            modeListView.setVisibility(View.VISIBLE);
            return modeListView.dispatchTouchEvent(ev);
        }
        return false;
    }
}
