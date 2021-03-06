package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment;

import android.content.Context;
import android.os.Handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.functions.Consumer;
import io.reactivex.observers.DefaultObserver;
import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model.FamousPersonModel;
import saqib.com.mvpfullprojectsetup.Networking.BaseObervables;
import saqib.com.mvpfullprojectsetup.Networking.Network;


/**
 * Created by data.
 */

public class FamousPersonalityFragPresenter extends BaseObervables implements FamousPersonalityFragContract.Presenter {
    private Context context;
    private FamousPersonalityFragContract.View presenter;
    public static final int REQUEST_TYPE_FIRST=0;
    public static final int REQUEST_TYPE_MORE=1;
    public FamousPersonalityFragPresenter(Context context, FamousPersonalityFragContract.View presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public void requestList(int requestType) {
        presenter.showProgress(true);
        if(requestType == REQUEST_TYPE_FIRST){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (presenter != null) {
                        presenter.showProgress(false);
                        presenter.onDataLoaded(true,"Data Load Success",18,getCateGory());
                    }
                }
            }, 1500);
        }else if(requestType == REQUEST_TYPE_MORE){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (presenter != null) {
                        presenter.showProgress(false);
                        presenter.onMoreData(true,"Data Load Success",18,getMoreCateGory());
                    }
                }
            }, 2000);
        }else {

        }
        Map<String, String> map = new HashMap<>();
        callBatchList(map).subscribeWith(new DefaultObserver<String>() {
            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private List<FamousPersonModel> getCateGory() {
        List<FamousPersonModel> data = new ArrayList<>();
        data.add(new FamousPersonModel(true,123,"one","gigi","https://icon2.kisspng.com/20180204/vsw/kisspng-indian-independence-movement-khatkar-kalan-punjab-bhagat-singh-png-image-5a76b4369ea7c7.6893577515177288226499.jpg"));
        data.add(new FamousPersonModel(false,456,"two","gigi1","http://www.pngmart.com/files/4/Bhagat-Singh-PNG-Clipart.png"));
        data.add(new FamousPersonModel(false,123,"three","gigi2","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(false,123,"one","gigi","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(false,456,"two","gigi1","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(true,123,"three","gigi2","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(false,123,"one","gigi","https://icon2.kisspng.com/20180204/vsw/kisspng-indian-independence-movement-khatkar-kalan-punjab-bhagat-singh-png-image-5a76b4369ea7c7.6893577515177288226499.jpg"));
        data.add(new FamousPersonModel(false,456,"two","gigi1","http://www.pngmart.com/files/4/Bhagat-Singh-PNG-Clipart.png"));
        data.add(new FamousPersonModel(false,123,"one","gigi","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(false,456,"two","gigi1","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(false,123,"three","gigi2","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(false,456,"two","gigi1","http://www.pngmart.com/files/4/Bhagat-Singh-PNG-Clipart.png"));
        data.add(new FamousPersonModel(false,123,"one","gigi","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(false,456,"two","gigi1","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(true,123,"three","gigi2","http://www.queness.com/resources/images/png/apple_ex.png"));
        return data;
    }
    private List<FamousPersonModel> getMoreCateGory() {
        List<FamousPersonModel> data = new ArrayList<>();
        data.add(new FamousPersonModel(false,123,"one_more","gigi","https://icon2.kisspng.com/20180204/vsw/kisspng-indian-independence-movement-khatkar-kalan-punjab-bhagat-singh-png-image-5a76b4369ea7c7.6893577515177288226499.jpg"));
        data.add(new FamousPersonModel(false,456,"two_more","gigi1","http://www.pngmart.com/files/4/Bhagat-Singh-PNG-Clipart.png"));
        data.add(new FamousPersonModel(false,456,"three_more","gigi1","http://www.pngmart.com/files/4/Bhagat-Singh-PNG-Clipart.png"));
        return data;
    }

}
