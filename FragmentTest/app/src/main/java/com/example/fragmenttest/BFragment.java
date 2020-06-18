package com.example.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmenttest.databinding.FragmentBBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {

    public BFragment() {
        // Required empty public constructor
    }

    private FragmentBBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onStart() {
        super.onStart();

        MyViewModel model= new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        model.getSelected().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                    if(integer>=0){
                        binding.textview.setText(Flower.DIALONGUE[integer]);
                    }
            }
        });
    }
}
