package com.tenacity.invisibledisabilities.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tenacity.invisibledisabilities.adapters.HiddenDisabilityAdapter;
import com.tenacity.invisibledisabilities.databinding.FragmentHiddenDisabilityBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.HiddenDisabilityListViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.HiddenDisabilityListViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;

/**
 * A simple {@link Fragment} subclass.
 */

public class HiddenDisabilityFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHiddenDisabilityBinding binding = FragmentHiddenDisabilityBinding.inflate(inflater, container, false);
      HiddenDisabilityAdapter adapter = new HiddenDisabilityAdapter();
        binding.hiddenDisabilityList.setAdapter(adapter);
        subScribeUi(adapter, binding);
        return binding.getRoot();
    }

    private void subScribeUi(@NonNull HiddenDisabilityAdapter adapter, @NonNull FragmentHiddenDisabilityBinding binding) {
        HiddenDisabilityListViewModelFactory factory =
                InjectorUtils.provideHiddenDisabilityListViewModelFactory(requireContext());
        HiddenDisabilityListViewModel viewModel =
                new ViewModelProvider(this, factory).get(HiddenDisabilityListViewModel.class);

        viewModel.hiddenDisabilities.observe(getViewLifecycleOwner(), hiddenDisabilities ->
                binding.setHasDisabilities(hiddenDisabilities != null && !hiddenDisabilities.isEmpty()));

        viewModel.disabilityAndHiddenDisabilities.observe(getViewLifecycleOwner(), disabilityAndHiddenDisabilites -> {
            if (disabilityAndHiddenDisabilites != null && !disabilityAndHiddenDisabilites.isEmpty()) {
                adapter.submitList(disabilityAndHiddenDisabilites);
            }
        });
    }
} 


