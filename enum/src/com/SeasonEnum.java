package com;

//basically enum is a class, each units in enum is a new class, and it has its own ordinary and name.
//Each enum class is extended from java.lang.Enum
public enum SeasonEnum {
    SPRING("spring","march"),
    SUMMER(),
    AUTUMN,
    WINTER;

    private String name;
    private String month;

    SeasonEnum(String name, String month) {
        this.name = name;
        this.month = month;
    }


    SeasonEnum() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public static void main(String[] args) {
        System.out.println(SeasonEnum.SPRING.ordinal());
        System.out.println(SeasonEnum.SPRING.month);
        SeasonEnum[] values = SeasonEnum.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].name());
        }
        System.out.println(SeasonEnum.valueOf("SPRING"));
    }
}
