package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Defensable, Attackable {
    private static int hitCount;

    public abstract String getName();

    public BodyPart attack() {
        hitCount = hitCount + 1;
        return getBodyPart();
    }

    public BodyPart defense() {
        hitCount = hitCount + 2;
        return getBodyPart();
    }

    private BodyPart getBodyPart() {
        if (hitCount == 1) {
           return BodyPart.HEAD;
        } else if (hitCount == 2) {
            return BodyPart.LEG;
        } else if (hitCount == 3) {
            return BodyPart.ARM;
        } else {
            hitCount = 0;
            return BodyPart.CHEST;
        }
    }
}
