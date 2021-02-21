
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
import com.tenacity.invisibledisabilities.adapters.CopingStrategyAdapter;
import com.tenacity.invisibledisabilities.databinding.FragmentCopingStrategyBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


public class CopingStrategyFragment extends Fragment {

    private String shareText;
    private CopingStrategyViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCopingStrategyBinding binding = FragmentCopingStrategyBinding.inflate(inflater, container, false);
        CopingStrategyViewModelFactory factory = InjectorUtils.provideCopingStrategyViewModelFactory(getContext());
        ListAdapter adapter = new CopingStrategyAdapter ();
        binding.setAdapter(adapter);
        this.viewModel = new ViewModelProvider (this, factory).get( CopingStrategyViewModel.class);
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
        this.viewModel.disabilities.observe(getViewLifecycleOwner(), disabilities -> {
            if (disabilities != null) {
                adapter.submitList(disabilities);
            }
        });
    }

    private void updateData() {
        if (viewModel.isFiltered()) {
            viewModel.cleanCriteriaNumber ();
        } else {
            viewModel.setCriteriaNumber ( 1 );
        }
    }
}