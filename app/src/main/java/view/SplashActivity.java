package view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import com.lemon.seoryoo.qq.MainActivity;
import com.lemon.seoryoo.qq.R;

import base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import presenter.SplashPresenter;
import presenter.SplashPresenterImpl;

public class SplashActivity extends BaseActivity implements SplashView {

    @Bind(R.id.splash)
    ImageView mSplash;
    private SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mSplashPresenter = new SplashPresenterImpl(this);
        //判断是否登录
        mSplashPresenter.checkLogined();
    }

    /**
     * 是否登录
     *
     * @param isLogined
     */
    @Override
    public void checkedLogined(boolean isLogined) {
        if (isLogined) {
            //已经登录,跳转到主页
            startActivity(MainActivity.class, true);
        } else {
            //未登录,跳转到登录界面
            ObjectAnimator alpha = ObjectAnimator.ofFloat(mSplash, "alpha", 0, 1).setDuration(2000);
            alpha.start();
            alpha.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    //动画结束的回调
                    startActivity(LoginActivity.class, true);
                }
            });
        }
    }
}
