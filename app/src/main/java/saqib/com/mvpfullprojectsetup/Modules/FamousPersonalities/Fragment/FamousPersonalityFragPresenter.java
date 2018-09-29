package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment;

import android.content.Context;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model.FamousPersonModel;


/**
 * Created by data.
 */

public class FamousPersonalityFragPresenter implements FamousPersonalityFragContract.Presenter {
    private Context context;
    private FamousPersonalityFragContract.View presenter;

    public FamousPersonalityFragPresenter(Context context, FamousPersonalityFragContract.View presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public void requestList() {
        presenter.showProgress(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (presenter != null) {
                    presenter.showProgress(false);
                    presenter.onDataLoaded(true,"Data Load Success",getCateGory());
                }
            }
        }, 1500);
    }

    private List<FamousPersonModel> getCateGory() {
        List<FamousPersonModel> data = new ArrayList<>();
        data.add(new FamousPersonModel(123,"one","gigi","https://icon2.kisspng.com/20180204/vsw/kisspng-indian-independence-movement-khatkar-kalan-punjab-bhagat-singh-png-image-5a76b4369ea7c7.6893577515177288226499.jpg"));
        data.add(new FamousPersonModel(456,"two","gigi1","http://www.pngmart.com/files/4/Bhagat-Singh-PNG-Clipart.png"));
        data.add(new FamousPersonModel(123,"three","gigi2","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(123,"one","gigi","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(456,"two","gigi1","http://www.queness.com/resources/images/png/apple_ex.png"));
        data.add(new FamousPersonModel(123,"three","gigi2","http://www.queness.com/resources/images/png/apple_ex.png"));
        return data;
    }
}
