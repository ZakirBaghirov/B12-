package com.example.myproje.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.speech.tts.TextToSpeech;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.widget.Button;
import android.widget.TextView;

import com.example.myproje.R;

import java.util.Locale;

public class GalleryFragment2 extends Fragment {

    private TextToSpeech tts;
    private TextView babaText, anneText, kardesText;
    private Button sesliOku;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(root, savedInstanceState);

        babaText = root.findViewById(R.id.textViewbaba2);
        anneText = root.findViewById(R.id.textViewbrother2);
        kardesText = root.findViewById(R.id.textViewmother2);
        sesliOku = root.findViewById(R.id.speak);

        tts = new TextToSpeech(requireContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.ENGLISH);
            }
        });

        sesliOku.setOnClickListener(v -> {
            String hepsi = babaText.getText().toString()
                    + ". " + kardesText.getText().toString()
                    + ". " + anneText.getText().toString();

            tts.speak(hepsi, TextToSpeech.QUEUE_FLUSH, null, null);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}
