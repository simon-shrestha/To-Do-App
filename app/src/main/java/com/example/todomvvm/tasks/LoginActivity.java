package com.example.todomvvm.tasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.example.todomvvm.LoginActivityViewModel;
import com.example.todomvvm.LoginEntry;
import com.example.todomvvm.R;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    LoginActivityViewModel viewModel;
    String input_pattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final PatternLockView patternLockView = findViewById(R.id.patternView);
        viewModel = ViewModelProviders.of(this).get(LoginActivityViewModel.class);
        patternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {

            }

            @Override
            public void onComplete(List pattern) {
                input_pattern = PatternLockUtils.patternToString(patternLockView, pattern);
                viewModel.getTotalCount().observe(LoginActivity.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        if (integer == 0)
                        {
                            LoginEntry entry = new LoginEntry(1, input_pattern);
                            viewModel.insertPattern(entry);
                            Toast.makeText(LoginActivity.this, "Pattern saved", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            viewModel.getPatternValue().observe(LoginActivity.this, new Observer<String>() {
                                @Override
                                public void onChanged(String s) {
                                    if (s.equals(input_pattern)) {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else
                                    {
                                        Toast.makeText(LoginActivity.this, "Incorrect Pattern", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                    }
                });
            }

            @Override
            public void onCleared() {

            }
        });
    }
}
