package com.tenacity.invisibledisabilities.ui.gallery;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.databinding.FragmentDisabilityDetailBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityDetailViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityDetailViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisabilityDetailFragment extends Fragment {

    private String shareText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDisabilityDetailBinding binding = FragmentDisabilityDetailBinding.inflate(inflater, container, false);
        DisabilityDetailFragmentArgs args = DisabilityDetailFragmentArgs.fromBundle(Preconditions.checkNotNull(getArguments()));
        DisabilityDetailViewModelFactory factory = InjectorUtils.provideDisabilityDetailViewModelFactory(
                requireContext(), args.getDisabilityId());
        DisabilityDetailViewModel viewModel = ViewModelProviders.of(this, factory).get(DisabilityDetailViewModel.class);
        binding.setLifecycleOwner(this);

        binding.setViewModel(viewModel);
        binding.fab.setOnClickListener(v -> {
            viewModel.addDisabilityToHiddenDisability();
            Snackbar.make(v, R.string.added_disability_to_hidden_disabilities, Snackbar.LENGTH_LONG).show();
        });

        viewModel.disability.observe(this, disability ->
                this.shareText = disability == null ? "" : getString(R.string.share_text_disability, disability.getName()));

        setHasOptionsMenu(true);

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_disability_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                Intent shareIntent = ShareCompat.IntentBuilder.from(Preconditions.checkNotNull(getActivity()))
                        .setText(this.shareText)
                        .setType("text/plain")
                        .createChooserIntent();
                // https://android-developers.googleblog.com/2012/02/share-with-intents.html
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // If we're on Lollipop, we can open the intent as a document
                    shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                } else {
                    // Else, we will use the old CLEAR_WHEN_TASK_RESET flag
                    shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                }
                startActivity(shareIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

