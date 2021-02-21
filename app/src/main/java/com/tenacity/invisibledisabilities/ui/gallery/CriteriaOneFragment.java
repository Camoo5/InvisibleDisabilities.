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
import com.tenacity.invisibledisabilities.databinding.FragmentCriteriaOneBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaOneViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaOneViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


public class CriteriaOneFragment extends Fragment {

    private CriteriaOneViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCriteriaOneBinding binding = FragmentCriteriaOneBinding.inflate(inflater, container, false);
        CriteriaOneViewModelFactory factory = InjectorUtils.provideCriteriaOneViewModelFactory (getContext());
        ListAdapter adapter = new CriteriaOneAdapter  ();
        binding.criteriaOneFragment.setAdapter(adapter);
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
