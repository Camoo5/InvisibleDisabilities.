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
import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadge;
import com.tenacity.invisibledisabilities.databinding.ListItemCopingStrategyBinding;

public class ExtensionToBlueBadgeAdapter extends ListAdapter <ExtensionToBlueBadge, ExtensionToBlueBadgeAdapter.ViewHolder> {

    public ExtensionToBlueBadgeAdapter() {
        super ( new ExtensionToBlueBadgeyDiffCallback () );
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder ( ListItemExtensionToBlueBadgeBinding.inflate (
                LayoutInflater.from ( parent.getContext () ), parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExtensionToBlueBadge extensionToBlueBadge = getItem ( position );
        holder.bind ( createOnClickListener ( extensionToBlueBadge.getExtensiontobluebadgeId () ), extensionToBlueBadge );
        holder.itemView.setTag ( extensionToBlueBadge );
    }

    private View.OnClickListener createOnClickListener(String extensionToBlueBadgeId) {
        return v -> Navigation.findNavController ( v ).navigate (
                ExtensionToBlueBadgeFragmentDirections.actionDisabilityListFragmentToDisabilitytDetailFragment ( extensionToBlueBadgeId ) );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemExtensionToBlueBadgeBinding binding;

        ViewHolder(@NonNull ListItemExtensionToBlueBadgeBinding binding) {
            super ( binding.getRoot () );
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, CopingStrategy item) {
            binding.setClickListener ( listener );
            binding.setExtensionToBlueBadge ( item );
            binding.executePendingBindings ();
        }
    }

    static class ExtensionToBlueBadgeDiffCallback extends DiffUtil.ItemCallback <ExtensionToBlueBadge {

        @Override
        public boolean areItemsTheSame(@NonNull ExtensionToBlueBadge oldItem, @NonNull ExtensionToBlueBadge newItem) {
            return oldItem.getExtensionToBlueBadgeId ().equals ( newItem.getExtensionToBlueBadgeId () );
        }

        @Override
        public boolean areContentsTheSame(@NonNull ExtensionToBlueBadge oldItem, @NonNull ExtensionToBlueBadge newItem) {
            return oldItem.equals ( newItem );
        }
    }

}




