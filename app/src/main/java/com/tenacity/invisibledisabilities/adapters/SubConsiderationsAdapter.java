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
import com.tenacity.invisibledisabilities.data.SubConsiderations;
import com.tenacity.invisibledisabilities.databinding.ListItemCopingStrategyBinding;
import com.tenacity.invisibledisabilities.databinding.ListItemSubconsiderationsBinding;

public class SubConsiderationsAdapter extends ListAdapter <SubConsiderations, SubConsiderationsAdapter.ViewHolder> {

    public SubConsiderationsAdapter() {
        super(new SubConsiderationsDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( ListItemSubconsiderationsBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubConsiderations subConsiderations = getItem(position);
        holder.bind(createOnClickListener(subConsiderations.getSubConsiderationsId ()), subConsiderations);
        holder.itemView.setTag(subConsiderations);
    }

    private View.OnClickListener createOnClickListener(String copingstrategyId) {
        return v -> Navigation.findNavController(v).navigate(
                SubConsiderationsFragmentDirections.actionDisabilityListFragmentToDisabilitytDetailFragment(copingstrategyId));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemSubConsiderationsBinding binding;

        ViewHolder(@NonNull @NonNull ListItemSubconsiderationsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, SubConsiderations item) {
            binding.setClickListener(listener);
            binding.setCSubConsiderations(item);
            binding.executePendingBindings();
        }
    }

    static class SubConsiderationsDiffCallback extends DiffUtil.ItemCallback<SubConsiderations {

        @Override
        public boolean areItemsTheSame(@NonNull SubConsiderationsoldItem, @NonNull    SubConsiderations newItem) {
            return oldItem.getSubConsiderationsId ().equals(newItem.getSubConsiderationsId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull SubConsiderations oldItem, @NonNull    SubConsiderations newItem) {
            return oldItem.equals ( newItem );
        }
    }




}