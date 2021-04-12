package com.tenacity.invisibledisabilities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget. ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.data.CopingStrategy;
import com.tenacity.invisibledisabilities.databinding.FragmentCopingStrategyBinding;
import com.tenacity.invisibledisabilities.databinding.FragmentCopingStrategyListBinding;
import com.tenacity.invisibledisabilities.ui.gallery.CopingStrategyFragmentDirections;


public class CopingStrategy extends ListAdapter <CopingStrategy, CopingStrategyAdapter.ViewHolder> {

    public CopingStrategyAdapter() {
        super(new CopingStrategyDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( FragmentCopingStrategyListBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CopingStrategy copingStrategy = getItem(position);
        holder.bind(createOnClickListener(copingStrategy.getCopingstrategyId ()), copingStrategy);
        holder.itemView.setTag(copingStrategy);
    }

    private View.OnClickListener createOnClickListener(String copingstrategyId) {
        return v -> Navigation.findNavController(v).navigate(
                CopingStrategyFragmentDirections.actionCopingStrategyFragmentToPractitionersFragment (copingstrategyId));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentCopingStrategyListBinding binding;

        ViewHolder( @NonNull FragmentCopingStrategyListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, CopingStrategy item) {
            binding.setClickListener(listener);
            binding.setCopingStrategy(item);
            binding.executePendingBindings();
        }
    }

    static class CopingStrategyDiffCallback extends DiffUtil.ItemCallback<CopingStrategy> {

        @Override
        public boolean areItemsTheSame(@NonNull CopingStrategy oldItem, @NonNull CopingStrategy newItem) {
            return oldItem.getCopingstrategyId ().equals(newItem.getCopingstrategyId ());
        }

        @Override
        public boolean areContentsTheSame(@NonNull CopingStrategy oldItem, @NonNull CopingStrategy newItem) {
            return oldItem.equals ( newItem );
        }
    }
}
