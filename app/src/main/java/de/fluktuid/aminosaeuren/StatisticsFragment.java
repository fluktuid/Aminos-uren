package de.fluktuid.aminosaeuren;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by fluktuid on 01.09.17.
 */

public class StatisticsFragment extends Fragment {
    public static final String CORRECT_ANSWERS = "correctAnswers";
    public static final String WRONG_ANSWERS = "wrongAnswers";
    private BottomSheetBehavior mBottomSheetBehavior;
    private View bottomSheet;
    private Aminosäure clickedAmino = null;
    private Button bLink;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        ArrayList<StatisticsFragment.Item> items = new ArrayList<>();
        items.add(new SectionItem(getString(R.string.correct_answers)));
        items.addAll((Collection<? extends Item>) getArguments().getSerializable(CORRECT_ANSWERS));
        items.add(new SectionItem(getString(R.string.wrong_answers)));
        items.addAll((Collection<? extends Item>) getArguments().getSerializable(WRONG_ANSWERS));

        final AnswerAdapter adapter = new AnswerAdapter(getContext(), items);
        ListView listView = view.findViewById(R.id.lv);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view1, position, id) -> {
//            if (mBottomSheetBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN)
//                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            Item clicked = items.get(position);
            if (clicked.isHeading() || !(clicked instanceof Aminosäure)) {
//                bLink.setClickable(false);
                return;
            }
            clickedAmino = (Aminosäure) clicked;
            ((ImageView) bottomSheet.findViewById(R.id.iv)).setImageDrawable(clickedAmino.getDrawable());
            ((TextView) bottomSheet.findViewById(R.id.title)).setText(clickedAmino.getName());
            ((TextView) bottomSheet.findViewById(R.id.description)).setText(clickedAmino.getDescription());
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        });

        bottomSheet = view.findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
        bLink = view.findViewById(R.id.b_link);
        bLink.setOnClickListener(view12 -> {
            if (clickedAmino != null) {
                String url = clickedAmino.getLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        return view;
    }

    /**
     * row item
     */
    interface Item {
        View getView(Context context);

        boolean isHeading();
    }

    /**
     * Section Item
     */
    private class SectionItem implements Item {
        private final String title;

        SectionItem(String title) {
            this.title = title;
        }

        public boolean isHeading() {
            return true;
        }

        public View getView(Context context) {
            View v = LayoutInflater.from(context).inflate(R.layout.row_header, null);
            ((TextView) v.findViewById(R.id.title)).setText(title);
            return v;
        }
    }

    /**
     * Adapter
     */
    private class AnswerAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<Item> item;

        AnswerAdapter(Context context, ArrayList<Item> item) {
            this.context = context;
            this.item = item;
        }

        @Override
        public int getCount() {
            return item.size();
        }

        @Override
        public Object getItem(int position) {
            return item.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View answerView, ViewGroup parent) {
            return item.get(position).getView(context);
        }
    }
}
