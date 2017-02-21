package appbar.com;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

public class TitleBarAlphaBehavior extends CoordinatorLayout.Behavior<View> {


    private int dy;

    /**
     * 带参构造必须重载
     * 在CoordinatorLayout里利用反射去获取这个Behavior的时候就是拿的这个构造
     */
    public TitleBarAlphaBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 表示是否给应用了Behavior 的View 指定一个依赖的布局
     *
     * @param parent
     * @param child      绑定behavior 的View
     * @param dependency 依赖的view
     * @return 如果child 是依赖的指定的View 返回true,否则返回false
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return true;
    }

    /**
     * 当被依赖的View 状态（如：位置、大小）发生变化时，这个方法被调用
     *
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float scaleY = Math.abs(dependency.getY()) / dependency.getHeight();
        child.setTranslationY(child.getHeight() * scaleY);

        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        this.dy = dy;
        // System.out.println("alpha=======y====" + dy);//上滑 大于0，下滑 小于0
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    /**
     * 进行嵌套滚动时被调用
     * 数字代表alpha 0为完全透明 0-255表示0-100的透明度 255表示完全不透明
     *
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dxConsumed        target 已经消费的x方向的距离
     * @param dyConsumed        target 已经消费的y方向的距离
     * @param dxUnconsumed      x 方向剩下的滚动距离
     * @param dyUnconsumed      y 方向剩下的滚动距离
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        int offset = child.getContext().getResources().getDimensionPixelOffset(R.dimen.header_height); // 45dp 180

        int scrollY = child.getScrollY(); // 上滑变大，下滑变小，下滑不动值为0

        View iv1 = child.findViewById(R.id.iv1);
        int width = iv1.getWidth();// 45dp 180

        // System.out.println("alpha=======y====" + scrollY);

        //=================
        //int titleWidth = target.findViewById(R.id.title_layout).getWidth();


        //System.out.println("alpha=======simpleName====" + simpleName);//CoordinatorLayout

        View title = coordinatorLayout.findViewById(R.id.title_layout);

        System.out.println("alpha=======title====" + title.getHeight());

        if (scrollY > 0 && scrollY < 720 && dy > 0) {// 上滑 透明度逐渐为255
            // System.out.println("alpha===========上滑 透明度逐渐为255");
            int value = 720 / scrollY;
            title.getBackground().setAlpha(value);

        } else if (dy < 0 && scrollY > 0 && scrollY < 720) {//下滑 透明度逐渐为0
            // System.out.println("alpha===========下滑 透明度逐渐为0");
            int value = 720 / scrollY;
            title.getBackground().setAlpha(value);
        }

    }


    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {

        return false;
    }
}
