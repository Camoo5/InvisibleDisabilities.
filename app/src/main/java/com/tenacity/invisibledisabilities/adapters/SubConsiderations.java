
package com.tenacity.invisibledisabilities.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tenacity.invisibledisabilities.data.Practitioner;
import com.tenacity.invisibledisabilities.data.SubConsiderations;
import com.tenacity.invisibledisabilities.databinding.FragmentPractitionerBinding;
import com.tenacity.invisibledisabilities.databinding.FragmentSubConsiderationsBinding;
import com.tenacity.invisibledisabilities.ui.gallery.SubConsiderationsFragmentDirections;


public class SubConsiderationsAdapter extends ListAdapter <SubConsiderations, SubConsiderationsAdapter.ViewHolder> {

    public SubConsiderationsAdapter() {
        super ( new SubConsiderationsDiffCallback ());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder ( FragmentSubConsiderationsBinding.inflate (
                LayoutInflater.from ( parent.getContext () ), parent, false ) );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubConsiderations subConsiderations= getItem ( position );
        holder.bind ( createOnClickListener ( SubConsiderations.getSubConsiderationsId  () ), subConsiderations  );
        holder.itemView.setTag ( subConsiderations );
    }

    private View.OnClickListener createOnClickListener(String practitionersId) {
        return v -> Navigation.findNavController ( v ).navigate (
                SubConsiderationsFragmentDirections.subConsiderationsFragmentToSupportingEvidenceFragment   (practitionersId ) );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final FragmentPractitionerBinding binding;

        ViewHolder(@NonNull @NonNull @NonNull FragmentSubConsiderationsBinding binding) {
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
            return oldItem.getPractitionersId  ().equals(newItem.getPractitionersId ());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Practitioner oldItem, @NonNull Practitioner newItem) {
            return oldItem == newItem;
        }
    }
}


