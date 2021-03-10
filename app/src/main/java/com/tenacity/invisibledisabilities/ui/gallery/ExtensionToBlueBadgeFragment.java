package com.tenacity.invisibledisabilities.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ListAdapter;

import com.tenacity.invisibledisabilities.adapters.ExtensionToBlueBadgeAdapter;
import com.tenacity.invisibledisabilities.databinding.FragmentExtensionToBlueBadgeBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.ExtensionToBlueBadgeViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.ExtensionToBlueBadgeViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


public class ExtensionToBlueBadgeFragment extends Fragment {

    private ExtensionToBlueBadgeViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentExtensionToBlueBadgeBinding binding = FragmentExtensionToBlueBadgeBinding .inflate(inflater, container, false);
        ExtensionToBlueBadgeViewModelFactory factory = InjectorUtils.provideExtensionToBlueBadgeViewModelFactory(getContext());
        ListAdapter adapter = new ExtensionToBlueBadgeAdapter ();
        binding.extensionToBlueBadge .setAdapter(adapter);
        this.viewModel = (ExtensionToBlueBadgeViewModel) new ViewModelProvider (this, factory).get(ExtensionToBlueBadgeViewModel.class);



        setHasOptionsMenu(true);
        return binding.getRoot();
    }



}
