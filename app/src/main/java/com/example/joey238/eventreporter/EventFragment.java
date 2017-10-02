package com.example.joey238.eventreporter;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    OnItemSelectListener mCallback;

    // Container Activity must implement this interface
    public interface OnItemSelectListener {//eventFragment 独有的interface
      public void onItemSelected(int position);

    }

    @Override
    public void onAttach(Context context) {//
        super.onAttach(context);//系统方法进行调用, 在这里进行getActivity();
        try {
            mCallback = (OnItemSelectListener) context;//强制转换成了interface，context就是传activity, activity 是Context子类
        } catch (ClassCastException e) {
            //do something
        }
    }

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);//xml有view,将它的id转化成java object: View.(父view)
        ListView listView = (ListView) view.findViewById(R.id.event_list);//why: 通过父的view找到子的view.类似database,primary key

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getEventNames());

        // Assign adapter to ListView.
        listView.setAdapter(adapter);

        //放到系统里面实现按键click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //anonymous class
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.onItemSelected(i);
            }
        });

        return view;
    }


    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"};
        return names;

    }

}
