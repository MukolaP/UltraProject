package com.example.ultraproject.Notes;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ultraproject.R;

public class WriteNotesFragment extends Fragment {

    private EditText theme_notes;
    private EditText body_notes;

    NotesController notesController = new NotesController();
    NotesFragment notesFragment = new NotesFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_write_notes, null);

        Button back_notes = view.findViewById(R.id.back_ToNotes);
        navigation(back_notes);

        Button button_add = view.findViewById(R.id.bt_notes_add);

        theme_notes = view.findViewById(R.id.theme_notes);
        body_notes = view.findViewById(R.id.body_notes);

        button_add.setOnClickListener(view1 -> {
            String[] themes = new String[]{"0","1"};
            themes[0]= String.valueOf(theme_notes.getText());
            notesController.setThemes(themes);
        });

        return view;
    }
    @SuppressLint("NonConstantResourceId")
    public void navigation(Button button) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            if (view.getId() == R.id.back_ToNotes) {
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, NotesFragment.class, null);
                transaction.commit();
            }
        });
    }
}