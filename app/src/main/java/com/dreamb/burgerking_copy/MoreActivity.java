package com.dreamb.burgerking_copy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamb.burgerking_copy.ExpandableListAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MoreActivity extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;


    private String mParam1;
    private String mParam2;

    public MoreActivity() {
        // Required empty public constructor
    }

    public static MoreActivity newInstance(String param1, String param2) {
        MoreActivity fragment = new MoreActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_more_activity, container, false);
        View sv = view.findViewById(R.id.horscrollview);

        recyclerView = view.findViewById(R.id.more_recyclerview);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        List<ExpandableListAdapter.Item> data = new ArrayList<>();

        ExpandableListAdapter.Item event = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "이벤트");
        data.add(event);
        event.invisibleChildren = new ArrayList<>();
        event.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "이벤트"));
        event.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "신규매장"));

        ExpandableListAdapter.Item introduce = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "매장소개");
        data.add(introduce);
        introduce.invisibleChildren = new ArrayList<>();
        introduce.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "가까운 매장"));
        introduce.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "지역 검색"));
        introduce.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "매장명 검색"));

        ExpandableListAdapter.Item menu = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "메뉴소개");
        data.add(menu);
        menu.invisibleChildren = new ArrayList<>();
        menu.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "추천메뉴"));
        menu.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "오리지널&맥시멈"));
        menu.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "프리미엄"));
        menu.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "와퍼&주니어"));
        menu.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "치킨&슈림프버거"));
        menu.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "올데이킹&킹모닝"));
        menu.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "사이드"));
        menu.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "음료&디저트"));

        ExpandableListAdapter.Item verylong = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "약관 및 정책");
        data.add(verylong);
        verylong.invisibleChildren = new ArrayList<>();
        verylong.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "이용약관"));
        verylong.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "개인정보처리방침"));
        verylong.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "영상정보처리기기운영방침"));
        verylong.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "법적고지"));
        verylong.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "사업자 정보 확인"));

        ExpandableListAdapter.Item faq = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "고객센터");
        data.add(faq);
        faq.invisibleChildren = new ArrayList<>();
        faq.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "FAQ"));
        faq.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "앱 이용안내"));
        faq.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "문의"));
        faq.invisibleChildren.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "공지사항"));

        ExpandableListAdapter.Item option = new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "앱 환경설정");
        data.add(option);

        recyclerView.setAdapter(new ExpandableListAdapter(data));

        return view;
    }
}