using PizzaFactory.Classes.Entities;

namespace PizzaFactory.Classes.Factories
{
    public class WhiteGoldStylePizzaStore : BasePizzaStore
    {
        public override BasePizza CreatePizza(string type)
        {
            if (type == "cheese")
            {
                return new WhiteGoldStyleCheesePizza();
            }
            else if (type == "portuguese")
            {
                return new WhiteGoldStylePortuguesePizza();
            }
            else if (type == "loinCanadin")
            {
                return new WhiteGoldStyleLoinCanadianPizza();
            }
            else if (type == "chickenCatupiry")
            {
                return new WhiteGoldStyleChickenCatupiry();
            }
            return null;
        }
    }
}