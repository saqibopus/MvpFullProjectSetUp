package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;

import saqib.com.mvpfullprojectsetup.R;

/**
 *
 */

public class UnifiedNativeAdViewHolder extends RecyclerView.ViewHolder {

    private UnifiedNativeAdView adView;

    public UnifiedNativeAdView getAdView() {
        return adView;
    }

    public UnifiedNativeAdViewHolder(View view) {
        super(view);
        adView = (UnifiedNativeAdView) view.findViewById(R.id.ad_view);

        // The MediaView will display a video asset if one is present in the ad, and the
        // first image asset otherwise.
        //adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));

        // Register the view used for each individual asset.
        //adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        //adView.setBodyView(adView.findViewById(R.id.ad_body));
        //adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        //adView.setIconView(adView.findViewById(R.id.ad_icon));
        //adView.setPriceView(adView.findViewById(R.id.ad_price));
        //adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        //adView.setStoreView(adView.findViewById(R.id.ad_store));
        //adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        adView.setCallToActionView(adView.findViewById(R.id.ad_action));
        adView.setIconView(adView.findViewById(R.id.ad_image));
    }
}
