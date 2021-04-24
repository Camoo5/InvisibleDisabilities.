
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
import com.tenacity.invisibledisabilities.databinding.FragmentCopingStrategyDetailBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyListViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyListViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


public class CopingStrategyListFragment extends Fragment {

    private CopingStrategyListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCopingStrategyDetailBinding binding = FragmentCopingStrategyDetailBinding.inflate(inflater, container, false);
        CopingStrategyListViewModelFactory factory = InjectorUtils.providerCopingStrategyViewModelFactory(getContext());
        ListAdapter adapter = new CopingStrategyAdapter ();
        binding.copingstrategyList.setAdapter(adapter);
        this.viewModel = new ViewModelProvider (this, factory).get( CopingStrategyListViewModel.class);
        subscribeUi( (CopingStrategyAdapter) adapter );

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate( R.menu.menu_coping_strategy_list, menu);
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
        this.viewModel.copingstrategies.observe(getViewLifecycleOwner(), copingStrategy -> {
            if (copingstrategies != null) {
                adapter.submitList(copingStrategy);
            }
        });
    }

    private void updateData() {
        if (viewModel.isFiltered()) {
            viewModel.cleanCriteriaTypeNumber ();
        } else {
            viewModel.setCriteriaTypeNumber ( 1 );
        }
    }
}