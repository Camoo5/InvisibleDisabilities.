package com.tenacity.invisibledisabilities.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.adapters.HiddenDisabilityAdapter;
import com.tenacity.invisibledisabilities.data.DisabilityAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.ui.viewmodels.HiddenDisabilityListViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.HiddenDisabilityListViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class HiddenDisabilityFragment extends Fragment {

    List<DisabilityAndHiddenDisabilities> disabilitiesList = new ArrayList<>();
    RecyclerView mRecyclerView;
    TextView mTextViewEmptyHiddenDisability;

    public HiddenDisabilityFragment () {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hidden_disability, container, false);
        HiddenDisabilityAdapter adapter = new HiddenDisabilityAdapter(disabilitiesList);

        mTextViewEmptyHiddenDisability = view.findViewById(R.id.empty_hidden_disability);
        mRecyclerView = view.findViewById(R.id.hidden_disability_list);
        mRecyclerView.setAdapter(adapter);
        subscribeUI(adapter);
        return view;
    }

    private void subscribeUI(HiddenDisabilityAdapter adapter) {
        HiddenDisabilityListViewModelFactory factory = InjectorUtils.provideHiddenDisabilityListViewModelFactory (getContext());
        HiddenDisabilityListViewModel viewModel = new ViewModelProvider (this, (ViewModelProvider.Factory) factory).get(HiddenDisabilityListViewModel.class);
        viewModel.hiddenDisabilities.observe(getViewLifecycleOwner(), hiddenDisabilities -> {
            if (hiddenDisabilities != null && !hiddenDisabilities.isEmpty()) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mTextViewEmptyHiddenDisability.setVisibility(View.GONE);
            }else {
                mRecyclerView.setVisibility(View.GONE);
                mTextViewEmptyHiddenDisability.setVisibility(View.VISIBLE);
            }
        });

        viewModel.disabilityAndHiddenDisabilities.observe(getViewLifecycleOwner(), new Observer<List<DisabilityAndHiddenDisabilities>>() {
            @Override
            public void onChanged(@Nullable List<DisabilityAndHiddenDisabilities> hiddenDisabilitiesList) {
                if (hiddenDisabilitiesList != null && !hiddenDisabilitiesList.isEmpty()) {
                    adapter.updateList(hiddenDisabilitiesList);
                }
            }
        });
    }



}


