package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.squareup.picasso.Picasso;

import java.util.List;

import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters.ViewHolders.GridItemViewHolder;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters.ViewHolders.UnifiedNativeAdViewHolder;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model.FamousPersonModel;
import saqib.com.mvpfullprojectsetup.R;

/**
 *
 */

public class FamousPersonCategoryAdapterAds extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // A menu item view type.
    private static final int TYPE_VIEW = 0;

    // The unified native ad view type.
    private static final int TYPE_AD = 1;

    private Context context;
    private List<Object> list;

    public FamousPersonCategoryAdapterAds(Context context, List<Object> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case TYPE_AD:
                View unifiedNativeLayoutView = LayoutInflater.from(
                        viewGroup.getContext()).inflate(R.layout.layout_ad_square_grid,
                        viewGroup, false);
                return new UnifiedNativeAdViewHolder(unifiedNativeLayoutView);
            case TYPE_VIEW:
                // Fall through.
            default:
                View menuItemLayoutView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.layout_cat_famous_person_adapter, viewGroup, false);
                return new GridItemViewHolder(menuItemLayoutView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int viewType = getItemViewType(i);

        switch (viewType) {
            case TYPE_AD:
                UnifiedNativeAd nativeAd = (UnifiedNativeAd) list.get(i);
                populateNativeAdView(nativeAd, ((UnifiedNativeAdViewHolder) viewHolder).getAdView());
                break;
            case TYPE_VIEW:
                // fall through
            default:
                GridItemViewHolder menuItemHolder = (GridItemViewHolder) viewHolder;
                FamousPersonModel menuItem = (FamousPersonModel) list.get(i);
                menuItemHolder.tvName.setText(menuItem.getName());
                Picasso.get()
                        .load(menuItem.getImage())
                        .fit()
                        .placeholder(R.drawable.ic_download)
                        .error(R.drawable.ic_download)
                        .into(menuItemHolder.imgImage);

        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {

        Object recyclerViewItem = list.get(position);
        if (recyclerViewItem instanceof UnifiedNativeAd) {
            return TYPE_AD;
        }
        return TYPE_VIEW;
    }

    private void populateNativeAdView(UnifiedNativeAd nativeAd,
                                      UnifiedNativeAdView adView) {

        ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        NativeAd.Image icon = nativeAd.getIcon();

        if (icon == null) {
            adView.getIconView().setVisibility(View.INVISIBLE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(icon.getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }



        /*// Some assets are guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        NativeAd.Image icon = nativeAd.getIcon();

        if (icon == null) {
            adView.getIconView().setVisibility(View.INVISIBLE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(icon.getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }*/

        // Assign native ad object to the native view.
        adView.setNativeAd(nativeAd);
    }

    public void addMore(List<FamousPersonModel> list){
        list.addAll(list);
    }
    public void notifyManually(){
        notifyDataSetChanged();
    }
}
