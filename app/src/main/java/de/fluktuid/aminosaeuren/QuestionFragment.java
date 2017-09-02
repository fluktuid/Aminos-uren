package de.fluktuid.aminosaeuren;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by fluktuid on 01.09.17.
 */

public class QuestionFragment extends Fragment implements View.OnClickListener {
    private ImageView acid;
    private RadioButton[] radio = new RadioButton[4];
    private Random random = new Random();
    private ArrayList<Aminosäure> leftOverAcidList = new ArrayList<>();
    private ArrayList<Aminosäure> acidList = new ArrayList<>();
    private TextView position;
    private ArrayList<Aminosäure> correctAcids = new ArrayList<>();
    private ArrayList<Aminosäure> wrongAcids = new ArrayList<>();
    private RadioGroup radioGroup;
    private static final String WIKI_LINK = "https://de.wikipedia.org/wiki/";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question, container, false);


        position = v.findViewById(R.id.position);

        leftOverAcidList = loadAminosaeuren();
        acidList = new ArrayList<>(leftOverAcidList);

        Button buttonChoose = v.findViewById(R.id.choose);
        buttonChoose.setOnClickListener(this);

        acid = v.findViewById(R.id.acid);
        radioGroup = v.findViewById(R.id.radioGroup);
        radio[0] = v.findViewById(R.id.radio0);
        radio[1] = v.findViewById(R.id.radio1);
        radio[2] = v.findViewById(R.id.radio2);
        radio[3] = v.findViewById(R.id.radio3);

        setAminosaeure();

        return v;
    }


    @SuppressWarnings("deprecation")
    private ArrayList<Aminosäure> loadAminosaeuren() {
        ArrayList<Aminosäure> saeuren = new ArrayList<>();
        //TODO: Aminosäuren hinzufügen
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_alanin), "alanin",getString(R.string.description_alanin),WIKI_LINK+"Alanin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_arginin), "arginin",getString(R.string.description_arginin),WIKI_LINK+"Arginin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_asparagin), "asparagin",getString(R.string.description_asparagin),WIKI_LINK+"Asparagin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_asparaginsaeure), "asparaginsäure",getString(R.string.description_asparaginsaeure),WIKI_LINK+"Asparginsäure"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_cystein), "cystein",getString(R.string.description_cystein),WIKI_LINK+"cystein"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_glutamin), "glutamin",getString(R.string.description_glutamin),WIKI_LINK+"glutamin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_glutaminsaeure), "glutaminsäure",getString(R.string.description_glutaminsaeure),WIKI_LINK+"glutamin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_glycine), "glycine",getString(R.string.description_glycin),WIKI_LINK+"glycin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_histidin), "histidin",getString(R.string.description_histidin),WIKI_LINK+"histidin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_isoleucine), "isoleucine",getString(R.string.description_isoleucin),WIKI_LINK+"isoleucin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_leucin), "leucin",getString(R.string.description_leucin),WIKI_LINK+"leucin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_lysine), "lysin",getString(R.string.description_lysin),WIKI_LINK+"lysin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_methionin), "methionin",getString(R.string.description_methionin),WIKI_LINK+"methionin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_phenylalanine), "phenylalanine",getString(R.string.description_phenylalanin),WIKI_LINK+"phenylalanin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_proline), "proline",getString(R.string.description_prolin),WIKI_LINK+"proline"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_serine), "serine",getString(R.string.description_Serin),WIKI_LINK+"serin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.threonine), "threonin",getString(R.string.description_threonin),WIKI_LINK+"threonin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_tryptophan), "tryptophan",getString(R.string.description_tryptophan),WIKI_LINK+"tryptophan"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_tyrosine), "tyrosin",getString(R.string.description_tyrosin),WIKI_LINK+"tyrosin"));
        saeuren.add(new Aminosäure(getResources().getDrawable(R.drawable.ic_valine), "valine",getString(R.string.description_valine),WIKI_LINK+"valine"));
        Collections.shuffle(saeuren, random);

        return saeuren;
    }

    private Aminosäure currentAmino = null;

    private void setAminosaeure() {
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
        String selection;
        if (radioGroup.getCheckedRadioButtonId() != -1) {
            int id = radioGroup.getCheckedRadioButtonId();
            View radioButton = radioGroup.findViewById(id);
            int radioId = radioGroup.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
            selection = (String) btn.getText();
        } else {
            Toast.makeText(getContext(), "Bitte wähle eine Antwortmöglichkeit.", Toast.LENGTH_SHORT).show();
            return;
        }
        radioGroup.clearCheck();
        if (selection.equals(currentAmino.getName())) {
            Toast.makeText(getContext(), "Die Antwort war korrekt.", Toast.LENGTH_SHORT).show();
            correctAcids.add(currentAmino);
        } else {
            Toast.makeText(getContext(), "Die Antwort war falsch.\nKorrekt wäre " + currentAmino.getName() + " gewesen.", Toast.LENGTH_SHORT).show();
            wrongAcids.add(currentAmino);
        }
        if (currentAmino != null)
            leftOverAcidList.remove(currentAmino);
        if (leftOverAcidList.size() > 0) {
            setAminosaeure();
        } else {
            ((MainActivity) getActivity()).changeToStatistics(correctAcids, wrongAcids);
            // fertig
            // Statistische Daten anzeigen...
        }
    }
}
