package SOED.Entities;

import java.util.Collection;
import java.util.Iterator;

public abstract class Entity {

    //region Private variables.

    private String name, description;

    private int id;

    //endregion

    //region Constructors.

    public Entity(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    //endregion

    //region Public methods.

    public String getEntityInfo() {
        return "SOED.Entities.Entity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }

    public abstract String getDetails();

    @Override
    public String toString() {
        return "SOED.Entities.Entity{" +
                getEntityInfo() + "}\n" +
                "Details{" +
                getDetails() + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this || !(obj instanceof Entity))
            return false;

        Entity otherEntity = (Entity) obj;

        if (!otherEntity.name.equals(this.name))
            return false;
        if (!otherEntity.description.equals(this.description))
            return false;
        return otherEntity.id == this.id;

    }

    //endregion

}
