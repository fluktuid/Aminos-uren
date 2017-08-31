package de.fluktuid.aminosaeuren;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private ImageView acid;
    private RadioButton[] radio = new RadioButton[4];
    private Random random = new Random();
    private ArrayList<Aminosäure> leftOverAcidList = new ArrayList<>();
    private ArrayList<Aminosäure> acidList = new ArrayList<>();
    private TextView position;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        position = (TextView) findViewById(R.id.position);

        leftOverAcidList = loadAminosaeuren();
        acidList = new ArrayList<>(leftOverAcidList);

        Button buttonChoose = (Button) findViewById(R.id.choose);
        acid = (ImageView) findViewById(R.id.acid);
        radio[0] = (RadioButton) findViewById(R.id.radio0);
        radio[1] = (RadioButton) findViewById(R.id.radio1);
        radio[2] = (RadioButton) findViewById(R.id.radio2);
        radio[3] = (RadioButton) findViewById(R.id.radio3);
        buttonChoose.setOnClickListener(this);
        setAminosaeure();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @SuppressWarnings("deprecation")
    private ArrayList<Aminosäure> loadAminosaeuren() {
        ArrayList<Aminosäure> saeuren = new ArrayList<>();
        //TODO: Aminosäuren hinzufügen
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_alanin), "alanin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_arginin), "arginin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_asparagin), "asparagin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_asparaginsaeure), "asparaginsäure"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_cystein), "cystein"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.glutamin), "glutamin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_glutaminsaeure), "glutaminsäure"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.glycine), "glycine"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_histidin), "histidin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_isoleucine), "isoleucine"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_leucin), "leucin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_lysine), "lysine"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_methionin), "methionin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_phenylalanine), "phenylalanine"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_proline), "proline"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_serine), "serine"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.threonine), "threonine"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_tryptophan), "tryptophan"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_tyrosine), "tyrosine"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_valine), "valine"));
        Collections.shuffle(saeuren, random);

        return saeuren;
    }

    private Aminosäure currentAmino = null;

    private void setAminosaeure() {
        if (currentAmino != null)
            leftOverAcidList.remove(currentAmino);
        int chosen = random.nextInt(leftOverAcidList.size());
        position.setText((acidList.size() - leftOverAcidList.size()) + 1 + "/" + acidList.size());
        currentAmino = leftOverAcidList.get(chosen);
        acid.setImageDrawable(currentAmino.getDrawable());
        int[] x;
        do x = random.ints(1, acidList.size()).distinct().limit(3).toArray();
        while (x[0] == chosen || x[1] == chosen || x[2] == chosen);
        ArrayList<String> possibilities = new ArrayList<>();
        possibilities.add(acidList.get(x[0]).getName());
        possibilities.add(acidList.get(x[1]).getName());
        possibilities.add(acidList.get(x[2]).getName());
        possibilities.add(currentAmino.getName());
        Collections.shuffle(possibilities, random);
        for (int i = 0; i < radio.length; i++)
            radio[i].setText(possibilities.get(i));
    }

    @Override
    public void onClick(View view) {
        if (currentAmino == null) {
            Toast.makeText(this, "Bitte wähle eine Antwortmöglichkeit.", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton checked = null;
        for (RadioButton button : radio)
            if (button.isChecked()) {
                checked = button;
                button.setChecked(false);
                break;
            }
        if (checked == null)
            return;
        String s = checked.getText().toString();
        if (s.equals(currentAmino.getName()))
            Toast.makeText(this, "Die Antwort war korrekt.", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Die Antwort war falsch.\nKorrekt wäre " + currentAmino.getName() + " gewesen.", Toast.LENGTH_SHORT).show();
        if (leftOverAcidList.size() > 0)
            setAminosaeure();
        else {
            //fertig
        }
    }
}