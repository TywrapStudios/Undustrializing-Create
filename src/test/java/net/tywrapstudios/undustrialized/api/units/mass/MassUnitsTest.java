package net.tywrapstudios.undustrialized.api.units.mass;
// Generated by CodiumAI

import net.tywrapstudios.undustrialized.api.units.mass.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.function.DoubleUnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class MassUnitsTest {


    // Shoulinecrd be able to get symbol of a MassUnit
    @Tag("mass")
    @Test
    public void test_get_symbol() {
        MassUnit unit = MassUnits.KILOGRAM;
        String symbol = unit.getSymbol();
        assertEquals("kg", symbol);
    }

    // Should be able to get base unit of a MassUnit
    @Tag("mass")
    @Test
    public void test_get_base_unit() {
        MassUnit unit = MassUnits.GRAM;
        MassUnit baseUnit = unit.getBaseUnit();
        assertEquals(MassUnits.KILOGRAM, baseUnit);
    }

    @Tag("mass")
    @Test
    public void test_to_value_in_base_unit() {
        MassUnit unit = MassUnits.MILLIGRAM;
        double valueInThisUnit = 500.0;
        double valueInBaseUnit = unit.toValueInBaseUnit(valueInThisUnit);
        assertEquals(0.5, valueInBaseUnit);
    }

//    @Tag("mass")
//    @Test
//    public void test_to_value() {
//        MassUnit unit = MassUnits.MILLIGRAM;
//        double valueInPicogram = MassUnits.PICOGRAM;
//        double valueInMilligram = unit.fromValueInBaseUnit()
//    }

    @Tag("mass")
    @Test
    public void test_from_value_in_base_unit() {
        MassUnit unit = MassUnits.MILLIGRAM;
        double valueInBaseUnit = 0.5;
        double valueInThisUnit = unit.fromValueInBaseUnit(valueInBaseUnit);
        assertEquals(500.0, valueInThisUnit);
    }

    @Tag("mass")
    @Test
    public void test_from_symbol() {
        String symbol = "mg";
        MassUnit unit = MassUnits.fromSymbol(symbol);
        assertEquals(MassUnits.MILLIGRAM, unit);
    }

    @Tag("mass")
    @Test
    public void test_from_symbol_null_or_blank() {
        String symbol = null;
        MassUnit unit = MassUnits.fromSymbol(symbol);
        assertEquals(MassUnits.getDefaultUnit(), unit);

        symbol = "";
        unit = MassUnits.fromSymbol(symbol);
        assertEquals(MassUnits.getDefaultUnit(), unit);
    }

    @Tag("mass")
    @Test
    public void test_from_symbol_unsupported() {
        String symbol = "abc";
        assertThrows(ArithmeticException.class, () -> MassUnits.fromSymbol(symbol));
    }

    @Tag("mass")
    @Disabled
    @Test
    public void test_unify_symbol_null_or_blank() {
        String inputString = null;
        String unifiedSymbol = MassUnits.unifySymbol(inputString);
        assertEquals("", unifiedSymbol);

        inputString = "";
        unifiedSymbol = MassUnits.unifySymbol(inputString);
        assertEquals("", unifiedSymbol);
    }

    @Tag("mass")
    @Test
    public void test_unify_symbol() {
        String inputString = "Kilo_Gram";
        String unifiedSymbol = MassUnits.unifySymbol(inputString);
        assertEquals("kilogram", unifiedSymbol);
    }

    @Tag("mass")
    @Test
    public void test_get_default_unit() {
        MassUnit defaultUnit = MassUnits.getDefaultUnit();
        assertEquals(MassUnits.KILOGRAM, defaultUnit);
    }

    @Tag("mass")
    @Test
    public void test_create_enum_value() {
        String symbol = "mg";
        DoubleUnaryOperator toBaseConverter = val -> val * Math.pow(10, -3);
        DoubleUnaryOperator fromBaseToUnitConverter = val -> val / Math.pow(10, -3);

        MassUnits unit = MassUnits.MILLIGRAM;
        assertEquals(symbol, unit.getSymbol());
    }

    // Should be able to handle negative values when converting to and from base unit
    @Tag("mass")
    @Disabled
    @Test
    public void test_negative_values_conversion() {
        MassUnit unit = MassUnits.GRAM;
        double valueInThisUnit = -500.0;

        double valueInBaseUnit = unit.toValueInBaseUnit(valueInThisUnit);
        assertEquals(-0.5, valueInBaseUnit);

        double valueInThisUnitConverted = unit.fromValueInBaseUnit(valueInBaseUnit);
        assertEquals(valueInThisUnit, valueInThisUnitConverted);
    }

}