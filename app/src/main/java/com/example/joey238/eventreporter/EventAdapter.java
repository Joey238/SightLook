package com.example.joey238.eventreporter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by joey238 on 6/20/17.
 */

public class EventAdapter extends BaseAdapter {
    Context context;//系统的资源
    List<Event> eventData;

    public EventAdapter(Context context) {
        this.context = context;
        eventData = DataService.getEventData();

    }

    @Override
    public int getCount() {
        return eventData.size();
    }

    @Override
    public Event getItem(int position) {
        return eventData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//对每个convertView填充数据
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(// inflater is layout to java object tool
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.event_item,
                    parent, false); //instantiate a event_item object
        }

        TextView eventTitle = (TextView) convertView.findViewById(
                R.id.event_title);
        TextView eventAddress = (TextView) convertView.findViewById(
                R.id.event_address);
        TextView eventDescription = (TextView) convertView.findViewById(
                R.id.event_description);

        Event r = eventData.get(position);
        eventTitle.setText(r.getTitle());
        eventAddress.setText(r.getAddress());
        eventDescription.setText(r.getDescription());
        return convertView;
    }
}
