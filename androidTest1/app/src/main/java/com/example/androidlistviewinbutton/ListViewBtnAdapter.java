package com.example.androidlistviewinbutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListViewBtnAdapter extends ArrayAdapter implements View.OnClickListener {
    // 버튼 클릭을 위한 Listener 정의
    public interface ListBtnClickListener{
        void onListBtnClick(int position);
    }

    int resourceId; // 생성자로부터 전달된 resource 값을 저장
    private ListBtnClickListener listBtnClickListener;  // 생성자로부터 전달된 listBtnClickListener 값을 저장
    ListViewBtnAdapter(Context context, int resource, ArrayList<ListViewBtnItem> list,
                       ListBtnClickListener clickListener){
        super(context, resource, list);

        this.resourceId = resource;
        this.listBtnClickListener = clickListener;
    }
    // 새롭게 만든 Layout을 위한 View를 생성하는 코드
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // 생성자로 부터 저장된 resourceId(Listview_btn_item) 에
        // 해당하는 Layout을 inflate하여 convertView참조 획득
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resourceId/*R.Layout.listview_btn_item*/, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)로 부터 위젯에 대한 참조 획득
        final ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        final TextView textView = (TextView) convertView.findViewById(R.id.textView1);

        // Data Set(ListViewItemList)에서 position에 위치한 데이터 참조 획득
        final ListViewBtnItem listViewItem = (ListViewBtnItem) getItem(position);

        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getIcon());
        textView.setText(listViewItem.getText());

        // button클릭 시 TextView의 내용 변경
        Button button = (Button) convertView.findViewById(R.id.button1);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                textView.setText(Integer.toString(pos + 1) + "번 아이템 선택");
            }
        });

        // button2의 태그에 position값 지정 Adapter를 click listener
        Button button2 = (Button) convertView.findViewById(R.id.button2);
        button2.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        if(this.listBtnClickListener != null){
            this.listBtnClickListener.onListBtnClick((int)v.getTag());
        }
    }
}
