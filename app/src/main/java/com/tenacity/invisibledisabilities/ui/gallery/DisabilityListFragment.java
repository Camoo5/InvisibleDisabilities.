
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
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.adapters.DisabilityAdapter;
import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityListViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityListViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class DisabilityListFragment extends Fragment {

    private final List <Disability> disabilitiesList = new ArrayList <> ();
    private DisabilityListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disability_list, container, false);

       DisabilityListViewModelFactory factory = InjectorUtils.provideDisabilityListViewModelFactory(getActivity());
        viewModel = new ViewModelProvider (this, factory).get(DisabilityListViewModel.class);

        DisabilityAdapter adapter = new DisabilityAdapter(disabilitiesList);
        RecyclerView recyclerView = view.findViewById(R.id.disability_list);
        recyclerView.setAdapter(adapter);
        subscribeUI(adapter);

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_disability_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void subscribeUI(DisabilityAdapter adapter) {
        viewModel.getDisabilities ().observe(getViewLifecycleOwner(), disabilities -> adapter.updateItems(disabilities) );
    }

}