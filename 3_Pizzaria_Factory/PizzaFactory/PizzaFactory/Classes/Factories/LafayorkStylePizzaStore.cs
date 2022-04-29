using PizzaFactory.Classes.Entities;

namespace PizzaFactory.Classes.Factories
{
    public class LafayorkStylePizzaStore : BasePizzaStore
    {
        public override BasePizza CreatePizza(string type)
        {
            if (type == "cheese")
            {
                return new LafayorkStyleCheesePizza();
            }
            else if (type == "portuguese")
            {
                return new LafayorkStylePortuguesePizza();
            }
            else if (type == "loinCanadin")
            {
                return new LafayorkStyleLoinCanadianPizza();
            }
            else if (type == "chickenCatupiry")
            {
                return new LafayorkStyleChickenCatupiry();
            }
            return null;
        }
    }
}