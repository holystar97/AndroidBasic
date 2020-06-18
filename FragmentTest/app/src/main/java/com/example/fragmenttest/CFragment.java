package com.example.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmenttest.databinding.FragmentCBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment {

    private FragmentCBinding binding;
    private MyViewModel model;
    public CFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentCBinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        model= new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        Button[] btns={binding.button1,binding.button2,binding.button3,binding.button4,binding.button5,binding.button6,binding.button7};

        for(int i=0; i<7;i++){
            final int num=i;
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model.select(num);
                }
            });
        }
        return binding.getRoot();
    }
}
