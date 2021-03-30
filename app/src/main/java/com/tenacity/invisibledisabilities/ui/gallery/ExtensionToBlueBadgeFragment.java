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
import com.tenacity.invisibledisabilities.databinding.FragmentExtensionToBlueBadgeBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.ExtensionToBlueBadgeViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.ExtensionToBlueBadgeViewModelFactory;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


/**
 * A fragment representing a single practitioner screen.
 */
    public class ExtensionToBlueBadgeFragment extends Fragment {

    private String shareText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentExtensionToBlueBadgeBinding binding = FragmentExtensionToBlueBadgeBinding.inflate ( inflater, container, false );
        ExtensionToBlueBadgeFragmentArgs args = ExtensionToBlueBadgeFragmentArgs.fromBundle ( requireArguments () );
        ExtensionToBlueBadgeViewModelFactory factory = InjectorUtils.providerExtensionToBlueBadgeViewModelFactory(
                requireContext(), args.getExtensiontobluebadgeId  ());
        ExtensionToBlueBadgeViewModel viewModel = new ViewModelProvider ( this, factory ).get( ExtensionToBlueBadgeViewModel.class);
        binding.setLifecycleOwner ( this );

        binding.setViewModel ( viewModel );
        binding.fab.setOnClickListener ( v -> {
            viewModel.addExtensionToBlueBadgeToHiddenDisability ();
            Snackbar.make ( v, R.string.added_extensiontobluebadge_to_hidden_disabilities, Snackbar.LENGTH_LONG ).show ();
        } );

        viewModel.extensionToBlueBadge.observe ( getViewLifecycleOwner (), extensionToBlueBadge ->
                this.shareText = extensionToBlueBadge == null ? "" : getString ( R.string.share_text_extensiontobluebadge, extensionToBlueBadge.getName () ) );

        setHasOptionsMenu ( true );

        return binding.getRoot ();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate ( R.menu.menu_extension_to_bluebadge, menu );
        super.onCreateOptionsMenu ( menu, inflater );
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