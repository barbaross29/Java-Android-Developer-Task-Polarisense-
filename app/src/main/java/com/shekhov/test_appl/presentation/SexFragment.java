package com.shekhov.test_appl.presentation;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shekhov.test_appl.R;
import com.shekhov.test_appl.databinding.FragmentSexBinding;
import com.shekhov.test_appl.domain.ViewModels.RegActivityViewModel;
import com.shekhov.test_appl.domain.ViewModels.SexFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SexFragment extends Fragment {

    private FragmentSexBinding binding;
    private SexFragmentViewModel sexFragmentViewModel;
    public SexFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SexFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SexFragment newInstance(String param1, String param2) {
        SexFragment fragment = new SexFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        model = Model.getINSTANCE(getContext());
        sexFragmentViewModel = new ViewModelProvider(this).get(SexFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSexBinding.inflate(inflater, container, false);
        binding.maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundResource(R.drawable.rounded_corners_selected);
                binding.femaleButton.setBackgroundResource(R.drawable.rounded_corners);
                if(!binding.nextButton.isClickable())
                {
                    binding.nextButton.setBackgroundResource(R.drawable.rounded_corners_selected);
                    binding.nextButton.setClickable(true);
                   // model.newUser.setSex(true);
                    sexFragmentViewModel.setSharedPreference(getContext(),"sex", true );
                    binding.nextButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.personalityFragment, null));
                }
            }
        });
        binding.femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundResource(R.drawable.rounded_corners_selected);
                binding.maleButton.setBackgroundResource(R.drawable.rounded_corners);
                if(!binding.nextButton.isClickable())
                {
                    binding.nextButton.setBackgroundResource(R.drawable.rounded_corners_selected);
                    binding.nextButton.setClickable(true);
                    //model.newUser.setSex(false);
                    sexFragmentViewModel.setSharedPreference(getContext(),"sex", false );
                    binding.nextButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.personalityFragment, null));
                }
            }
        });
        return binding.getRoot();
    }

}