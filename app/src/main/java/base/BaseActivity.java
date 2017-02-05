package base;

import android.app.Activity;
import android.content.Intent;

/**
 * @ 包   名   :base
 * @ 类   名   :BaseActivity
 * @ 作   者   :seoryoo
 * @ 日   期   :2017/1/16 13:24
 * @ 描   述   :${TODO}
 */
public class BaseActivity extends Activity {
    /**
     * 开启一个Activity
     * @param clazz
     * @param isFinish
     */
    public void startActivity(Class clazz, boolean isFinish) {
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
        if (isFinish) {
            finish();
        }
    }
}
