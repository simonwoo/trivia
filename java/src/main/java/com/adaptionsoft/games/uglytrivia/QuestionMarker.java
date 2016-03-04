package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class QuestionMarker {

    public enum Question {
        POP("POP"), SCIENCE("Science"), SPORTS("Sports"), ROCK("Rock");

        private String category;

        private List<String> questions;

        private Question(String category) {
            this.category = category;
            this.questions = new ArrayList<String>();

            for (int i = 0; i < 50; i++) {
                questions.add(category + " Question " + i);
            }
        }
    }

    public void askQuestion(String category) {
        for (Question question : Question.values()) {
            if (category.equals(question.category)) {
                System.out.println(question.questions.remove(0));
            }
        }
    }

    public String getCategory(Player player) {
        if (player.getPlace() == 0 || player.getPlace() == 4 || player.getPlace() == 8) {
            return Question.POP.category;
        }

        if (player.getPlace() == 1 || player.getPlace() == 5 || player.getPlace() == 9) {
            return Question.SCIENCE.category;
        }
        if (player.getPlace() == 2 || player.getPlace() == 6 || player.getPlace() == 10) {
            return Question.SPORTS.category;
        }

        return Question.ROCK.category;
    }
}
