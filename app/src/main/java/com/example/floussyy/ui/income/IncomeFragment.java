package com.example.floussyy.ui.income;

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
import com.example.floussyy.TraitementIncome;

public class IncomeFragment extends Fragment {

    private IncomeViewModel mViewModel;

    public static IncomeFragment newInstance() {
        return new IncomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_income, container, false);
        Button btn=view.findViewById(R.id.button_validate);
        EditText value_input_income=view.findViewById(R.id.input_income);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String string_value_income = value_input_income.getText().toString();
                if (string_value_income.isEmpty()) {
                    // Optionnel : avertir l'utilisateur si le champ est vide
                    value_input_income.setError("enter income !");
                    return;
                }

                // Démarrer la nouvelle activité avec l'Intent
                Intent intent = new Intent(getContext(), TraitementIncome.class);
                intent.putExtra("income_value", string_value_income); // Ajouter l'information à l'Intent
                startActivity(intent);
            }
        });

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(IncomeViewModel.class);
        // TODO: Use the ViewModel
    }

}