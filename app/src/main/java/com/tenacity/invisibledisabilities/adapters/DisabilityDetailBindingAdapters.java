package com.tenacity.invisibledisabilities.adapters;


import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.text.HtmlCompat;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class   DisabilityDetailBindingAdapters {
    @BindingAdapter("imageFromUrl")
    public static void bindImageFromUrl(ImageView view, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .transition( DrawableTransitionOptions.withCrossFade())
                    .into(view);
        }
    }

    @BindingAdapter("isGone")
    public static void bindIsGone(FloatingActionButton view, boolean isGone) {
        if (isGone) {
            view.hide();
        } else {
            view.show();
        }
    }

    @BindingAdapter("renderHtml")
    public static void bindReaderHtml(TextView view, String description) {
        if (description == null) {
            view.setText("");
        } else {
            view.setText( HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT));
            view.setMovementMethod( LinkMovementMethod.getInstance());
        }
    }


}