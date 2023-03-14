package tech.edisystem.appmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import tech.edisystem.appmoney.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
    }
}