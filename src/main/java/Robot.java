class Robot {

    private GridPosition point;
    private Orientation direction;

    public Robot(GridPosition point, Orientation direction) {
        this.point = point;
        this.direction = direction;
    }

    public GridPosition getGridPosition() {
        return this.point;
    }

    public Orientation getOrientation() {
        return this.direction;
    }

    public void turnRight() {
        if (getOrientation() == Orientation.NORTH) {
            this.direction = Orientation.EAST;
        } else if (getOrientation() == Orientation.EAST) {
            this.direction = Orientation.SOUTH;
        } else if (getOrientation() == Orientation.SOUTH) {
            this.direction = Orientation.WEST;
        } else if (getOrientation() == Orientation.WEST) {
            this.direction = Orientation.NORTH;
        }
    }

    public void turnLeft() {
        if (getOrientation() == Orientation.NORTH) {
            this.direction = Orientation.WEST;
        } else if (getOrientation() == Orientation.EAST) {
            this.direction = Orientation.NORTH;
        } else if (getOrientation() == Orientation.SOUTH) {
            this.direction = Orientation.EAST;
        } else if (getOrientation() == Orientation.WEST) {
            this.direction = Orientation.SOUTH;
        }
    }


    public void advance() {
        if (getOrientation() == Orientation.NORTH) {
            this.point = new GridPosition(this.point.getX(), this.point.getY() + 1);
        } else if (getOrientation() == Orientation.EAST) {
            this.point = new GridPosition(this.point.getX() + 1, this.point.getY());
        } else if (getOrientation() == Orientation.SOUTH) {
            this.point = new GridPosition(this.point.getX(), this.point.getY() - 1);
        } else if (getOrientation() == Orientation.WEST) {
            this.point = new GridPosition(this.point.getX() - 1, this.point.getY());
        }
    }

    public void simulate(String input) {

        char[] output = input.toCharArray();

        for (char outputs : output) {
            if (outputs == 'L') {
                turnLeft();
            } else if (outputs == 'R') {
                turnRight();
            } else if (outputs == 'A') {
                advance();
            }
        }
    }

}