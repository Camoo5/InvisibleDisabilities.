
package com.tenacity.invisibledisabilities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.data.ExtensionToBlueBadge;
import com.tenacity.invisibledisabilities.databinding.FragmentExtensionToBlueBadgeBinding;
import com.tenacity.invisibledisabilities.ui.gallery.ExtensionToBlueBadgeFragmentDirections;


public class ExtensionToBlueBadgeAdapter extends ListAdapter <ExtensionToBlueBadge, ExtensionToBlueBadgeAdapter.ViewHolder> {

    public ExtensionToBlueBadgeAdapter() {
        super ( new ExtensionToBlueBadgeDiffCallback ());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder ( FragmentExtensionToBlueBadgeBinding.inflate (
                LayoutInflater.from ( parent.getContext () ), parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      ExtensionToBlueBadge extensionToBlueBadge = getItem ( position );
        holder.bind ( createOnClickListener ( extensionToBlueBadge.getExtensiontobluebadgeId () ), extensionToBlueBadge );
        holder.itemView.setTag ( extensionToBlueBadge);
    }

    private View.OnClickListener createOnClickListener(String extensiontobluebadgeId) {
        return v -> Navigation.findNavController ( v ).navigate (
                ExtensionToBlueBadgeFragmentDirections.extensionToBlueBadgeFragmentToExtensionToCriteriaOneFragment  (extensiontobluebadgeId ) );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentExtensionToBlueBadgeBinding binding;

        ViewHolder(@NonNull FragmentExtensionToBlueBadgeBinding binding) {
            super ( binding.getRoot () );
            this.binding = binding;
        }

        void bind(View.OnClickListener listener,  ExtensionToBlueBadge item ) {
            binding.setClickListener(listener);
            binding.setExtensiontobluebadge ( item);
            binding.executePendingBindings();
        }
    }

    static class ExtensionToBlueBadgeDiffCallback extends DiffUtil.ItemCallback<ExtensionToBlueBadge> {

        @Override
        public boolean areItemsTheSame(@NonNull ExtensionToBlueBadge oldItem, @NonNull ExtensionToBlueBadge newItem) {
            return oldItem.getExtensiontobluebadgeId ().equals(newItem.getExtensiontobluebadgeId ());
        }


        @Override
        public boolean areContentsTheSame(@NonNull ExtensionToBlueBadge oldItem, @NonNull ExtensionToBlueBadge newItem) {
            return oldItem.equals ( newItem );
        }
    }
}

