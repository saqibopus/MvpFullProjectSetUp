package saqib.com.mvpfullprojectsetup.Modules.BatchList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.MobileAds;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import saqib.com.mvpfullprojectsetup.Helpers.ProgressHelper;
import saqib.com.mvpfullprojectsetup.Modules.BatchList.Model.BatchListModel;
import saqib.com.mvpfullprojectsetup.R;

public class BatchListFragment extends Fragment implements BatchListFragContract.View {

    @BindView(R.id.bt_category)
    Button btCategory;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ProgressHelper progressHelper;

    public BatchListFragment() {
    }

    public static BatchListFragment newInstance() {
        BatchListFragment fragment = new BatchListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_batch_list, container, false);
        ButterKnife.bind(this, view);
        initView();
        initClasses();
        return view;
    }

    private void initView() {
        MobileAds.initialize(getActivity(), "ca-app-pub-3940256099942544~3347511713");
    }

    private void initClasses() {
        progressHelper = ProgressHelper.getInstance().initProgressDilog(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showProgress(boolean status) {
        if (status)
            progressHelper.show("Loading");
        else
            progressHelper.dissmiss();
    }

    @Override
    public void onDataLoaded(boolean status, String message, int maxCount, List<BatchListModel> model) {

    }

    @Override
    public void onMoreData(boolean status, String message, int maxCount, List<BatchListModel> model) {

    }
}
