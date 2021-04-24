package com.tenacity.invisibledisabilities.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.data.CopingStrategy;
import com.tenacity.invisibledisabilities.data.SupportingEvidence;
import com.tenacity.invisibledisabilities.databinding.ListItemCopingStrategyBinding;

public class SupportingEvidenceAdapter extends ListAdapter <SupportingEvidence, SupportingEvidenceAdapter.ViewHolder> {

    public SupportingEvidenceAdapter() {
        super(new SupportingEvidenceDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( ListItemSupportingEvidenceBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SupportingEvidence supportingEvidence = getItem(position);
        holder.bind(createOnClickListener(supportingEvidence.getSupportingEvidenceId ()), supportingEvidence);
        holder.itemView.setTag(supportingEvidence);
    }

    private View.OnClickListener createOnClickListener(String supportingEvidence) {
        return v -> Navigation.findNavController(v).navigate(
                SupportingEvidenceFragmentDirections.actionDisabilityListFragmentToDisabilitytDetailFragment(supportingEvidenceId));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemSupportingEvidenceBinding binding;

        ViewHolder(@NonNull ListItemSupportingEvidenceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, SupportingEvidence item) {
            binding.setClickListener(listener);
            binding.setSupportingEvidence(item);
            binding.executePendingBindings();
        }
    }

    static class SupportingEvidenceDiffCallback extends DiffUtil.ItemCallback<SupportingEvidence {

        @Override
        public boolean areItemsTheSame(@NonNull SupportingEvidence oldItem, @NonNull   SupportingEvidence newItem) {
            return oldItem.getSupportingEvidenceId ().equals(newItem.getSupportingEvidenceId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull SupportingEvidence oldItem, @NonNull    SupportingEvidence newItem) {
            return oldItem.equals ( newItem );
        }
    }




}