package com.tenacity.invisibledisabilities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.data.SubConsiderations;
import com.tenacity.invisibledisabilities.databinding.FragmentSubConsiderationsBinding;


public class SubConsiderationsAdapter extends ListAdapter<SubConsiderations, SubConsiderationsAdapter.ViewHolder> {

    public SubConsiderationsAdapter() {
        super(new SubConsiderationsDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( FragmentSubConsiderationsBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubConsiderations subconsiderations = getItem(position);
        holder.bind(createOnClickListener(subconsiderations.getSubConsiderationsId()), subconsiderations);
        holder.itemView.setTag(subconsiderations);
    }

    private View.OnClickListener createOnClickListener(String subconsiderationsId) {
        return v -> Navigation.findNavController(v).navigate(
                SubConsiderationsFragmentDirections.actionPlantListFragmentToPlantDetailFragment(subconsiderationsId));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private FragmentSubConsiderationsBinding binding;

        ViewHolder(@NonNull FragmentSubConsiderationsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, SubConsiderations item) {
            binding.setClickListener(listener);
            binding.setSubconsiderations  (item);
            binding.executePendingBindings();
        }
    }

    static class SubConsiderationsDiffCallback extends DiffUtil.ItemCallback<SubConsiderations> {

        @Override
        public boolean areItemsTheSame(@NonNull SubConsiderations oldItem, @NonNull SubConsiderations newItem) {
            return oldItem.getSubConsiderationsId().equals(newItem.getSubConsiderationsId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull SubConsiderations oldItem, @NonNull SubConsiderations newItem) {
            return oldItem == newItem;
        }
    }
}


