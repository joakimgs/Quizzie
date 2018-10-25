package se.hkr.joakim.quizzie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {


    private TextView tvQuizID, tvQuizQuestion;
    private Button btnAnswer, btnOption1, btnOption2, btnOption3, btnOption4;
    private int questionJuniorNumber = 1, questionSeniorNumber = 1;
    private boolean difficultyJunior, difficultySenior;
    private int i = 0;
    private int userPoints = 0;
    private boolean correctAnswer = false;
    String[] quizTitleJunior = {
            "What's 12 - 7?",
            "How many stomachs does a cow have?",
            "Which one of the following countries is not European?",
            "Which animal of the following is a predator?",
            "Quiz is over!"
    };

    String[] quizTitleSenior = {
            "What's 63 - 7 (3 * 27) + 5?",
            "How many countries are there in Europe?",
            "Who was the richest man on Earth 2017?",
            "Which of the following languages are spoken by most people?",
            "Quiz is over!"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        tvQuizID = findViewById(R.id.tvQuizID);
        tvQuizQuestion = findViewById(R.id.tvQuizQuestion);
        Bundle bundle = getIntent().getExtras();
        boolean difficultyJunior = bundle.getBoolean("juniorDifficulty");
        boolean difficultySenior = bundle.getBoolean("seniorDifficulty");
        btnOption1 = findViewById(R.id.button5);
        btnOption2 = findViewById(R.id.button6);
        btnOption3 = findViewById(R.id.button7);
        btnOption4 = findViewById(R.id.button8);

            if(bundle.getBoolean("juniorDifficulty")){
                tvQuizID.setText("Junior Difficulty, Question " + questionJuniorNumber + "\n Your points = " + userPoints);
                drawJuniorQuestions();
                i = 1;
            }
            else{
                tvQuizID.setText("Senior Difficulty, Question " + questionSeniorNumber + "\n Your points = " + userPoints);
                drawSeniorQuestions();
                i = 1;
            }
    }


    public void setTitle(boolean juniorDifficulty, boolean seniorDifficulty) {
        if (juniorDifficulty) {
            tvQuizID.setText(questionJuniorNumber);
        }   else if (seniorDifficulty){
            tvQuizID.setText(questionSeniorNumber);
        }
    }


    public void drawJuniorQuestions() {
        tvQuizQuestion.setText(quizTitleJunior[i]);
        if(i == 0){
            btnOption1.setText("5");
            btnOption2.setText("3");
            btnOption3.setText("6");
            btnOption4.setText("4");
        }

        if(i == 1){
            btnOption1.setText("1");
            btnOption2.setText("4");
            btnOption3.setText("3");
            btnOption4.setText("2");
        }

        if(i == 2) {
            btnOption1.setText("Sweden");
            btnOption2.setText("France");
            btnOption3.setText("Japan");
            btnOption4.setText("Germany");
        }

        if(i == 3) {
            btnOption1.setText("Moose");
            btnOption2.setText("Deer");
            btnOption3.setText("Rabbit");
            btnOption4.setText("Fox");
        }
        i++;

        if ((questionJuniorNumber > 4) || (questionSeniorNumber > 4)) {
            questionJuniorNumber --;
            questionSeniorNumber --;
            Toast.makeText(getApplicationContext(), "Game is finished, you have answered all the questions!", Toast.LENGTH_SHORT).show();
            btnOption1.setClickable(false);
            btnOption2.setClickable(false);
            btnOption3.setClickable(false);
            btnOption4.setClickable(false);
        }
    }

    public void drawSeniorQuestions() {
        tvQuizQuestion.setText(quizTitleSenior[i]);
        if(i == 0){
            btnOption1.setText("-499");
            btnOption2.setText("-399");
            btnOption3.setText("-599");
            btnOption4.setText("399");
        }

        if(i == 1){
            btnOption1.setText("47");
            btnOption2.setText("49");
            btnOption3.setText("50");
            btnOption4.setText("48");
        }

        if(i == 2) {
            btnOption1.setText("Warren Buffett");
            btnOption2.setText("Jeff Bezos");
            btnOption3.setText("Bill Gates");
            btnOption4.setText("Amancio Ortega");
        }

        if(i == 3) {
            btnOption1.setText("English");
            btnOption2.setText("Hindi");
            btnOption3.setText("Arabic");
            btnOption4.setText("Spanish");
        }


        if ((questionJuniorNumber > 4) || (questionSeniorNumber > 4)) {
            questionJuniorNumber--;
            questionSeniorNumber--;
            Toast.makeText(getApplicationContext(), "Game is finished, you have answered all the questions!", Toast.LENGTH_SHORT).show();
            btnOption1.setClickable(false);
            btnOption2.setClickable(false);
            btnOption3.setClickable(false);
            btnOption4.setClickable(false);
        }
        i++;
    }

    public void updateQuestion(View view) {
    }

        public void answerOne(View view){
            Bundle bundle = getIntent().getExtras();
            if ((questionJuniorNumber > 3) || (questionSeniorNumber > 3)) {
                Toast.makeText(getApplicationContext(), "Game is finished, you have answered all the questions!", Toast.LENGTH_SHORT).show();
                btnOption1.setClickable(false);
                btnOption2.setClickable(false);
                btnOption3.setClickable(false);
                btnOption4.setClickable(false);
            }
            else if (bundle.getBoolean("juniorDifficulty")) {
                questionJuniorNumber++;
                if(i == 1){
                    userPoints++;
                }
                drawJuniorQuestions();
                tvQuizID.setText("Junior Difficulty, Question " + questionJuniorNumber +  "\n Your points = " + userPoints);


            } else if (bundle.getBoolean("seniorDifficulty")) {
                questionSeniorNumber++;
                if(i == 1){
                    userPoints++;
                }

                drawSeniorQuestions();
                tvQuizID.setText("Senior Difficulty, Question " + questionSeniorNumber + "\n Your points = " + userPoints);
            }
        }

        public void answerTwo(View view){
            Bundle bundle = getIntent().getExtras();
            if ((questionJuniorNumber > 3) || (questionSeniorNumber > 3)) {
                Toast.makeText(getApplicationContext(), "Game is finished, you have answered all the questions!", Toast.LENGTH_SHORT).show();
                btnOption1.setClickable(false);
                btnOption2.setClickable(false);
                btnOption3.setClickable(false);
                btnOption4.setClickable(false);
            }else if (bundle.getBoolean("juniorDifficulty")) {
                questionJuniorNumber++;

                if(i == 2){
                    userPoints++;
                }
                drawJuniorQuestions();
                tvQuizID.setText("Junior Difficulty, Question " + questionJuniorNumber + "\n Your points = " + userPoints);

            } else if (bundle.getBoolean("seniorDifficulty")) {
                questionSeniorNumber++;

                if(i == 2){
                    userPoints++;
                }

                drawSeniorQuestions();
                tvQuizID.setText("Senior Difficulty, Question " + questionSeniorNumber + "\n Your points = " + userPoints);
            }
        }
        public void answerThree(View view){
            Bundle bundle = getIntent().getExtras();
            if ((questionJuniorNumber > 3) || (questionSeniorNumber > 3)) {
                Toast.makeText(getApplicationContext(), "Game is finished, you have answered all the questions!", Toast.LENGTH_SHORT).show();
                btnOption1.setClickable(false);
                btnOption2.setClickable(false);
                btnOption3.setClickable(false);
                btnOption4.setClickable(false);
            }
            else if (bundle.getBoolean("juniorDifficulty")) {
                questionJuniorNumber++;

                if(i == 3){
                    userPoints++;
                }
                tvQuizID.setText("Junior Difficulty, Question " + questionJuniorNumber + "\n Your points = " + userPoints);
                drawJuniorQuestions();
            } else if (bundle.getBoolean("seniorDifficulty")) {
                questionSeniorNumber++;

                if(i == 3){
                    userPoints++;
                }
                drawSeniorQuestions();
                tvQuizID.setText("Senior Difficulty, Question " + questionSeniorNumber + "\n Your points = " + userPoints);
            }
        }
         public void answerFour(View view){
             Bundle bundle = getIntent().getExtras();

             if (bundle.getBoolean("juniorDifficulty")) {

                 if(i == 4){
                     userPoints++;
                 }
                 tvQuizID.setText("Junior Difficulty, Question " + questionJuniorNumber  + "\n Your points = " + userPoints);
                 drawJuniorQuestions();
                 if(questionJuniorNumber < 4) {
                     questionJuniorNumber++;
                 }

             } else if (bundle.getBoolean("seniorDifficulty")) {
                 questionSeniorNumber++;
                 if(i == 4){
                     userPoints++;
                 }

                 drawSeniorQuestions();
                 tvQuizID.setText("Senior Difficulty, Question " + questionSeniorNumber + "\n Your points = " + userPoints);
             }
        }
    }