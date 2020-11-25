package com.example.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.login.databinding.FragmentMiLoginBinding;

public class MiLoginFragment extends Fragment {
    private FragmentMiLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMiLoginBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MiLoginViewModel miLoginViewModel = new ViewModelProvider(this).get(MiLoginViewModel.class);

        binding.is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = binding.usuario.getText().toString();
                String contrasenya = binding.contrasenya.getText().toString();

                miLoginViewModel.calcular(usuario,contrasenya);
            }
        });



    }
}