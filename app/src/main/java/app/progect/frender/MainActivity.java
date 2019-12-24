package app.progect.frender;

import android.app.Application;
import android.content.Context;
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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import app.progect.frender.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private Woman.MyWoman Woman1 = new Woman.MyWoman("Кристина", 1, 23, R.drawable.f2, 1);
    private Woman.MyWoman Woman2 = new Woman.MyWoman("Анжелика", 2, 19, R.drawable.f3, 1);
    private Woman.MyWoman Woman3 = new Woman.MyWoman("Екатерина", 3, 21, R.drawable.f1, 1);
    private Woman.MyWoman Woman4 = new Woman.MyWoman("Сандра", 4, 24, R.drawable.f4, 1);
    private Woman.MyWoman Woman5 = new Woman.MyWoman("Анжела", 5, 25, R.drawable.f5, 1);
    private Woman.MyWoman Woman6 = new Woman.MyWoman("Настя", 6, 26, R.drawable.f6, 1);
    private Woman.MyWoman Woman7 = new Woman.MyWoman("Карина", 7, 18, R.drawable.f7, 1);
    private Woman.MyWoman Woman8 = new Woman.MyWoman("Мадина", 8, 27, R.drawable.f8, 1);
    private Woman.MyWoman Woman9 = new Woman.MyWoman("Наталья", 9, 28, R.drawable.f9, 1);
    private Woman.MyWoman Woman10 = new Woman.MyWoman("Сабрина", 10, 29, R.drawable.f10, 1);
    private Woman.MyWoman Woman11 = new Woman.MyWoman("Ирина", 11, 30, R.drawable.f11, 1);
    private Woman.MyWoman Woman12 = new Woman.MyWoman("Кристина", 12, 19, R.drawable.f12, 1);
    private Woman.MyWoman Woman13 = new Woman.MyWoman("София", 13, 31, R.drawable.f13, 1);
    private Woman.MyWoman[] massiv = {
            Woman1, Woman2, Woman3, Woman4, Woman5, Woman6, Woman7, Woman8, Woman9, Woman10, Woman11, Woman11,
            Woman12, Woman13
    };
    private int number = 0;
    public int like = 0;
    public int dislike = 0;
    public int none = massiv.length-1;
    //public  int firstIn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Ставим первую девушку-------------------------------------------------------
        ImageView imagePeople = (ImageView) findViewById(R.id.imageBase2);
        TextView TextInfo = (TextView) findViewById(R.id.textInfo2);
        imagePeople.setImageResource(massiv[number].img);
        TextInfo.setText(massiv[number].name + ", " + massiv[number].age + " год");

        //Ставим начальные показатели-------------------------------------------------
        TextView textLike = (TextView) findViewById(R.id.textLike);
        TextView textDislike = (TextView) findViewById(R.id.textDislike);
        TextView textNone = (TextView) findViewById(R.id.textNone);
        textLike.setText("Лайки: "+like);
        textDislike.setText("Дизлайки: "+dislike);
        textNone.setText("Не просмотрено: "+none);
    }

    public void OnLikeClick(View view) {

        //Получаем элементы формы----------------
        ImageView imagePeople = (ImageView) findViewById(R.id.imageBase2);
        TextView TextInfo = (TextView) findViewById(R.id.textInfo2);
        //Проверяем статус------------------------------
        if (massiv[number].norm == 1) {
            massiv[number].norm = 2;
            like++;
            none--;
        } else if (massiv[number].norm == 3) {
            massiv[number].norm = 2;
            like++;
            dislike--;
        }
        //Если элемент которому мы изменили статус выше, был последним элементом, то делаем:
        if (number+1 == massiv.length) {
            number =-1; // Для того чтобы следующая строка кода сделала значение "0" и мы смогли поставить нулевую запись на форму
        }
        number++;
        imagePeople.setImageResource(massiv[number].img);
        TextInfo.setText(massiv[number].name + ", " + massiv[number].age + " год");
        //---Меняем текст-------------------------------------------------
        TextView textLike = (TextView) findViewById(R.id.textLike);
        TextView textDislike = (TextView) findViewById(R.id.textDislike);
        TextView textNone = (TextView) findViewById(R.id.textNone);
        textLike.setText("Лайки: "+like);
        textDislike.setText("Дизлайки: "+dislike);
        textNone.setText("Не просмотрено: "+none);

    }

    public void OnUnLikeClick(View view) {

        //Получаем элементы формы----------------
        ImageView imagePeople = (ImageView) findViewById(R.id.imageBase2);
        TextView TextInfo = (TextView) findViewById(R.id.textInfo2);
        //Проверяем статус------------------------------
        if (massiv[number].norm == 1) {
            massiv[number].norm = 3;
            dislike++;
            none--;
        } else if (massiv[number].norm == 2) {
            massiv[number].norm = 3;
            dislike++;
            like--;
        }
        //Если элемент которому мы изменили статус выше, был последним элементом, то делаем:
        if (number+1 == massiv.length) {
            number =-1; // Для того чтобы следующая строка кода сделала значение "0" и мы смогли поставить нулевую запись на форму
        }
        number++;
        imagePeople.setImageResource(massiv[number].img);
        TextInfo.setText(massiv[number].name + ", " + massiv[number].age + " год");
        //---Меняем текст-------------------------------------------------
        TextView textLike = (TextView) findViewById(R.id.textLike);
        TextView textDislike = (TextView) findViewById(R.id.textDislike);
        TextView textNone = (TextView) findViewById(R.id.textNone);
        textLike.setText("Лайки: "+like);
        textDislike.setText("Дизлайки: "+dislike);
        textNone.setText("Не просмотрено: "+none);

    }
}