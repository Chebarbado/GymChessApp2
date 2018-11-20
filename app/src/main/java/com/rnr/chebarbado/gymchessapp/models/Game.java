package com.rnr.chebarbado.gymchessapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Game implements Parcelable {
    private int mode;
    private ArrayList<Player> players;
    private Records records;
    private Routine routine = new Routine();
    private int time;
    private int repeats;
    private ArrayList<Table> tables;
    private ArrayList<Timer> timers;
    private int currentPlayer;

//    public Game(int mode, ArrayList<Player> players, Routine routine, int time, int repeats) {
//        this.mode = mode;
//        this.players = players;
//        this.routine = routine;
//        this.time = time;
//        this.repeats = repeats;
//    }

    private static volatile Game instanse;

    private Game() {
    }


    public static Game getInstanse() {
        Game localinstance = instanse;
        if (localinstance == null) {
            synchronized (Game.class) {
                localinstance = instanse;
                if (localinstance == null) {
                    instanse = localinstance = new Game();

                }
            }

        }

        return localinstance;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(int playersCount) {

        players = null;
        players = new ArrayList<>();
        for (int i = 0; i < playersCount; i++) {
            players.add(new Player(i));
        }
    }

    public int getPlayersCount() {
        if (players == null) {
            return 0;
        }
        return players.size();
    }


    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(int id, int weigth) {
        this.routine.setType(id);
        this.routine.setWeigth(weigth);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getEstimatedTime(int id) {
        if (timers !=null){
        if (timers.get(id)!=null){
            return timers.get(id).getEstimatedTime();
        }}
        return 0;
    }

    public int getRepeats() {
        return repeats;
    }

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public int getTimerValue(int id) {
        return timers.get(id).getEstimatedTime();
    }

    public void setTimers() {
        if (timers == null) {
            timers = new ArrayList<>();
        }
        timers.clear();
        for (int i = 0; i < getPlayersCount(); i++) {
            timers.add(new Timer(time, time));
        }

    }


    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    protected Game(Parcel in) {
        mode = in.readInt();
        if (in.readByte() == 0x01) {
            players = new ArrayList<Player>();
            in.readList(players, Player.class.getClassLoader());
        } else {
            players = null;
        }
        records = (Records) in.readValue(Records.class.getClassLoader());
        routine = (Routine) in.readValue(Routine.class.getClassLoader());
        time = in.readInt();
        repeats = in.readInt();
        if (in.readByte() == 0x01) {
            tables = new ArrayList<Table>();
            in.readList(tables, Table.class.getClassLoader());
        } else {
            tables = null;
        }
        if (in.readByte() == 0x01) {
            timers = new ArrayList<Timer>();
            in.readList(timers, Timer.class.getClassLoader());
        } else {
            timers = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mode);
        if (players == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(players);
        }
        dest.writeValue(records);
        dest.writeValue(routine);
        dest.writeInt(time);
        dest.writeInt(repeats);
        if (tables == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(tables);
        }
        if (timers == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(timers);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}