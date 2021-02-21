
package com.tenacity.invisibledisabilities.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.data.Practitioner;
import com.tenacity.invisibledisabilities.data.SupportingEvidence;
import com.tenacity.invisibledisabilities.databinding.FragmentPractitionerBinding;
import com.tenacity.invisibledisabilities.databinding.FragmentSubConsiderationsBinding;
import com.tenacity.invisibledisabilities.databinding.FragmentSupportingEvidenceBinding;
import com.tenacity.invisibledisabilities.ui.gallery.SupportingEvidenceFragmentDirections;


public class SupportingEvidencesAdapter extends ListAdapter <SupportingEvidence, SupportingEvidenceAdapter.ViewHolder> {

    public SupportingEvidenceAdapter() {
        super ( new SupportingEvidenceDiffCallback ());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder ( FragmentSupportingEvidenceBinding.inflate (
                LayoutInflater.from ( parent.getContext () ), parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SupportingEvidence supportingEvidence= (SupportingEvidence) getItem ( position );
        holder.bind ( createOnClickListener ( SupportingEvidence.getSupportingEvidenceId  () ), supportingEvidence  );
        holder.itemView.setTag ( supportingEvidence );
    }

    private View.OnClickListener createOnClickListener(String practitionersId) {
        return v -> Navigation.findNavController ( v ).navigate (
                SupportingEvidenceFragmentDirections.supportingEvidenceFragmentToCopingStrategyFragment  (practitionersId ) );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentPractitionerBinding binding;

        ViewHolder(@NonNull @NonNull @NonNull FragmentSupportingEvidenceBinding binding) {
            super ( binding.getRoot () );
            this.binding = binding;
        }

        void bind(View.OnClickListener listener,  SupportingEvidence item ) {
            binding.setClickListener(listener);
            binding.setExtensiontobluebadge ( item);
            binding.executePendingBindings();
        }
    }

    static class SupportingEvidenceDiffCallback extends DiffUtil.ItemCallback<Practitioner> {

        @Override
        public boolean areItemsTheSame(@NonNull SupportingEvidence oldItem, @NonNull SupportingEvidence newItem) {
            return oldItem.getSupportingEvidenceId  ().equals(newItem.getSupportingEvidenceId ());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull SupportingEvidence oldItem, @NonNull SupportingEvidence newItem) {
            return oldItem == newItem;
        }
    }
}



