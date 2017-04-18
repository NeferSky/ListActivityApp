package nefersky.listactivityapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ListActivity /*implements AdapterView.OnItemLongClickListener*/ {

    final String[] catNamesArray = new String[]{"Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
        "Томасина", "Бобик", "Кристина", "Пушок", "Дымка", "Кузя", "Китти", "Барбос", "Масяня",
        "Симба"};
    private ArrayList<String> catNamesList = new ArrayList<>(Arrays.asList(catNamesArray));
    private ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = getListView();
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                mAdapter.remove(selectedItem);
                mAdapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), "Удален элемент " + selectedItem, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, catNamesList);
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getApplicationContext(), "Выбран элемент " + l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
