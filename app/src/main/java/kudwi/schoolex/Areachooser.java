package kudwi.schoolex;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by harishananth on 20/06/17.
 */

public class Areachooser extends AppCompatActivity {
    EditText search;
    ListView searchlist;
    String value;
    ImageView icon;
    ArrayAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.areachooser);
        icon=(ImageView)findViewById(R.id.searchimg);
        searchlist=(ListView)findViewById(R.id.searchlist);
        search=(EditText)findViewById(R.id.input);

        ArrayList<String> arrayarea=new ArrayList<>();
        arrayarea.addAll(Arrays.asList(getResources().getStringArray(R.array.array_areas)));
        adapter=new ArrayAdapter<String>(Areachooser.this,android.R.layout.simple_list_item_1,arrayarea);
        searchlist.setAdapter(adapter);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value=search.getText().toString();

            }
        });
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence cs, int i, int i1, int i2) {
                Areachooser.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
