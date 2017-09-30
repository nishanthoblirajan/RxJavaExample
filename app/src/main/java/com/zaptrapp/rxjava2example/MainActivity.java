package com.zaptrapp.rxjava2example;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //creating a new observable
//        Observable<String> stringObservable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
//                e.onNext("Received String one");
//                e.onNext("Received String two");
//                e.onComplete();
//            }
//        });


        //creating the observer for the above observable
        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, "onNext: "+s);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");

            }
        };

        Observable.just("1","2","3").subscribeOn(Schedulers.newThread()).subscribe(stringObserver);
        Observable.just("5","6","7" +
                "").subscribeOn(Schedulers.newThread()).subscribe(stringObserver);


        //assign the observer to the observable
//        stringObservable.subscribe(stringObserver);


        //RxPermission example
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_CONTACTS)
                .subscribe(new );

    }

}
