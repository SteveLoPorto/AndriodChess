package com.example.movies;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class ReplayDriver extends AppCompatActivity {
    ImageButton a1;
    ImageButton a2;
    ImageButton a3;
    ImageButton a4;
    ImageButton a5;
    ImageButton a6;
    ImageButton a7;
    ImageButton a8;
    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    ImageButton b6;
    ImageButton b7;
    ImageButton b8;
    ImageButton c1;
    ImageButton c2;
    ImageButton c3;
    ImageButton c4;
    ImageButton c5;
    ImageButton c6;
    ImageButton c7;
    ImageButton c8;
    ImageButton d1;
    ImageButton d2;
    ImageButton d3;
    ImageButton d4;
    ImageButton d5;
    ImageButton d6;
    ImageButton d7;
    ImageButton d8;
    ImageButton e1;
    ImageButton e2;
    ImageButton e3;
    ImageButton e4;
    ImageButton e5;
    ImageButton e6;
    ImageButton e7;
    ImageButton e8;
    ImageButton f1;
    ImageButton f2;
    ImageButton f3;
    ImageButton f4;
    ImageButton f5;
    ImageButton f6;
    ImageButton f7;
    ImageButton f8;
    ImageButton g1;
    ImageButton g2;
    ImageButton g3;
    ImageButton g4;
    ImageButton g5;
    ImageButton g6;
    ImageButton g7;
    ImageButton g8;
    ImageButton h1;
    ImageButton h2;
    ImageButton h3;
    ImageButton h4;
    ImageButton h5;
    ImageButton h6;
    ImageButton h7;
    ImageButton h8;
    TextView alert;
    ImageButton[] imageButtonArray;
    Board board = new Board();
    Spinner s;
    Game g;
    Button nextButton;
    int index;



    //@SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replay_layout);
        index=0;
        ArrayList<Game> gList = Synch.loadData();

        nextButton=findViewById(R.id.nextButton);
        alert = findViewById(R.id.alert);
        a1 = findViewById(R.id.a1);
        a1.setTag("a1");
        a2 = findViewById(R.id.a2);
        a2.setTag("a2");
        a3 = findViewById(R.id.a3);
        a3.setTag("a3");
        a4 = findViewById(R.id.a4);
        a4.setTag("a4");
        a5 = findViewById(R.id.a5);
        a5.setTag("a5");
        a6 = findViewById(R.id.a6);
        a6.setTag("a6");
        a7 = findViewById(R.id.a7);
        a7.setTag("a7");
        a8 = findViewById(R.id.a8);
        a8.setTag("a8");
        b1 = findViewById(R.id.b1);
        b1.setTag("b1");
        b2 = findViewById(R.id.b2);
        b2.setTag("b2");
        b3 = findViewById(R.id.b3);
        b3.setTag("b3");
        b4 = findViewById(R.id.b4);
        b4.setTag("b4");
        b5 = findViewById(R.id.b5);
        b5.setTag("b5");
        b6 = findViewById(R.id.b6);
        b6.setTag("b6");
        b7 = findViewById(R.id.b7);
        b7.setTag("b7");
        b8 = findViewById(R.id.b8);
        b8.setTag("b8");
        c1 = findViewById(R.id.c1);
        c1.setTag("c1");
        c2 = findViewById(R.id.c2);
        c2.setTag("c2");
        c3 = findViewById(R.id.c3);
        c3.setTag("c3");
        c4 = findViewById(R.id.c4);
        c4.setTag("c4");
        c5 = findViewById(R.id.c5);
        c5.setTag("c5");
        c6 = findViewById(R.id.c6);
        c6.setTag("c6");
        c7 = findViewById(R.id.c7);
        c7.setTag("c7");
        c8 = findViewById(R.id.c8);
        c8.setTag("c8");
        d1 = findViewById(R.id.d1);
        d1.setTag("d1");
        d2 = findViewById(R.id.d2);
        d2.setTag("d2");
        d3 = findViewById(R.id.d3);
        d3.setTag("d3");
        d4 = findViewById(R.id.d4);
        d4.setTag("d4");
        d5 = findViewById(R.id.d5);
        d5.setTag("d5");
        d6 = findViewById(R.id.d6);
        d6.setTag("d6");
        d7 = findViewById(R.id.d7);
        d7.setTag("d7");
        d8 = findViewById(R.id.d8);
        d8.setTag("d8");
        e1 = findViewById(R.id.e1);
        e1.setTag("e1");
        e2 = findViewById(R.id.e2);
        e2.setTag("e2");
        e3 = findViewById(R.id.e3);
        e3.setTag("e3");
        e4 = findViewById(R.id.e4);
        e4.setTag("e4");
        e5 = findViewById(R.id.e5);
        e5.setTag("e5");
        e6 = findViewById(R.id.e6);
        e6.setTag("e6");
        e7 = findViewById(R.id.e7);
        e7.setTag("e7");
        e8 = findViewById(R.id.e8);
        e8.setTag("e8");
        f1 = findViewById(R.id.f1);
        f1.setTag("f1");
        f2 = findViewById(R.id.f2);
        f2.setTag("f2");
        f3 = findViewById(R.id.f3);
        f3.setTag("f3");
        f4 = findViewById(R.id.f4);
        f4.setTag("f4");
        f5 = findViewById(R.id.f5);
        f5.setTag("f5");
        f6 = findViewById(R.id.f6);
        f6.setTag("f6");
        f7 = findViewById(R.id.f7);
        f7.setTag("f7");
        f8 = findViewById(R.id.f8);
        f8.setTag("f8");
        g1 = findViewById(R.id.g1);
        g1.setTag("g1");
        g2 = findViewById(R.id.g2);
        g2.setTag("g2");
        g3 = findViewById(R.id.g3);
        g3.setTag("g3");
        g4 = findViewById(R.id.g4);
        g4.setTag("g4");
        g5 = findViewById(R.id.g5);
        g5.setTag("g5");
        g6 = findViewById(R.id.g6);
        g6.setTag("g6");
        g7 = findViewById(R.id.g7);
        g7.setTag("g7");
        g8 = findViewById(R.id.g8);
        g8.setTag("g8");
        h1 = findViewById(R.id.h1);
        h1.setTag("h1");
        h2 = findViewById(R.id.h2);
        h2.setTag("h2");
        h3 = findViewById(R.id.h3);
        h3.setTag("h3");
        h4 = findViewById(R.id.h4);
        h4.setTag("h4");
        h5 = findViewById(R.id.h5);
        h5.setTag("h5");
        h6 = findViewById(R.id.h6);
        h6.setTag("h6");
        h7 = findViewById(R.id.h7);
        h7.setTag("h7");
        h8 = findViewById(R.id.h8);
        h8.setTag("h8");
        imageButtonArray = new ImageButton[]{a8, b8, c8, d8, e8, f8, g8, h8, a7, b7, c7, d7, e7, f7, g7, h7, a6, b6, c6, d6, e6, f6, g6, h6, a5, b5, c5, d5, e5, f5, g5, h5, a4, b4, c4, d4, e4, f4, g4, h4, a3, b3, c3, d3, e3, f3, g3, h3, a2, b2, c2, d2, e2, f2, g2, h2, a1, b1, c1, d1, e1, f1, g1, h1};
        Board.initalize();
        g = new Game();
        s = findViewById(R.id.gameSpinner);
        ArrayAdapter<Game> adp1 = new ArrayAdapter<Game>(this,
                android.R.layout.simple_list_item_1, gList);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adp1);

    }

    public void sortDate(View view){
        ArrayList<Game> gList = Synch.loadData();
        gList.sort((o1, o2)
                -> o1.getDate().compareTo(
                o2.getDate()));
        ArrayAdapter<Game> adp1 = new ArrayAdapter<Game>(this,
                android.R.layout.simple_list_item_1, gList);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adp1);
    }

    public void sortName(View view){
        ArrayList<Game> gList = Synch.loadData();
        gList.sort((o1, o2)
                -> o1.toString().compareTo(
                o2.toString()));
        ArrayAdapter<Game> adp1 = new ArrayAdapter<Game>(this,
                android.R.layout.simple_list_item_1, gList);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adp1);
    }


    public int picturePicker(String spot){

        switch (spot){

            case "wplight":
                return R.drawable.whitepawnlightspace;
            case "wpdark":
                return R.drawable.whitepawndarkspace;
            case "wRlight":
                return R.drawable.whiterooklightspace;
            case "wRdark":
                return R.drawable.whiterookdarkspace;
            case "wNlight":
                return R.drawable.whiteknightlightspace;


            case "wNdark":
                return R.drawable.whiteknightdarkspace;


            case "wBlight":
                return R.drawable.whitebishoplightspace;


            case "wBdark":
                return R.drawable.whitebishopdarkspace;


            case "wQlight":
                return R.drawable.whitequeenlightspace;


            case "wQdark":
                return R.drawable.whitequeendarkspace;


            case "wKlight":
                return R.drawable.whitekinglightspace;


            case "wKdark":
                return R.drawable.whitekingdarkspace;


            case "bplight":
                return R.drawable.blackpawnlightspace;


            case "bpdark":
                return R.drawable.blackpawndarkspace;


            case "bRlight":
                return R.drawable.blackrooklightspace;


            case "bRdark":
                return R.drawable.blackrookdarkspace;


            case "bNlight":
                return R.drawable.blackknightlightspace;


            case "bNdark":
                return R.drawable.blackknightdarkspace;


            case "bBlight":
                return R.drawable.blackbishoplightspace;


            case "bBdark":
                return R.drawable.blackbishopdarkspace;


            case "bQlight":
                return R.drawable.blackqueenlightspace;


            case "bQdark":
                return R.drawable.blackqueendarkspace;


            case "bKlight":
                return R.drawable.blackkinglightspace;


            case "bKdark":
                return R.drawable.blackkingdarkspace;


            case "nulllight":
                return  R.drawable.lightspace;


            case "nulldark":
                return R.drawable.darkspace;

            default:
                return 0;
        }
    }
    public void printBoard() {
        Piece[][]boardP = Board.board;
        int iter = 0;
        String currentPieceId;
        String currentSpace;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(boardP[i][j] != null) {
                    currentPieceId = boardP[i][j].identifier;
                }else{
                    currentPieceId = null;
                }
                if(i%2==0 && j%2 == 0){
                    currentSpace = "light";
                }else if(i%2==0) {
                    currentSpace = "dark";
                }else if(j%2 == 0){
                    currentSpace = "dark";
                }else {
                    currentSpace = "light";
                }
                String spot = currentPieceId + currentSpace;
                imageButtonArray[iter].setImageResource(picturePicker(spot));
                iter++;
            }
        }
    }
    public void onNextClick(View view) {
        Move m = ((Game)s.getSelectedItem()).getMoves().get(index);
        String completeMove = (m.getStart() + " " + m.getEnd());
        Log.i("Complete Move:", completeMove);
        String parseOutcome= board.parse(completeMove);
        Log.i("ParseOutcome:", parseOutcome);
        switch (parseOutcome) {
            case "failed":
                alert.setText("IllegalMove");
                break;
            case "success":
                alert.setText("");
                printBoard();
                break;
            case "checkMate":
                alert.setText("CheckMate! "+board.winner+" wins!");
                nextButton.setEnabled(false);

                printBoard();
                break;
            case "check":
                printBoard();
                alert.setText("Check");
                break;
        }
        index++;
    }
}