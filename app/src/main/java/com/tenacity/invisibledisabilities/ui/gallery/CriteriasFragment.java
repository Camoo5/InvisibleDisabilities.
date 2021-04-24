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
import com.tenacity.invisibledisabilities.adapters.CriteriasAdapter;
import com.tenacity.invisibledisabilities.databinding.FragmentCriteriasDetailBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriasDetailViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriasListViewModel;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


public class CriteriasFragment extends Fragment {

    private CriteriasListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCriteriasDetailBinding binding = FragmentCriteriasDetailBinding.inflate(inflater, container, false);
        CriteriasDetailViewModelFactory factory = InjectorUtils.providerCriteriaOneViewModelFactory (getContext());
        ListAdapter adapter = new CriteriasAdapter ();
        binding.criteriasFragment.(adapter);
        this.viewModel = new ViewModelProvider (this, factory).get( CriteriasListViewModel.class);
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
