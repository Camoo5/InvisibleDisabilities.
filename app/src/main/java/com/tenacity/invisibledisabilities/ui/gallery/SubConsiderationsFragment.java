package com.tenacity.invisibledisabilities.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ListAdapter;

import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.adapters.CriteriaOneAdapter;
import com.tenacity.invisibledisabilities.databinding.FragmentCopingStrategyBinding;
import com.tenacity.invisibledisabilities.databinding.FragmentSubConsiderationsBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaOneViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.SubConsiderationsViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.SubConsiderationsViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


public class SubConsiderationsFragment extends Fragment {

    private SubConsiderationsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSubConsiderationsBinding binding = FragmentSubConsiderationsBinding.inflate(inflater, container, false);
        SubConsiderationsViewModelFactory factory = InjectorUtils.provideSubConsiderationsViewModelFactory (getContext());
        ListAdapter adapter = new CriteriaOneAdapter  ();
        binding.copingStrategy.setAdapter(adapter);
        this.viewModel = new ViewModelProvider (this, factory).get(CriteriaOneViewModel.class);
        subscribeUi(adapter);

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate( R.menu.menu_disability_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter_criteria:
                updateData();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void subscribeUi(ListAdapter adapter) {
        this.viewModel.criteriaone

                .observe(getViewLifecycleOwner(), copingstrategy -> {
                    if (criteriaone != null) {
                        adapter.submitList(criteriaone);
                    }
                });
    }


}
