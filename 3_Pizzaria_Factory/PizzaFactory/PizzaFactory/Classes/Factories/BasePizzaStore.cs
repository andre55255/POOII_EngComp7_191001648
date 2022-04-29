using PizzaFactory.Classes.Entities;

namespace PizzaFactory.Classes.Factories
{
    public abstract class BasePizzaStore
    {
        public abstract BasePizza CreatePizza(string type);

        public BasePizza OrderPizza(string type)
        {
            BasePizza pizza = CreatePizza(type);
            
            pizza.Prepare();
            pizza.Bake();
            pizza.Cut();
            pizza.Box();

            return pizza;
        }
    }
}