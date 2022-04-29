namespace PizzaFactory.Classes.Entities
{
    public class WhiteGoldStyleCheesePizza : BasePizza
    {
        public WhiteGoldStyleCheesePizza()
        {
            Name = "Molho e queijo estilo WhiteGold";
            Dough = "Massa fina e recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Cheddar");
            Toppings.Add("Queijo ralado");
            Toppings.Add("Queijo prato");
        }
    }

    public class WhiteGoldStylePortuguesePizza : BasePizza
    {
        public WhiteGoldStylePortuguesePizza()
        {
            Name = "Portuguesa estilo WhiteGold";
            Dough = "Massa fina e recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo mussarela");
            Toppings.Add("Milho");
        }
    }

    public class WhiteGoldStyleLoinCanadianPizza : BasePizza
    {
        public WhiteGoldStyleLoinCanadianPizza()
        {
            Name = "Lombo canadense estilo WhiteGold";
            Dough = "Massa fina e recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo mussarela");
            Toppings.Add("Milho");
        }
    }

    public class WhiteGoldStyleChickenCatupiry : BasePizza
    {
        public WhiteGoldStyleChickenCatupiry()
        {
            Name = "Frango com catupiry estilo WhiteGold";
            Dough = "Massa fina e recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Catupiry");
            Toppings.Add("Tomate");
            Toppings.Add("Alface");
            Toppings.Add("Bacon");
        }
    }
}