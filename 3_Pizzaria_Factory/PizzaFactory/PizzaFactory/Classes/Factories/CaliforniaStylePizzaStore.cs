using PizzaFactory.Classes.Entities;

namespace PizzaFactory.Classes.Factories
{
    public class CaliforniaStylePizzaStore : BasePizzaStore
    {
        public override BasePizza CreatePizza(string type)
        {
            if (type == "cheese")
            {
                return new CaliforniaStyleCheesePizza();
            }
            else if (type == "portuguese")
            {
                return new CaliforniaStylePortuguesePizza();
            }
            else if (type == "loinCanadin")
            {
                return new CaliforniaStyleLoinCanadianPizza();
            }
            else if (type == "chickenCatupiry")
            {
                return new CaliforniaStyleChickenCatupiry();
            }
            return null;
        }
    }
}