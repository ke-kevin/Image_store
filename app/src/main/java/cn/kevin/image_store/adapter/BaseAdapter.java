package cn.kevin.image_store.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;

/**
 * 万能的Adapter，各自定义的Adapter都应该继承自本Adapter
 *
 * @param <T> 列表中显示的数据的类型
 */
public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
    /**
     * Context
     */
    private Context context;
    /**
     * 数据
     */
    private List<T> data;
    /**
     * LayoutInfalter
     */
    private LayoutInflater inflater;

    public BaseAdapter(Context context, List<T> data) {
        super();
        setContext(context);
        setData(data);
        inflater = LayoutInflater.from(context);
    }

    /**
     * 获取LayoutInflater对象
     *
     * @return LayoutInflater对象
     */
    protected final LayoutInflater getLayoutInflater() {
        return inflater;
    }

    /**
     * 设置Context
     *
     * @param context
     *            Context对象，该参数值不允许为null，否则将导致程序错误！
     */
    protected final void setContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("参数Context不允许为null！！！");
        }
        this.context = context;
    }

    /**
     * 设置数据
     *
     * @param data
     *            数据的集合
     */
    protected final void setData(List<T> data) {
        if (data == null) {
            data = new ArrayList<T>();
        }
        this.data = data;
    }

    /**
     * 获取Context对象
     *
     * @return Context对象
     */
    protected final Context getContext() {
        return context;
    }

    /**
     * 获取数据
     *
     * @return 数据的集合
     */
    protected final List<T> getData() {
        return data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
