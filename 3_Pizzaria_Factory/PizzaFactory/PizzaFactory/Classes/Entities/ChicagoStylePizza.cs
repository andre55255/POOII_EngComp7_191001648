namespace PizzaFactory.Classes.Entities
{
    public class ChicagoStyleCheesePizza : BasePizza
    {
        public ChicagoStyleCheesePizza()
        {
            Name = "Molho e queijo estilo Chicago";
            Dough = "Massa recheada";
            Sauce = "Molho madeira";
            Toppings.Add("Cheddar picante");
            Toppings.Add("Queijo de Porco");
        }
    }

    public class ChicagoStylePortuguesePizza : BasePizza
    {
        public ChicagoStylePortuguesePizza()
        {
            Name = "Portuguesa estilo Chicago";
            Dough = "Massa recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo Furado");
            Toppings.Add("Milho");
        }
    }

    public class ChicagoStyleLoinCanadianPizza : BasePizza
    {
        public ChicagoStyleLoinCanadianPizza()
        {
            Name = "Lombo canadense estilo Chicago";
            Dough = "Massa recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo Furado");
            Toppings.Add("Milho");
        }
    }

    public class ChicagoStyleChickenCatupiry : BasePizza
    {
        public ChicagoStyleChickenCatupiry()
        {
            Name = "Frango com catupiry estilo Chicago";
            Dough = "Massa recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Catupiry");
            Toppings.Add("Tomate");
            Toppings.Add("Alface");
            Toppings.Add("Bacon");
        }
    }
}