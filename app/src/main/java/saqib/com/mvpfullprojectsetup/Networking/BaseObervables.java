package saqib.com.mvpfullprojectsetup.Networking;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */

public class BaseObervables {

    public Observable<String> callBatchList(Map<String, String> map) {
        return Network.setupRetrofit(null)
                .callBatchList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
