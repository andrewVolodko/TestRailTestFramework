package enums;

public enum ProjectSummaryLink {
    TODOS(0),
    MILESTONES(1),
    TEST_RUNS(2),
    TEST_SUITES(3),
    TEST_CASES(3),
    REPORTS(4);

    private final int value;

    ProjectSummaryLink(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
