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
import com.tenacity.invisibledisabilities.databinding.FragmentCriteriaTwoBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaTwoViewModel;
import com.tenacity.invisibledisabilities.ui.viewmodels.CriteriaTwoAndHiddenDisabilitiesViewModel;
import com.tenacity.invisibledisabilities.utilities.InjectorUtils;


/**
 * A fragment representing a single criteriatwo screen.
 */
public class CriteriaTwoFragment extends Fragment {

    private String shareText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCriteriaTwoBinding binding = FragmentCriteriaTwoBinding.inflate ( inflater, container, false );
        CriteriaTwoFragmentArgs args = CriteriaTwoFragmentArgs.fromBundle ( requireArguments () );
        CriteriaTwoAndHiddenDisabilitiesViewModel factory = InjectorUtils.provideCriteriaTwoViewModelFactory (
                requireContext () );
        CriteriaTwoViewModel viewModel = new ViewModelProvider ( this, factory ).get ( CriteriaTwoViewModel.class );
        binding.setLifecycleOwner ( this );

        binding.setViewModel ( viewModel );
        binding.fab.setOnClickListener ( v -> {
            viewModel.addCriteriaTwoToHiddenDisability ();
            Snackbar.make ( v, R.string.added_criteriatwo_to_hidden_disabilities, Snackbar.LENGTH_LONG ).show ();
        } );

        viewModel.criteriaTwo.observe ( getViewLifecycleOwner (), criteriaTwo ->
                this.shareText = criteriaTwo == null ? "" : getString ( R.string.share_text_criteriatwo, criteriaTwo.getName () ) );

        setHasOptionsMenu ( true );

        return binding.getRoot ();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate ( R.menu.menu_criteria_two, menu );
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