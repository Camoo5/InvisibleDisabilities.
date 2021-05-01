
package com.tenacity.invisibledisabilities.ui.gallery;

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
import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.databinding.FragmentCopingStrategyDetailBinding;
import com.tenacity.invisibledisabilities.databinding.FragmentDisabilityDetailBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyDetailViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.CopingStrategyDetailViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;

/**
 * A fragment representing a single CopingStrategy detail screen.
 */
public class CopingStrategyDetailFragment extends Fragment {

    private String shareText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCopingStrategyDetailBinding binding = FragmentCopingStrategyDetailBinding.inflate(inflater, container, false);
        CopingStrategyDetailFragmentArgs args = CopingStrategyDetailFragmentArgs.fromBundle( requireArguments());
        CopingStrategyDetailViewModelFactory factory = InjectorUtils.providerCopingStrategyDetailViewModelFactory (
                requireContext(), args.getCopingStrategyId());
        CopingStrategyDetailViewModel viewModel = new ViewModelProvider(this, factory).get(CopingStrategyDetailViewModel.class);
        binding.setLifecycleOwner(this);




        binding.setViewModel(viewModel);
        binding.fab.setOnClickListener(v -> {
            viewModel.addCopingStrategyToHiddenDisability ();
            Snackbar.make(v, R.string.added_copingstrategy_to_hidden_disabilities, Snackbar.LENGTH_LONG).show();
        });

        viewModel.copingStrategy.observe(getViewLifecycleOwner(), copingStrategy ->
                this.shareText = copingstrategy == null ? "" : getString(R.string.share_text_copingstrategy, copingstrategy.getName()));

        setHasOptionsMenu(true);

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate( R.menu.menu_coping_strategy_detail, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId () == R.id.action_share) {
            Intent shareIntent = new ShareCompat.IntentBuilder ( requireActivity () )
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
