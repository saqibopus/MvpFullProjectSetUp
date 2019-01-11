package saqib.com.mvpfullprojectsetup.Modules.BatchList;

import java.util.List;

import saqib.com.mvpfullprojectsetup.BaseHelper.BaseView;
import saqib.com.mvpfullprojectsetup.Modules.BatchList.Model.BatchListModel;
/**
 *
 */

public class BatchListFragContract {

    interface View extends BaseView {
        void onDataLoaded(boolean status,String message,int maxCount, List<BatchListModel> model);
        void onMoreData(boolean status,String message,int maxCount, List<BatchListModel> model);
    }

    interface Presenter {
        void requestBatchList(int requestType);
    }
}
