package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment;


import java.util.List;

import saqib.com.mvpfullprojectsetup.BaseHelper.BaseView;

import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model.FamousPersonModel;

public class FamousPersonalityFragContract {

    interface View extends BaseView {
        void onDataLoaded(boolean status,String message, List<FamousPersonModel> model);
    }

    interface Presenter {
        void requestList();
    }
}
