package appbar.com;


import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingParent;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class MyScroll extends RelativeLayout implements NestedScrollingParent, NestedScrollingChild {

    public MyScroll(Context context) {
        super(context);

    }

    public MyScroll(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MyScroll(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


}
