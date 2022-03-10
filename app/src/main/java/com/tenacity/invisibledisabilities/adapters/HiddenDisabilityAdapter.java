package com.tenacity.invisibledisabilities.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.data.DisabilityAndHiddenDisabilities;
import com.tenacity.invisibledisabilities.databinding.ListItemHiddenDisabilityBinding;
import com.tenacity.invisibledisabilities.ui.viewmodels.DisabilityAndHiddenDisabilitiesViewModel;

import java.util.List;

public class HiddenDisabilityAdapter extends RecyclerView.Adapter< HiddenDisabilityAdapter.ViewHolder> {

      List<DisabilityAndHiddenDisabilities> disabilitiesList;

    public HiddenDisabilityAdapter(List<DisabilityAndHiddenDisabilities> disabilitiesList) {
        this.disabilitiesList = disabilitiesList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        ListItemHiddenDisabilityBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.list_item_hidden_disability, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(disabilitiesList.get(position));
    }

    @Override
    public int getItemCount() {
        return disabilitiesList.size();
    }

    public void updateList(List<DisabilityAndHiddenDisabilities> disabilities) {
       HiddenDisabilityDiffCallback diffCallback= new HiddenDisabilityDiffCallback(this.disabilitiesList, disabilities);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.disabilitiesList.clear();
        this.disabilitiesList.addAll(disabilities);
        diffResult.dispatchUpdatesTo(this);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemHiddenDisabilityBinding binding;

        ViewHolder(@NonNull ListItemHiddenDisabilityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(DisabilityAndHiddenDisabilities disabilityAndHiddenDisabilities) {
            binding.setViewModel(new DisabilityAndHiddenDisabilitiesViewModel(
                    binding.getRoot().getContext(), disabilityAndHiddenDisabilities));
            binding.executePendingBindings();
        }
    }
}