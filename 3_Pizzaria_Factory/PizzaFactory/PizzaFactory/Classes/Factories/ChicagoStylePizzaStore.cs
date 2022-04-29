using PizzaFactory.Classes.Entities;

namespace PizzaFactory.Classes.Factories
{
    public class ChicagoStylePizzaStore : BasePizzaStore
    {
        public override BasePizza CreatePizza(string type)
        {
            if (type == "cheese")
            {
                return new ChicagoStyleCheesePizza();
            }
            else if (type == "portuguese")
            {
                return new ChicagoStylePortuguesePizza();
            }
            else if (type == "loinCanadin")
            {
                return new ChicagoStyleLoinCanadianPizza();
            }
            else if (type == "chickenCatupiry")
            {
                return new ChicagoStyleChickenCatupiry();
            }
            return null;
        }
    }
}