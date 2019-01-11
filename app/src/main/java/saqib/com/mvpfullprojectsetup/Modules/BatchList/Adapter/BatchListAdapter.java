package saqib.com.mvpfullprojectsetup.Modules.BatchList.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

import java.util.List;

import saqib.com.mvpfullprojectsetup.Modules.BatchList.Adapter.ViewHolders.AdViewHorizontalViewHolder;
import saqib.com.mvpfullprojectsetup.Modules.BatchList.Adapter.ViewHolders.BatchListViewHolder;
import saqib.com.mvpfullprojectsetup.R;

/**
 *
 */

public class BatchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_VIEW = 0;
    private static final int TYPE_AD = 1;


    private Context context;
    private List<Object> list;

    public BatchListAdapter(Context context, List<Object> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        switch (i) {
            case TYPE_AD:
                View adView = LayoutInflater.from(
                        viewGroup.getContext()).inflate(R.layout.layout_ad_horizontal,
                        viewGroup, false);
                return new AdViewHorizontalViewHolder(adView);
            case TYPE_VIEW:
                // Fall through.
            default:
                View batchView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.layout_batch_list_adapter, viewGroup, false);
                return new BatchListViewHolder(batchView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        Object recyclerViewItem = list.get(position);
        if (recyclerViewItem instanceof UnifiedNativeAd) {
            return TYPE_AD;
        }
        return TYPE_VIEW;
    }
}
