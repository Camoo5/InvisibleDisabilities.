
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

public class HiddenDisabilityAdapter extends RecyclerView.Adapter<HiddenDisabilityAdapter.ViewHolder> {

    List<DisabilityAndHiddenDisabilities> hiddenDisabilitiesList;

    public HiddenDisabilityAdapter(List<DisabilityAndHiddenDisabilities> hiddenDisabilitiesList) {
        this.hiddenDisabilitiesList = hiddenDisabilitiesList;
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
        viewHolder.bind(hiddenDisabilitiesList.get(position));
    }

    @Override
    public int getItemCount() {
        return hiddenDisabilitiesList.size();
    }

    public void updateList(List<DisabilityAndHiddenDisabilities> hiddenDisabilities) {
        HiddenDisabilityDiffCallback diffCallback = new HiddenDisabilityDiffCallback(this.hiddenDisabilitiesList, hiddenDisabilities);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.hiddenDisabilitiesList.clear();
        this.hiddenDisabilitiesList.addAll(hiddenDisabilities);
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