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
import com.tenacity.invisibledisabilities.databinding.FragmentSubConsiderationsBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.PractitionerViewModelFactory;
import com.tenacity.invisibledisabilities.ui.viewmodels.SubConsiderationsViewModel;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


/**
 * A fragment representing a single subconsiderations screen.
 */
public class SubConsiderationsFragment extends Fragment {

    private String shareText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSubConsiderationsBinding binding = FragmentSubConsiderationsBinding.inflate ( inflater, container, false );
        SubConsiderationsFragmentArgs args = SubConsiderationsFragmentArgs.fromBundle ( requireArguments () );
        PractitionerViewModelFactory factory = InjectorUtils.providePractitionerViewModelFactory (
                requireContext () );
        SubConsiderationsViewModel viewModel = new ViewModelProvider ( this, factory ).get ( SubConsiderationsViewModel.class );
        binding.setLifecycleOwner ( this );

        binding.setViewModel ( viewModel );
        binding.fab.setOnClickListener ( v -> {
            viewModel.addSubConsiderationsToHiddenDisability ();
            Snackbar.make ( v, R.string.added_subconsiderations_to_hidden_disabilities, Snackbar.LENGTH_LONG ).show ();
        } );

        viewModel.subConsiderations.observe ( getViewLifecycleOwner (), subConsiderations ->
                this.shareText = subConsiderations == null ? "" : getString ( R.string.share_text_practitioner, subConsiderations.getName () ) );

        setHasOptionsMenu ( true );

        return binding.getRoot ();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate ( R.menu.menu_sub_considerations, menu );
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