package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import saqib.com.mvpfullprojectsetup.Helpers.Logs;
import saqib.com.mvpfullprojectsetup.Helpers.ProgressHelper;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters.FamousPersonCategoryAdapter;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters.FamousPersonCategoryAdapterAds;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model.FamousPersonModel;
import saqib.com.mvpfullprojectsetup.R;


public class FamousPersonalityFrag extends Fragment implements FamousPersonalityFragContract.View {

    @BindView(R.id.bt_category)
    Button btCategory;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private GridLayoutManager mLayoutManager;
    private List<FamousPersonModel> spinList;
    private FilterSheetDilog filterSheetDilog;
    private FamousPersonalityFragPresenter presenter;
    private FamousPersonCategoryAdapter adapter;
    private FamousPersonCategoryAdapterAds adapterAds;
    private List<Object> list;
    private ProgressHelper progressHelper;

    private int maxCount = 0;
    private boolean isLoading = false;
    int req = 0;
    public static final int NUMBER_OF_ADS = 5;
    private AdLoader adLoader;
    private List<UnifiedNativeAd> mNativeAds = new ArrayList<>();

    public FamousPersonalityFrag() {

    }

    public static FamousPersonalityFrag newInstance() {
        return new FamousPersonalityFrag();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_famous_personality, container, false);
        ButterKnife.bind(this, view);
        initView();
        initClasses();
        return view;
    }

    private void initView() {
        spinList = new ArrayList<>();
        list = new ArrayList<>();
        MobileAds.initialize(getActivity(), "ca-app-pub-3940256099942544~3347511713");
    }

    private void initClasses() {
        progressHelper = ProgressHelper.getInstance().initProgressDilog(getActivity());
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        // recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(5), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener);
        filterSheetDilog = new FilterSheetDilog().newInstance();
        filterSheetDilog.setCancelable(true);
        // filterSheetDilog.show(getActivity().getSupportFragmentManager(),"Sheet");
    }

    private void beginRequest() {
        presenter = new FamousPersonalityFragPresenter(getActivity(), this);
        presenter.requestList(FamousPersonalityFragPresenter.REQUEST_TYPE_FIRST);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        beginRequest();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @OnClick(R.id.bt_category)
    void onButtonCategory() {
        filterSheetDilog.show(getActivity().getSupportFragmentManager(), "Demo");
    }

    @Override
    public void showProgress(boolean status) {
        if (status)
            progressHelper.show("Loading");
        else
            progressHelper.dissmiss();
    }

    @Override
    public void onDataLoaded(boolean status, String message, int maxCount, List<FamousPersonModel> model) {
        if (!status) {
            Logs.tS(getActivity(), message);
            return;
        }
        this.maxCount = maxCount;
        list.addAll(model);
        Logs.p("onDataLoaded :"+ list.size());
        //adapter = new FamousPersonCategoryAdapter(getActivity(), list);
        //recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        adapterAds = new FamousPersonCategoryAdapterAds(getActivity(),list);
        recyclerView.setAdapter(adapterAds);
        adapterAds.notifyDataSetChanged();
        //loadNativeAds();
        adapterAds.notifyDataSetChanged();
    }

    @Override
    public void onMoreData(boolean status, String message, int maxCount, List<FamousPersonModel> model) {
        if (!status) {
            Logs.tS(getActivity(), message);
            return;
        }
        this.maxCount = maxCount;
        Logs.p("onMoreData :"+ list.size());
        list.addAll(model);
        //adapter.notifyDataSetChanged();
        adapterAds.notifyDataSetChanged();
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mLayoutManager.getChildCount();
            int totalItemCount = mLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

            Logs.p("visibleItemCount : " + mLayoutManager.getChildCount());
            Logs.p("totalItemCount : " + mLayoutManager.getItemCount());
            Logs.p("firstVisibleItemPosition : " + mLayoutManager.findFirstVisibleItemPosition());
            Logs.p("maxCount : " + maxCount);

            if (!isLoading) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0) {
                    Logs.p("req : "+req);
                    req++;
                    if(maxCount > totalItemCount){
                        presenter.requestList(FamousPersonalityFragPresenter.REQUEST_TYPE_MORE);
                    }

                }
            }
        }
    };
    private void loadNativeAds() {

        AdLoader.Builder builder = new AdLoader.Builder(getActivity(), "ca-app-pub-3940256099942544/2247696110");
        adLoader = builder.forUnifiedNativeAd(
                new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        Logs.p("onUnifiedNativeAdLoaded");
                        // A native ad loaded successfully, check if the ad loader has finished loading
                        // and if so, insert the ads into the list.
                        mNativeAds.add(unifiedNativeAd);
                        if (!adLoader.isLoading()) {
                            insertAdsInMenuItems();
                        }
                    }
                }).withAdListener(
                new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Logs.p("onAdFailedToLoad : error code : "+errorCode);
                        // A native ad failed to load, check if the ad loader has finished loading
                        // and if so, insert the ads into the list.
                        Logs.p("MainActivity"+ "The previous native ad failed to load. Attempting to"
                                + " load another.");
                        if (!adLoader.isLoading()) {
                            insertAdsInMenuItems();
                        }
                    }
                }).build();

        // Load the Native ads.
        adLoader.loadAds(new AdRequest.Builder().build(), NUMBER_OF_ADS);
    }
    private void insertAdsInMenuItems() {
        if (mNativeAds.size() <= 0) {
            return;
        }
        Logs.p("onAdFailedToLoad : insertAdsInMenuItems : mNativeAds size: "+mNativeAds.size());
        int offset = (list.size() / mNativeAds.size()) + 1;
        int index = 0;
        for (UnifiedNativeAd ad : mNativeAds) {
            list.add(index, ad);
            index = index + offset;
        }
    }

}
