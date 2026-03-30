package lk.rumex.ott_domain_models.clientPackage.Enum;

public enum BillingPeriod {
    MONTHLY,
    ANNUAL,
    ONE_TIME,
    QUARTERLY,
    HALF_YEARLY,
    DAILY,
    BY_WEEKLY,
    WEEKLY;

    public Integer toDays() {
        return switch (this) {
            case DAILY -> 1;
            case WEEKLY -> 7;
            case BY_WEEKLY -> 14;
            case MONTHLY -> 30;
            case QUARTERLY -> 90;
            case HALF_YEARLY -> 182;
            case ANNUAL -> 365;
            case ONE_TIME -> null;
        };
    }
}
