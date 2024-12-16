package com.example.floussyy.ui.mrhaba;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.floussyy.R;

public class marhabaFragment extends Fragment {

    private MarhabaViewModel mViewModel;

    public static marhabaFragment newInstance() {
        return new marhabaFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_marhaba, container, false);

        // Récupérer les données passées dans le bundle
        if (getArguments() != null) {
            String username = getArguments().getString("username");
            String password = getArguments().getString("password");

            // Afficher les données dans un TextView
            TextView textView = root.findViewById(R.id.marhaba);
            textView.setText("Username: " + username + "\nPassword: " + password);
        }

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MarhabaViewModel.class);
        // TODO: Use the ViewModel
    }

}