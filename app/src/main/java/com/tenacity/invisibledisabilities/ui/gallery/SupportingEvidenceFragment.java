
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
import com.tenacity.invisibledisabilities.adapters.SubConsiderationsAdapter;
import com.tenacity.invisibledisabilities.adapters.SupportingEvidenceAdapter;
import com.tenacity.invisibledisabilities.databinding.FragmentSupportingEvidenceBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaOneViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.SupportingEvidenceViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.SupportingEvidenceViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


public class SupportingEvidenceFragment extends Fragment {

    private SupportingEvidenceViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSupportingEvidenceBinding binding = FragmentSupportingEvidenceBinding.inflate(inflater, container, false);
        SupportingEvidenceViewModelFactory factory = InjectorUtils.provideSupportingEvidenceViewModelFactory (getContext());
        ListAdapter adapter = new SupportingEvidenceAdapter ();
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
        this.viewModel.SupportingEvidenceLiveData

                .observe(getViewLifecycleOwner(), copingstrategy -> {
                    if (criteriaone != null) {
                        adapter.submitList(criteriaone);
                    }
                });
    }


}
