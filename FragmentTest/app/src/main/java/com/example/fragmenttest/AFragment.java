package com.example.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fragmenttest.databinding.FragmentABinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {

    public AFragment() {
        // Required empty public constructor
    }
    private FragmentABinding binding;
    private MyViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentABinding.inflate(inflater,container,false);
        // Inflate the layout for this fragment
        model= new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        binding.listview.setAdapter(new ArrayAdapter<>(requireContext(),android.R.layout.simple_list_item_activated_1, Flower.TITLES));
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                model.select(position);
            }
        });

        binding.listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        return binding.getRoot();
    }
}
