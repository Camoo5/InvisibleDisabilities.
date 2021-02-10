package com.tenacity.invisibledisabilities.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.data.CopingStrategy;
import com.tenacity.invisibledisabilities.databinding.FragmentCopingStrategyBinding;
import com.tenacity.invisibledisabilities.ui.gallery.CopingStrategyFragmentDirections;




public class CopingStrategyAdapter extends ListAdapter <CopingStrategy, CopingStrategyAdapter.ViewHolder> {

    public CopingStrategyAdapter() {
        super(new CopingStrategyDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( FragmentCopingStrategyBinding .inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CopingStrategy copingStrategy = getItem(position);
        holder.bind(createOnClickListener(copingStrategy.getCopingStrategy()), copingStrategy);
        holder.itemView.setTag(copingStrategy);
    }

    private View.OnClickListener createOnClickListener(String disabilityId) {
        return v -> Navigation.findNavController(v).navigate(
                CopingStrategyFragmentDirections.copingStrategyFragmentToPractitionersFragment (disabilityId));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentCopingStrategyBinding binding;

        ViewHolder(@NonNull @NonNull FragmentCopingStrategyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, CopingStrategy item) {
            binding.setClickListener(listener);
            binding.setCopingStragtegy(item);
            binding.executePendingBindings();
        }
    }

    static class CopingStrategyDiffCallback extends DiffUtil.ItemCallback<CopingStrategy> {

        @Override
        public boolean areItemsTheSame(@NonNull CopingStrategy oldItem, @NonNull CopingStrategy newItem) {
            return oldItem.getCopingStrategyId().equals(newItem.getCopingStrategyId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull CopingStrategy oldItem, @NonNull CopingStrategy newItem) {
            return oldItem == newItem;
        }
    }
}