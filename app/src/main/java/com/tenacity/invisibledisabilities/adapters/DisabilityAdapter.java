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

import com.tenacity.invisibledisabilities.data.Disability;
import com.tenacity.invisibledisabilities.databinding.ListItemDisabilityBinding;
import com.tenacity.invisibledisabilities.ui.gallery.DisabilityListFragmentDirections;




public class DisabilityAdapter extends ListAdapter <Disability, DisabilityAdapter.ViewHolder> {

    public DisabilityAdapter() {
        super(new DisabilityDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( ListItemDisabilityBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Disability disability = getItem(position);
        holder.bind(createOnClickListener(disability.getDisabilityId()), disability);
        holder.itemView.setTag(disability);
    }

    private View.OnClickListener createOnClickListener(String disabilityId) {
        return v -> Navigation.findNavController(v).navigate(
                DisabilityListFragmentDirections.actionDisabilityListFragmentToDisabilityDetailFragment(disabilityId));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemDisabilityBinding binding;

        ViewHolder(@NonNull ListItemDisabilityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, Disability item) {
            binding.setClickListener(listener);
            binding.setDisability(item);
            binding.executePendingBindings();
        }
    }

    static class DisabilityDiffCallback extends DiffUtil.ItemCallback<Disability> {

        @Override
        public boolean areItemsTheSame(@NonNull Disability oldItem, @NonNull Disability newItem) {
            return oldItem.getDisabilityId().equals(newItem.getDisabilityId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Disability oldItem, @NonNull Disability newItem) {
            return oldItem == newItem;
        }
    }
}