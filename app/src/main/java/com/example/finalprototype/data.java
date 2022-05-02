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

    public int completed;
    public int incomplete;
    public int duration;
    public HashMap<Integer, Workout> workouts;
    public data inst;

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
        completed = 6;
        incomplete = 0;

    }


    public ArrayList<String> getWorkout(int code) {
        return workouts.get(code).get();
    }

    public int getCompleted() {
        return this.completed;
    }

    public void incrementCompleted() {
        this.completed += 1;
    }

    public int getIncomplete() {
        return this.incomplete;
    }

    public void incrementIncomplete() {
        this.incomplete += 1;
    }

    public boolean getScheduled(int code) { return workouts.get(code).getState(); }

    public void setScheduled(int code, boolean state) { workouts.get(code).setState(state);}

}
