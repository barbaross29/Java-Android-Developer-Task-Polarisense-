package com.shekhov.test_appl.presentation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shekhov.test_appl.Core.DI.RegisterActivityVMComponent;
import com.shekhov.test_appl.R;
import com.shekhov.test_appl.databinding.FragmentPersonalityBinding;
import com.shekhov.test_appl.domain.ViewModels.PersonalityFragmentViewModel;
import com.shekhov.test_appl.domain.models.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonalityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonalityFragment extends Fragment {

    private com.shekhov.test_appl.databinding.FragmentPersonalityBinding binding;
    private PersonalityFragmentViewModel personalityFragmentViewModel;

    public PersonalityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonalityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonalityFragment newInstance(String param1, String param2) {
        PersonalityFragment fragment = new PersonalityFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personalityFragmentViewModel = new ViewModelProvider(this).get(PersonalityFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPersonalityBinding.inflate(inflater, container, false);
        binding.firstnameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().equals("") && !binding.lastnameText.getText().toString().equals(""))
                {
                    binding.confirmButton.setBackgroundResource(R.drawable.rounded_corners_selected);
                    binding.confirmButton.setClickable(true);
                    binding.confirmButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            personalityFragmentViewModel.insertUser(new User(editable.toString(), binding.lastnameText.getText().toString(), getSharedPreference("sex")));
                            getActivity().getApplicationContext().getSharedPreferences("User", Context.MODE_PRIVATE).edit().remove("sex");
                            RegisterActivity.navController.navigate(R.id.finishFragment);
                        }
                    });
                }
                else{
                    binding.confirmButton.setBackgroundResource(R.drawable.rounded_corners);
                    binding.confirmButton.setClickable(false);
                }
            }
        });

        binding.lastnameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().equals("") && !binding.firstnameText.getText().toString().equals(""))
                {
                    binding.confirmButton.setBackgroundResource(R.drawable.rounded_corners_selected);
                    binding.confirmButton.setClickable(true);
                    binding.confirmButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            personalityFragmentViewModel.insertUser(new User(binding.firstnameText.getText().toString(), editable.toString(), getSharedPreference("sex")));
                            getActivity().getApplicationContext().getSharedPreferences("User", Context.MODE_PRIVATE).edit().remove("sex");
                            RegisterActivity.navController.navigate(R.id.finishFragment);
                        }
                    });
                }
                else{
                    binding.confirmButton.setBackgroundResource(R.drawable.rounded_corners);
                    binding.confirmButton.setClickable(false);
                }
            }
        });
        return binding.getRoot();
    }

    private Boolean getSharedPreference(String key)
    {
        SharedPreferences prefs = getActivity().getApplicationContext().getSharedPreferences("User",
                Context.MODE_PRIVATE);
        return prefs.getBoolean(key, true);
    }
}