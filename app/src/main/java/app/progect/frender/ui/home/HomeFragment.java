package app.progect.frender.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import app.progect.frender.MainActivity;
import app.progect.frender.R;
import app.progect.frender.Woman;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
                getActivity().findViewById(R.id.glav_id).setVisibility(View.INVISIBLE);
                getActivity().findViewById(R.id.cont0).setVisibility(View.VISIBLE);

                //TextView demo = (TextView) getActivity().findViewById(R.id.colLike);

                //Bundle arguments = getActivity().getIntent().getExtras();
                //if(arguments!=null){
                  //  Integer lk = arguments.getInt("lukas");
                    //demo.setText("Лукасы: " + lk );
               // }
                //demo.setText("");

                //TextView demo = (TextView) getActivity().findViewById(R.id.colLike);
               // demo.setText("Лайки: "+like);

            }
        });
        return root;

    }
   /* private void reciveIntent(){

        Intent i = getActivity().getIntent();
        if(i != null){
            like=i.getIntExtra( "lukas",0);
            //position=i.getIntExtra( "position",0);
        }} */
}



