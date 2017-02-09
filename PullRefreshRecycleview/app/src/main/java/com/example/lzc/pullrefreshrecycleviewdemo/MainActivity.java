package com.example.lzc.pullrefreshrecycleviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.lzc.pullrefreshrecycleviewdemo.adpater.RecyclerAdapter;
import com.example.lzc.pullrefreshrecycleviewdemo.view.pulltorefreshrecyclerview.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：PullToRefreshRecyclerviewDemo
 * 创建人：zz
 * 创建时间：2017/2/9 17:03
 */
public class MainActivity extends Activity {

    private PullToRefreshRecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        recyclerView = ((PullToRefreshRecyclerView) findViewById(R.id.recyclerview_id));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerAdapter(getData(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        recyclerView.setLoadingListener(new PullToRefreshRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setRefreshing(true);
    }

    /**
     * 模拟数据
     * @return
     */
    private List<String> getData() {
    List<String> datas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datas.add("测试" + i);
        }
        return datas;
    }
}
