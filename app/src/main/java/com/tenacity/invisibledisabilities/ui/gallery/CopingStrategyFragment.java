
package com.tenacity.invisibledisabilities.ui.gallery;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.adapters.CopingStrategyAdapter;
import com.tenacity.invisibledisabilities.databinding.FragmentCopingStrategyBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.HiddenDisabilityListViewModel;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;

public class CopingStrategyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCopingStrategyBinding binding = FragmentCopingStrategyBinding.inflate(inflater, container, false);
        CopingStrategyAdapter adapter = new CopingStrategyAdapter ();
        binding.copingStrategyFragment.setAdapter(adapter);
        subScribeUi(adapter, binding);
        return binding.getRoot();
    }

    private void subScribeUi(@NonNull  CopingStrategyAdapter adapter, @NonNull FragmentCopingStrategyBinding binding) {
        CopingStrategyViewModelFactory factory =
                InjectorUtils.provideCopingStrategyViewModelFactory  (requireContext());
        CopingStrategyViewModel viewModel =
                new ViewModelProvider (this, factory).get(CopingStrategyViewModel.class);

        viewModel.copingStrategy.observe(getViewLifecycleOwner(), copingStrategy ->
                binding.setCopingstrategy ( != null && !copingStrategy.isEmpty());

        viewModel.copingStrategy.observe(getViewLifecycleOwner(), copingStrategy -> {
            if (copingStrategy != null && !copingStrategy.isEmpty()) {
                adapter.submitList(copingStrategy);
            }
        });
    }
}
