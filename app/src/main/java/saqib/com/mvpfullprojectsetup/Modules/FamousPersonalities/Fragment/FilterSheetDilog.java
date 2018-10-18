package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import saqib.com.mvpfullprojectsetup.Helpers.ProgressHelper;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Adapters.CategoryAdapterSpin;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model.CategoryModel;
import saqib.com.mvpfullprojectsetup.R;


public class FilterSheetDilog extends BottomSheetDialogFragment {

    public FilterSheetDilog() {
        // Required empty public constructor
    }

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private CategoryAdapterSpin adapterSpin;

    public static FilterSheetDilog newInstance() {
        return new FilterSheetDilog();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_sheet_dilog, container, false);
        ButterKnife.bind(this, view);
        initClasses();
        return view;
    }


    private void initClasses(){
        adapterSpin = new CategoryAdapterSpin(getActivity(),getCategoryList());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterSpin);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
    private List<CategoryModel> getCategoryList(){
        List<CategoryModel> data = new ArrayList<>();
        for(int i=0;i<10;i++){
            CategoryModel model = new CategoryModel(i,"Sahitya");
            data.add(model);
        }
        return data;
    }

    public interface FilterSheet{
        void onFiler();
    }

}
