
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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.adapters.DisabilityAdapter;
import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityListViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityListViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;

import java.util.ArrayList;
import java.util.List;


public class DisabilityListFragment extends Fragment {

    private List<Disability> disabilitiesList = new ArrayList<>();
    private DisabilityListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disability_list, container, false);

        DisabilityListViewModelFactory factory = InjectorUtils.provideDisabilityListViewModelFactory(getActivity());
       viewModel = ViewModelProviders.of(this, (ViewModelProvider.Factory) factory).get(DisabilityListViewModel.class);

       DisabilityAdapter adapter = new DisabilityAdapter(disabilitiesList);
       RecyclerView recyclerView = view.findViewById(R.id.disability_list);
       recyclerView.setAdapter(adapter);
       subscribeUi(adapter);

        setHasOptionsMenu(true);
        return view;
    }


    @Override
    public void onCreateOptionsMenu( Menu menu,  MenuInflater inflater) {
        inflater.inflate(R.menu.menu_disability_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void subscribeUi(DisabilityAdapter adapter) {
      viewModel.getDisabilities().observe(getViewLifecycleOwner(),new Observer<List<Disability>>() {
          @Override
          public void onChanged(@Nullable List<Disability> disabilities) {
              adapter.updateItems(disabilities);
          }
      });
    }

}
