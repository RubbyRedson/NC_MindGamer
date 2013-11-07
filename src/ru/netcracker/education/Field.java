package ru.netcracker.education;

import ru.netcracker.education.abstract_classes.AbstractField;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 06.11.13
 * Time: 22:25
 * To change this template use File | Settings | File Templates.
 */
public class Field extends AbstractField {

    public Field() {
        super();
    }

    @Override
    public void updateField (Cell move) {
        Field.UpdateField(move);
    }

    @Override
    public FieldCells getField() {
        return Field;
    }
}
