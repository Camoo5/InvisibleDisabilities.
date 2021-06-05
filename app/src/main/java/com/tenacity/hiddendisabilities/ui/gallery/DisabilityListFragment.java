
package com.tenacity.hiddendisabilities.ui.gallery;

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

import com.tenacity.hiddendisabilities.R;
import com.tenacity.hiddendisabilities.adapters.DisabilityAdapter;
import com.tenacity.hiddendisabilities.data.Disability;
import com.tenacity.hiddendisabilities.databinding.FragmentDisabilityListBinding;
import com.tenacity.hiddendisabilities.ui.viewmodels.DisabilityListViewModel;
import com.tenacity.hiddendisabilities.ui.viewmodels.DisabilityListViewModelFactory;
import com.tenacity.hiddendisabilities.utilities.InjectorUtils;


public class DisabilityListFragment extends Fragment {

    private DisabilityListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDisabilityListBinding binding = FragmentDisabilityListBinding.inflate(inflater, container, false);
        DisabilityListViewModelFactory factory = InjectorUtils.provideDisabilityListViewModelFactory(getContext());
        ListAdapter <Disability, DisabilityAdapter.ViewHolder> adapter = new DisabilityAdapter();
        binding.disabilityList.setAdapter(adapter);
        this.viewModel = new ViewModelProvider (this, factory).get(DisabilityListViewModel.class);
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
        if (item.getItemId () == R.id.filter_criteria) {
            updateData ();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void subscribeUi(ListAdapter <Disability, DisabilityAdapter.ViewHolder> adapter) {
        this.viewModel.disabilities.observe(getViewLifecycleOwner(), disabilities -> {
            if (disabilities != null) {
                adapter.submitList ( disabilities );
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