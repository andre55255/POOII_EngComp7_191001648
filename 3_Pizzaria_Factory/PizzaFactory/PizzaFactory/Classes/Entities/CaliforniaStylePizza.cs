namespace PizzaFactory.Classes.Entities
{
    public class CaliforniaStyleCheesePizza : BasePizza
    {
        public CaliforniaStyleCheesePizza()
        {
            Name = "Molho e queijo estilo California";
            Dough = "Massa seca";
            Sauce = "Molho de tomate e Molho Shoyu";
            Toppings.Add("Mussarela");
            Toppings.Add("Quejo ralado");
        }
    }

    public class CaliforniaStylePortuguesePizza : BasePizza
    {
        public CaliforniaStylePortuguesePizza()
        {
            Name = "Portuguesa estilo California";
            Dough = "Massa seca";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo Furado");
            Toppings.Add("Milho");
        }
    }

    public class CaliforniaStyleLoinCanadianPizza : BasePizza
    {
        public CaliforniaStyleLoinCanadianPizza()
        {
            Name = "Lombo canadense estilo California";
            Dough = "Massa seca";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Azeitona preta");
            Toppings.Add("Queijo Furado");
            Toppings.Add("Milho");
        }
    }

    public class CaliforniaStyleChickenCatupiry : BasePizza
    {
        public CaliforniaStyleChickenCatupiry()
        {
            Name = "Frango com catupiry estilo California";
            Dough = "Massa seca";
            Sauce = "Molho de tomate com manjericão e orégano";
            Toppings.Add("Catupiry");
            Toppings.Add("Tomate");
            Toppings.Add("Alface");
            Toppings.Add("Bacon");
        }
    }
}