package presenter;

import com.hyphenate.chat.EMClient;

import view.SplashView;

/**
 * @ 包   名   :presenter
 * @ 类   名   :SplashPresenterImpl
 * @ 作   者   :seoryoo
 * @ 日   期   :2017/1/15 14:19
 * @ 描   述   :${TODO}
 */
public class SplashPresenterImpl implements SplashPresenter {

    private final SplashView mSplashView;

    public SplashPresenterImpl(SplashView splashView) {
        mSplashView = splashView;

    }

    @Override
    public void checkLogined() {
        if (EMClient.getInstance().isLoggedInBefore()&&EMClient.getInstance().isConnected()) {
            //已经登录
            mSplashView.checkedLogined(true);
        }else {
            //未登录
            mSplashView.checkedLogined(false);
        }
    }
}
