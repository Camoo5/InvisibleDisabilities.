package com.tenacity.invisibledisabilities.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.databinding.FragmentDisabilityDetailsBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityDetailViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityDetailViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisabilityDetailFragment extends Fragment {

    private static final String TAG = "DisabilityDetailFragment";
    private static final String ARG_ITEM_ITEM = "item_id";

    private String shareText;
    DisabilityDetailViewModel mviewModel;

    public static DisabilityDetailFragment newInstance(String disabilityId) {
        Bundle args = new Bundle();
        args.putString(ARG_ITEM_ITEM, disabilityId);
       DisabilityDetailFragment fragment = new DisabilityDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FragmentDisabilityDetailsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_disability_details, container, false);

        String disabilityId = DisabilityDetailFragmentArgs.fromBundle(getArguments()).getDisabilityId();
        setupViewModel(disabilityId);

        binding.setViewModel(mviewModel);
        binding.setLifecycleOwner(this);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mviewModel.addDisabilityToHiddenDisability();
                Snackbar.make(view, R.string.added_disability_to_hidden_disabilities, Snackbar.LENGTH_LONG).show();

                //Todo: Hide button after adding disability to hiddendisability.
            }
        });

        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    private void setupViewModel(String disabilityId) {
        DisabilityDetailViewModelFactory factory = InjectorUtils
                .provideDisabilityDetailViewModelFactory(getActivity(), disabilityId);
       mviewModel = new ViewModelProvider (this, (ViewModelProvider.Factory) factory).get(DisabilityDetailViewModel.class);
        mviewModel.disability.observe(this, new Observer<Disability>() {
            @Override
            public void onChanged(@Nullable Disability disability) {
                Log.e(TAG, "onChanged: "+disability.getName() );
                shareText = disability == null ? "" :
                        String.format(getString(R.string.share_text_disability), disability.getName());
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_disability_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}


