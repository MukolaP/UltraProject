package com.example.ultraproject.Notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ultraproject.R;

public class NotesReviewFragment extends Fragment {

    TextView themeNotes;
    TextView bodyNotes;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_notes_review, null);

        Button back_notes = view.findViewById(R.id.back_ToNotesReview);
        back_notes.setOnClickListener(view1 -> navigation(0));

        themeNotes = view.findViewById(R.id.themes_reviewNotes);
        bodyNotes = view.findViewById(R.id.body_reviewNotes);

        themeNotes.setText(themeNotes.getText() + " " + NotesController.getArrayList_themes().get(NotesController.getPos()));
        bodyNotes.setText(NotesController.getArrayList_body().get(NotesController.getPos()));

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    public final void navigation(int pos) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        if (pos == 0) {
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.MainActivity, NotesFragment.class, null);
            transaction.commit();
        }
    }
}