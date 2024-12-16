package com.example.floussyy.ui.warning;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.floussyy.R;
import com.example.floussyy.TraitementWarning;

public class WarningFragment extends Fragment {

    private WarningViewModel mViewModel;

    public static WarningFragment newInstance() {
        return new WarningFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_warning, container, false);
        Button btn=view.findViewById(R.id.button_validate_warning);
        EditText value_input_warning=view.findViewById(R.id.input_warning);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String string_value_warning = value_input_warning.getText().toString();
                if (string_value_warning.isEmpty()) {
                    // Optionnel : avertir l'utilisateur si le champ est vide
                    value_input_warning.setError("be careful, you must have limits !");
                    return;
                }

                // Démarrer la nouvelle activité avec l'Intent
                Intent intent = new Intent(getContext(), TraitementWarning.class);
                intent.putExtra("warning_value", string_value_warning); // Ajouter l'information à l'Intent
                startActivity(intent);
            }
        });

        return view;    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(WarningViewModel.class);
        // TODO: Use the ViewModel
    }

}