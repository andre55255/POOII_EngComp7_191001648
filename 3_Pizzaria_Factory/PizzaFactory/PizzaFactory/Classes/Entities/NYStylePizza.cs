namespace PizzaFactory.Classes.Entities
{
    public class NYStyleCheesePizza : BasePizza
    {
        public NYStyleCheesePizza()
        {
            Name = "Molho e queijo estilo NY";
            Dough = "Massa fina";
            Sauce = "Molho marinara";
            Toppings.Add("Parmesão");
            Toppings.Add("Cream cheese");
        }
    }

    public class NYStylePortuguesePizza : BasePizza
    {
        public NYStylePortuguesePizza()
        {
            Name = "Portuguesa estilo NY";
            Dough = "Massa fina";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo Suiço");
            Toppings.Add("Milho");
        }
    }

    public class NYStyleLoinCanadianPizza : BasePizza
    {
        public NYStyleLoinCanadianPizza()
        {
            Name = "Lombo canadense estilo NY";
            Dough = "Massa fina";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo Suiço");
            Toppings.Add("Milho");
        }
    }

    public class NYStyleChickenCatupiry : BasePizza
    {
        public NYStyleChickenCatupiry()
        {
            Name = "Frango com catupiry estilo NY";
            Dough = "Massa fina";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Catupiry");
            Toppings.Add("Tomate");
            Toppings.Add("Alface");
            Toppings.Add("Bacon");
        }
    }
}