package app.progect.frender.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import app.progect.frender.MainActivity;
import app.progect.frender.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       // View view =  inflater.inflate(R.layout.activity_main, container, false);

        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
                //ImageView imagePeople = (ImageView) getActivity().findViewById(R.id.imageBase2);
                //TextView TextInfo = (TextView) getActivity().findViewById(R.id.textInfo2);
                //imagePeople.setImageResource(massiv[number].img);
                //TextInfo.setText(massiv[number].name+", "+massiv[number].age+" год");

                getActivity().findViewById(R.id.glav_id).setVisibility(View.VISIBLE);

            }
        });



        return root;
    }

}