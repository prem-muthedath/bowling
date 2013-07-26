package bowling;

enum Tenpin {
    TOTAL_FRAMES (10), ALL_PINS (10);

    private final int value;    
    private Tenpin(int value) {
        this.value=value;
    }

    public boolean equals(int someValue) {
        return value==someValue;
    }
}
