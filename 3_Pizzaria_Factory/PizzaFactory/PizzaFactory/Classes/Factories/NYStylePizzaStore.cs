using PizzaFactory.Classes.Entities;

namespace PizzaFactory.Classes.Factories
{
    public class NYStylePizzaStore : BasePizzaStore
    {
        public override BasePizza CreatePizza(string type)
        {
            if (type == "cheese")
            {
                return new NYStyleCheesePizza();
            }
            else if (type == "portuguese")
            {
                return new NYStylePortuguesePizza();
            }
            else if (type == "loinCanadin")
            {
                return new NYStyleLoinCanadianPizza();
            }
            else if (type == "chickenCatupiry")
            {
                return new NYStyleChickenCatupiry();
            }
            return null;
        }
    }
}