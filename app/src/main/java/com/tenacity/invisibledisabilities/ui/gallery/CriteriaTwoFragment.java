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
import com.tenacity.invisibledisabilities.adapters.CriteriaTwoAdapter;
import com.tenacity.invisibledisabilities.databinding.FragmentCriteriaTwoBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaTwoViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaTwoViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;

import static com.tenacity.invisibledisabilities.BR.criteriatwo;


public class CriteriaTwoFragment extends Fragment {

    private CriteriaTwoViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCriteriaTwoBinding binding = FragmentCriteriaTwoBinding.inflate(inflater, container, false);
        CriteriaTwoViewModelFactory factory = InjectorUtils.provideCriteriaTwoViewModelFactory(getContext());
        ListAdapter adapter = new CriteriaTwoAdapter ();
        binding.copingStrategy.setAdapter(adapter);
        this.viewModel = new ViewModelProvider (this, factory).get(CriteriaTwoViewModel.class);
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
        this.viewModel.criteriaTwo

                .observe(getViewLifecycleOwner(), copingstrategy -> {
                    if (criteriatwo != null) {
                        adapter.submitList(criteriatwo);
                    }
                });
    }


}
