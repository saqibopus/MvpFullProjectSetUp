package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import saqib.com.mvpfullprojectsetup.Helpers.Logs;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model.FamousPersonalityCategory;
import saqib.com.mvpfullprojectsetup.R;


public class FamousPersonalityFrag extends Fragment {

    @BindView(R.id.bt_category)
    Button btCategory;
    private List<FamousPersonalityCategory> spinList = new ArrayList<>();
    private FilterSheetDilog filterSheetDilog;

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
        init();
        return view;
    }

    private void init() {
        spinList = getCateGory();
        filterSheetDilog =new FilterSheetDilog().newInstance();
        filterSheetDilog.show(getActivity().getSupportFragmentManager(),"Sheet");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private List<FamousPersonalityCategory> getCateGory() {
        List<FamousPersonalityCategory> data = new ArrayList<>();
        data.add(new FamousPersonalityCategory("one"));
        data.add(new FamousPersonalityCategory("two"));
        data.add(new FamousPersonalityCategory("three"));
        return data;
    }



    @OnClick(R.id.bt_category)
    void onButtonCategory(){
        filterSheetDilog.show(getActivity().getSupportFragmentManager(),"fadaljanbksak");


    }
}
