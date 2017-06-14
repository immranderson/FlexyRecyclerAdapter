package com.immranderson.flexyrecycleradapter;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class FlexState {

    /**
     * @return Unique integer identifier for RecyclerAdapter getItemViewType overridden method. Avoid using
     * instanceOf in lists of items since you'll notice a performance hit when it comes to scrolling due to
     * reflection.
     */
    public abstract int getType();

    /**
     * @return Viewholder layout resource Id
     */
    @LayoutRes
    public abstract int getViewHolderResId();

    /**
     * @return custom viewholder implementation which extends from FlexHolder
     */
    public abstract FlexHolder createViewHolder(ViewGroup parent);


    /**
     * This is a shortcut so you don't need to write that LayoutInflater.from(....) in every holder model.
     * @param parent
     * @return
     */
    protected View inflateFrom(ViewGroup parent) {

        return LayoutInflater.from(parent.getContext()).inflate(getViewHolderResId(), parent, false);

    }


}
