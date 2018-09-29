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
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import saqib.com.mvpfullprojectsetup.Helpers.Logs;
import saqib.com.mvpfullprojectsetup.Helpers.ProgressHelper;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters.FamousPersonCategoryAdapter;

import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model.FamousPersonModel;
import saqib.com.mvpfullprojectsetup.R;


public class FamousPersonalityFrag extends Fragment implements FamousPersonalityFragContract.View{

    @BindView(R.id.bt_category)
    Button btCategory;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<FamousPersonModel> spinList ;
    private FilterSheetDilog filterSheetDilog;
    private FamousPersonalityFragPresenter presenter;

    private FamousPersonCategoryAdapter adapter;
    private List<FamousPersonModel> list;
    private ProgressHelper progressHelper;
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
    }
    private void initClasses(){
        progressHelper = ProgressHelper.getInstance().initProgressDilog(getActivity());

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
       // recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(5), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        filterSheetDilog =new FilterSheetDilog().newInstance();
        filterSheetDilog.setCancelable(false);
        filterSheetDilog.show(getActivity().getSupportFragmentManager(),"Sheet");


    }
    private void beginRequest(){
        presenter = new FamousPersonalityFragPresenter(getActivity(),this);
        presenter.requestList();
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
    void onButtonCategory(){
        filterSheetDilog.show(getActivity().getSupportFragmentManager(),"fadaljanbksak");
    }


    @Override
    public void showToast() {

    }

    @Override
    public void showProgress(boolean status) {
        if (status)
            progressHelper.show("Loading");
        else
            progressHelper.dissmiss();
    }

    @Override
    public void onDataLoaded(boolean status, String message, List<FamousPersonModel> model) {
        if(!status){
            Logs.tS(getActivity(),message);
            return;
        }
        adapter = new FamousPersonCategoryAdapter(getActivity(),model);
        recyclerView.setAdapter(adapter);

        //list = model;
        //adapter.addMore(list);
        //adapter.notifyDataSetChanged();
        adapter.notifyManually();
        Logs.p("sie : "+list.size());
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
