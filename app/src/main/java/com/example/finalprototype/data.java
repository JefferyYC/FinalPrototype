package com.example.finalprototype;


import java.util.ArrayList;
import java.util.HashMap;


public class data {

    private class Workout {

        String _time;
        String _duration;
        boolean _scheduled;

        private Workout(String time, String duration, boolean scheduled) {
            _time = time;
            _duration = duration;
            _scheduled = scheduled;
        }

        private ArrayList<String> get() {
            ArrayList<String> ret = new ArrayList<String>();
            ret.add(_time);
            ret.add(_duration);
            return ret;
        }

        private boolean getState() {
            return _scheduled;
        }

        private void setState(boolean state) {
            _scheduled = state;
        }
    }

    static int[] completed;
    static int[] incomplete;
    static HashMap<Integer, Workout> workouts;

    public data() {

        workouts = new HashMap<Integer, Workout>();

        //10:30am, Breathing One, 4/25: Code 1
        workouts.put(1, new Workout("10:30 am", "5:00", true));

        //2:30pm, Meditation, 4/25: Code 2
        workouts.put(2, new Workout("2:30 pm", "30:00", true));

        //3:30pm, Meditation, 4/25: Code 3
        workouts.put(3, new Workout("3:30 pm", "30:00", false));

        //6:00pm, Breathing Two, 4/25: Code 4
        workouts.put(4, new Workout("5:00 pm", "10:00", false));

        //12:00pm, Meditation, 4/27: Code 5
        workouts.put(5, new Workout("12:00 pm", "30:00", false));


        //instantiating counts based on figma data
        completed = new int[] {6, 7, 5};
        incomplete = new int[] {0, 2, 1};
        //[0, 1, 2] correspond to [breathing one, breathing two, meditation]

    }

    public static ArrayList<String> getWorkout(int code) {
        return workouts.get(code).get();
    }

    public static int getCompleted(int type) {
        return completed[type];
    }

    public static void incrementCompleted(int type) {
        completed[type] = completed[type] + 1;
    }

    public static int getIncomplete(int type) {
        return incomplete[type];
    }

    public static void incrementIncomplete(int type) {
        incomplete[type] = incomplete[type] + 1;
    }

    public static boolean getScheduled(int code) { return workouts.get(code).getState(); }

    public static void setScheduled(int code, boolean state) { workouts.get(code).setState(state);}

}
