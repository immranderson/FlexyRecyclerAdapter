package com.immranderson.flexyrecycleradapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T extends BaseHolderModel> extends RecyclerView.ViewHolder {


    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(T t);

}