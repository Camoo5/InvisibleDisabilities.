
package com.tenacity.hiddendisabilities.ui.gallery;

import android.content.Intent;
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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.tenacity.hiddendisabilities.R;
import com.tenacity.hiddendisabilities.databinding.FragmentDisabilityDetailBinding;
import com.tenacity.hiddendisabilities.ui.viewmodels.DisabilityDetailViewModel;
import com.tenacity.hiddendisabilities.ui.viewmodels.DisabilityDetailViewModelFactory;
import com.tenacity.hiddendisabilities.utilities.InjectorUtils;

/**
 * A fragment representing a single Disability detail screen.
 */
public class DisabilityDetailFragment extends Fragment {

    private String shareText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDisabilityDetailBinding binding = FragmentDisabilityDetailBinding.inflate(inflater, container, false);
        DisabilityDetailFragmentArgs args = DisabilityDetailFragmentArgs.fromBundle( requireArguments());
        DisabilityDetailViewModelFactory factory = InjectorUtils.provideDisabilityDetailViewModelFactory (
                requireContext(), args.getDisabilityId());
        DisabilityDetailViewModel viewModel = new ViewModelProvider(this, factory).get(DisabilityDetailViewModel.class);
        binding.setLifecycleOwner(this);




        binding.setViewModel(viewModel);
        binding.fab.setOnClickListener(v -> {
            viewModel.addDisabilityToHiddenDisability ();
            Snackbar.make(v, R.string.added_disability_to_hidden_disabilities, Snackbar.LENGTH_LONG).show();
        });

        viewModel.disability.observe(getViewLifecycleOwner(), disability ->
                this.shareText = disability == null ? "" : getString(R.string.share_text_disability, disability.getName()));

        setHasOptionsMenu(true);

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate( R.menu.menu_disability_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId () == R.id.action_share) {
            Intent shareIntent = ShareCompat.IntentBuilder.from ( requireActivity())
                    .setText ( this.shareText )
                    .setType ( "text/plain" )
                    .createChooserIntent ();
            // https://android-developers.googleblog.com/2012/02/share-with-intents.html
            // If we're on Lollipop, we can open the intent as a document
            shareIntent.addFlags ( Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK );
            startActivity ( shareIntent );
            return true;
        }
        return super.onOptionsItemSelected ( item );
    }
}
