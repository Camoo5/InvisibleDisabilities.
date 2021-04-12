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
import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.databinding.ListItemCopingStrategyBinding;
import com.tenacity.invisibledisabilities.databinding.ListItemDisabilityBinding;




public class CopingStrategyAdapter extends ListAdapter <CopingStrategy, CopingStrategyAdapter.ViewHolder> {

    public CopingStrategyAdapter() {
        super(new CopingStrategyDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( ListItemCopingStrategyBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CopingStrategy copingStrategy = getItem(position);
        holder.bind(createOnClickListener(copingStrategy.getCopingStrategyId()), copingStrategy);
        holder.itemView.setTag(copingStrategy);
    }

    private View.OnClickListener createOnClickListener(String disabilityId) {
        return v -> Navigation.findNavController(v).navigate(
                CopingStrategyListFragmentDirections.actionCopingStrategyListFragmentToDisabilityDetailFragment(disabilityId));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemDisabilityBinding binding;

        ViewHolder(@NonNull ListItemCopingStrategyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, CopingStrategy item) {
            binding.setClickListener(listener);
            binding.setCopingStrategy(item);
            binding.executePendingBindings();
        }
    }

    static class DisabilityDiffCallback extends DiffUtil.ItemCallback<Disability> {

        @Override
        public boolean areItemsTheSame(@NonNull Disability oldItem, @NonNull Disability newItem) {
            return oldItem.getDisabilityId().equals(newItem.getDisabilityId());
        }


        @Override
        public boolean areContentsTheSame(@NonNull Disability oldItem, @NonNull Disability newItem) {
            return oldItem.equals ( newItem );
        }
    }
}
