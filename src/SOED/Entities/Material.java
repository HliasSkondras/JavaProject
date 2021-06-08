package SOED.Entities;

public class Material extends Entity {

    //region Private variables.

    private final double level1, level2, level3;

    //endregion

    //region Constructors.

    public Material(String name, String description, int id, double level1, double level2, double level3) {
        super(name, description, id);
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
    }

    //endregion

    //region Public methods.

    public String getDetails() {
        return toString();
    }

    @Override
    public String toString() {
        return "Material{" +
                "level1=" + level1 +
                ", level2=" + level2 +
                ", level3=" + level3 +
                '}';
    }

    //endregion
}
