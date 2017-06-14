package com.immranderson.flexyrecycleradapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class FlexHolder<T extends FlexState> extends RecyclerView.ViewHolder {


    public FlexHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(T t);

}