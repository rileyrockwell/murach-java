public enum CustomerType {
    RETAIL,
    TRADE,
    COLLEGE;

    @Override
    public String toString() {
        String s = switch (this.ordinal()) {
            case 0 -> "Retail customer";
            case 1 -> "Trade customer";
            case 2 -> "College customer";
            default -> "";
        };
        return s;
    }
}
