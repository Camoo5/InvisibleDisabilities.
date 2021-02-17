
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

import com.tenacity.invisibledisabilities.data.Practitioner;
import com.tenacity.invisibledisabilities.databinding.FragmentPractitionerBinding;



public class PractitionerAdapter extends ListAdapter <Practitioner, PractitionerAdapter.ViewHolder> {

    public PractitionerAdapter() {
        super ( new PractitionerDiffCallback ());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder ( FragmentPractitionerBinding.inflate (
                LayoutInflater.from ( parent.getContext () ), parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Practitioner practitioner = getItem ( position );
        holder.bind ( createOnClickListener ( practitioner.getPractitionerId  () ), practitioner  );
        holder.itemView.setTag ( practitioner );
    }

    private View.OnClickListener createOnClickListener(String practitionerId) {
        return v -> Navigation.findNavController ( v ).navigate (
               PractitionerFragmentDirections.extensionToBlueBadgeFragmentToExtensionToCriteriaOneFragment  (practitionerId ) );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentPractitionerBinding binding;

        ViewHolder(@NonNull @NonNull FragmentPractitionerBinding binding) {
            super ( binding.getRoot () );
            this.binding = binding;
        }

        void bind(View.OnClickListener listener,  Practitioner item ) {
            binding.setClickListener(listener);
            binding.setExtensiontobluebadge ( item);
            binding.executePendingBindings();
        }
    }

    static class PractitionerDiffCallback extends DiffUtil.ItemCallback<Practitioner> {

        @Override
        public boolean areItemsTheSame(@NonNull Practitioner oldItem, @NonNull Practitioner newItem) {
            return oldItem.getPractitionerId  ().equals(newItem.getPractitionerId ());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Practitioner oldItem, @NonNull Practitioner newItem) {
            return oldItem == newItem;
        }
    }
}

