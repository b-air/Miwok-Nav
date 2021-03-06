package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bruno on 17/05/2017.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    private String mbackgroundColor;



    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param Word  A List of Word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> words, String backgroundColor ) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);


        mbackgroundColor = backgroundColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if(currentWord.hasImage()) {
            iconView.setImageResource(currentWord.getImageResourceId());
        } else {
            iconView.setVisibility(View.GONE);

        }

        //linear container
        LinearLayout container = (LinearLayout) listItemView.findViewById(R.id.text_container);
        //Check color
        if (mbackgroundColor.equals("blue")) {
            container.setBackgroundResource(R.color.category_phrases);
        }else if (mbackgroundColor.equals("green")) {
            container.setBackgroundResource(R.color.category_family);
        }else if (mbackgroundColor.equals("violet")) {
            container.setBackgroundResource(R.color.category_colors);
        } else {
            container.setBackgroundResource(R.color.category_numbers);
        }




        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

        //return super.getView(position, convertView, parent);
    }
}
