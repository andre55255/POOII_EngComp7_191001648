namespace PizzaFactory.Classes.Entities
{
    public class LafayorkStyleCheesePizza : BasePizza
    {
        public LafayorkStyleCheesePizza()
        {
            Name = "Molho e queijo estilo Lafayork";
            Dough = "Massa grossa e recheada";
            Sauce = "Molho de tomate, CreamBerry, Barbecue";
            Toppings.Add("Mussarela");
            Toppings.Add("Cheddar picante");
            Toppings.Add("Parmesão");
            Toppings.Add("Queijo Minas");
        }
    }

    public class LafayorkStylePortuguesePizza : BasePizza
    {
        public LafayorkStylePortuguesePizza()
        {
            Name = "Portuguesa estilo Lafayork";
            Dough = "Massa grossa e recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo mussarela");
            Toppings.Add("Milho");
        }
    }

    public class LafayorkStyleLoinCanadianPizza : BasePizza
    {
        public LafayorkStyleLoinCanadianPizza()
        {
            Name = "Lombo canadense estilo Lafayork";
            Dough = "Massa grossa e recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo mussarela");
            Toppings.Add("Milho");
        }
    }

    public class LafayorkStyleChickenCatupiry : BasePizza
    {
        public LafayorkStyleChickenCatupiry()
        {
            Name = "Frango com catupiry estilo Lafayork";
            Dough = "Massa grossa e recheada";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Catupiry");
            Toppings.Add("Tomate");
            Toppings.Add("Alface");
            Toppings.Add("Bacon");
        }
    }
}