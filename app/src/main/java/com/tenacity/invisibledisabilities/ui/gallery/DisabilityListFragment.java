
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
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ListAdapter;

import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.adapters.DisabilityAdapter;
import com.tenacity.invisibledisabilities.databinding.FragmentDisabilityListBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityListViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityListViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


public class DisabilityListFragment extends Fragment {

    private DisabilityListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDisabilityListBinding binding = FragmentDisabilityListBinding.inflate(inflater, container, false);
       DisabilityListViewModelFactory factory = InjectorUtils.provideDisabilityListViewModelFactory(getContext());
        ListAdapter adapter = new DisabilityAdapter();
        binding.disabilityList.setAdapter(adapter);
        this.viewModel = ViewModelProviders.of(this, factory).get(DisabilityListViewModel.class);
        subscribeUi(adapter);

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_disability_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter_disability:
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


    }
