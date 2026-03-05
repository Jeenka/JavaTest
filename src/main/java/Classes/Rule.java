package Classes;

import Enums.RuleOperand;

import java.util.function.Function;

public class Rule {
    String fieldName;
    RuleOperand operand;
    String value;

    /*String getSQLStatement(){
         return ;
    }*/

    Function getFunction(){
        return null; // Превратить rule в джава функцию, можно делать вместе со стримами
    }
    class Field{
        // +- понятно что делать если используем SQL, но когда репозиторий работает со структурой Map, что делать, без рефлексии
    }
}
