package com.shekhov.test_appl.presentation;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shekhov.test_appl.Core.DI.RegisterActivityVMComponent;
import com.shekhov.test_appl.R;
import com.shekhov.test_appl.domain.ViewModels.FinishFragmentViewModel;
import com.shekhov.test_appl.domain.models.Quote;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FinishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FinishFragment extends Fragment {

    private FinishFragmentViewModel finishFragmentViewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FinishFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FinishFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FinishFragment newInstance(String param1, String param2) {
        FinishFragment fragment = new FinishFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        finishFragmentViewModel = new ViewModelProvider(this).get(FinishFragmentViewModel.class);
        Quote randomQ =  finishFragmentViewModel.getQuote();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(randomQ.getAuthor())
                .setMessage(randomQ.getQuote())
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Закрываем диалоговое окно
                        dialog.cancel();
                    }
                }).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish, container, false);
    }
}