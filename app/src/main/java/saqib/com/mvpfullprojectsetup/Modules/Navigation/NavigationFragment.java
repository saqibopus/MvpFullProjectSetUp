package saqib.com.mvpfullprojectsetup.Modules.Navigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import saqib.com.mvpfullprojectsetup.Helpers.Logs;
import saqib.com.mvpfullprojectsetup.Modules.Navigation.Contract.NavigationContract;
import saqib.com.mvpfullprojectsetup.R;


public class NavigationFragment extends Fragment implements View.OnClickListener{

   private OnNavigationItemClick onNavigationItemClick;

    private Map<Integer, LinearLayout> position;

    @BindView(R.id.navigation_view_home)
    LinearLayout navigationViewHome;
    @BindView(R.id.navigation_view_first)
    LinearLayout navigationViewFirst;
    public NavigationFragment() {
        // Required empty public constructor
    }


    public NavigationFragment setListner(OnNavigationItemClick onNavigationItemClick) {
        this.onNavigationItemClick=onNavigationItemClick;
        return this;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_navigation, container, false);
        ButterKnife.bind(this, view);
        navigationViewHome.setOnClickListener(this);
        navigationViewFirst.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addMapEntry();
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigation_view_home:
                onNavigationItemClick.onHomeClick();
                setSelected(R.id.navigation_view_home);
                return;
            case R.id.navigation_view_first:
                onNavigationItemClick.onFirstClick();
                setSelected(R.id.navigation_view_first);
                return;
                default:
        }
    }

    public interface OnNavigationItemClick {
        void onHomeClick();
        void onFirstClick();
    }

    /**
     * Comment by : Saqib Shaikh
     * This method iterate entries and set background color dynamically.
     **/
    private void setSelected(int requestCode) {
        Iterator<Map.Entry<Integer, LinearLayout>> iterator = position.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, LinearLayout> data = iterator.next();
            if (data.getKey() == requestCode) {
                data.getValue().setBackgroundColor(getActivity().getResources().getColor(R.color.col_orange_deep));
            } else {
                data.getValue().setBackgroundColor(getActivity().getResources().getColor(R.color.col_brown));
            }
        }
    }
    /**
     * Comment by : Saqib Shaikh
     * Update here is any new value in navigation field.
     * if any modification in old value update here
     * **/
    private void addMapEntry(){
        position = new HashMap<>();
        position.put(R.id.navigation_view_home,(LinearLayout) getView().findViewById(R.id.navigation_view_home));
        position.put(R.id.navigation_view_first,(LinearLayout) getView().findViewById(R.id.navigation_view_first));
    }
}
