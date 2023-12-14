package org.ot5usk;

import org.ot5usk.scripts.FirstScript;
import org.ot5usk.scripts.SecondScript;
import org.ot5usk.scripts.ThirdScript;
import org.ot5usk.tasks.FirstTask;
import org.ot5usk.tasks.SecondTask;
import org.ot5usk.tasks.ThirdTask;

public class Main {

    private static final FirstTask firstTask = new FirstScript();
    private static final SecondTask secondTask = new SecondScript();
    private static final ThirdTask thirdTask = new ThirdScript();

    public static void main(String[] args) {
        firstTask.execute();
        secondTask.execute();
        thirdTask.execute();
    }
}
