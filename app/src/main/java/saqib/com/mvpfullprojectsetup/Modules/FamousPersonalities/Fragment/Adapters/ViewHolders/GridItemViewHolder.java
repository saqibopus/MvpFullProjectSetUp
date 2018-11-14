package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import saqib.com.mvpfullprojectsetup.R;

/**
 *
 */

public class GridItemViewHolder extends RecyclerView.ViewHolder {
    public TextView tvName;
    public ImageView imgImage;

    public GridItemViewHolder(View view) {
        super(view);
        tvName = (TextView) view.findViewById(R.id.tv_name);
        imgImage = (ImageView) view.findViewById(R.id.img_image);
    }
}
