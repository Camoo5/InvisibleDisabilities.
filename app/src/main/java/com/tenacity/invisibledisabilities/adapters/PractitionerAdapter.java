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
import com.tenacity.invisibledisabilities.data.Practitioner;
import com.tenacity.invisibledisabilities.databinding.ListItemCopingStrategyBinding;
import com.tenacity.invisibledisabilities.databinding.ListItemPractitionerBinding;

public class PractitionerAdapter extends ListAdapter <Practitioner, PractitionerAdapter.ViewHolder> {

    public PractitionerAdapter() {
        super(new PractitionerDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder( ListItemPractitionerBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Practitioner practitioner = getItem(position);
        holder.bind(createOnClickListener(practitioner.getPractitionerId ()), practitioner );
        holder.itemView.setTag(practitioner);
    }

    private View.OnClickListener createOnClickListener(String practitionerId) {
        return v -> Navigation.findNavController(v).navigate(
                PractitionerFragmentDirections.actionDisabilityListFragmentToDisabilitytDetailFragment(practitionerId));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemCopingStrategyBinding binding;

        ViewHolder(@NonNull ListItemPractitionerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(View.OnClickListener listener, Practitioner item) {
            binding.setClickListener(listener);
            binding.setPractitioner(item);
            binding.executePendingBindings();
        }
    }

    static class PractitionerDiffCallback extends DiffUtil.ItemCallback<Practitioner{

        @Override
        public boolean areItemsTheSame(@NonNull Practitioner oldItem, @NonNull    Practitioner newItem) {
            return oldItem.getPractitionerId ().equals(newItem.getPractitionerId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull CopingStrategy oldItem, @NonNull    Practitioner newItem) {
            return oldItem.equals ( newItem );
        }
    }




}