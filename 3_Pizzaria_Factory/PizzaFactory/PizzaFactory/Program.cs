using PizzaFactory.Classes.Entities;
using PizzaFactory.Classes.Factories;
using System;

namespace PizzaFactory
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("=====PIZZAS CALIFORNIA=========");
            BasePizzaStore californiaStore = new CaliforniaStylePizzaStore();
            BasePizza california1 = californiaStore.OrderPizza("cheese");
            Console.WriteLine("Você comprou uma pizza: " + california1.Name + "\n");
            BasePizza california2 = californiaStore.OrderPizza("portuguese");
            Console.WriteLine("Você comprou uma pizza: " + california2.Name + "\n");
            BasePizza california3 = californiaStore.OrderPizza("loinCanadin");
            Console.WriteLine("Você comprou uma pizza: " + california3.Name + "\n");
            BasePizza california4 = californiaStore.OrderPizza("chickenCatupiry");
            Console.WriteLine("Você comprou uma pizza: " + california4.Name + "\n");

            Console.WriteLine("=====PIZZAS CHICAGO=========");
            BasePizzaStore chicagoStore = new ChicagoStylePizzaStore();
            BasePizza chicago1 = chicagoStore.OrderPizza("cheese");
            Console.WriteLine("Você comprou uma pizza: " + chicago1.Name + "\n");
            BasePizza chicago2 = chicagoStore.OrderPizza("portuguese");
            Console.WriteLine("Você comprou uma pizza: " + chicago2.Name + "\n");
            BasePizza chicago3 = chicagoStore.OrderPizza("loinCanadin");
            Console.WriteLine("Você comprou uma pizza: " + chicago3.Name + "\n");
            BasePizza chicago4 = chicagoStore.OrderPizza("chickenCatupiry");
            Console.WriteLine("Você comprou uma pizza: " + chicago4.Name + "\n");

            Console.WriteLine("=====PIZZAS LAFAYORK=========");
            BasePizzaStore lafayorkStore = new LafayorkStylePizzaStore();
            BasePizza lafayork1 = lafayorkStore.OrderPizza("cheese");
            Console.WriteLine("Você comprou uma pizza: " + lafayork1.Name + "\n");
            BasePizza lafayork2 = lafayorkStore.OrderPizza("portuguese");
            Console.WriteLine("Você comprou uma pizza: " + lafayork2.Name + "\n");
            BasePizza lafayork3 = lafayorkStore.OrderPizza("loinCanadin");
            Console.WriteLine("Você comprou uma pizza: " + lafayork3.Name + "\n");
            BasePizza lafayork4 = lafayorkStore.OrderPizza("chickenCatupiry");
            Console.WriteLine("Você comprou uma pizza: " + lafayork4.Name + "\n");

            Console.WriteLine("=====PIZZAS NEW YORK=========");
            BasePizzaStore nyStore = new NYStylePizzaStore();
            BasePizza ny1 = nyStore.OrderPizza("cheese");
            Console.WriteLine("Você comprou uma pizza: " + ny1.Name + "\n");
            BasePizza ny2 = nyStore.OrderPizza("portuguese");
            Console.WriteLine("Você comprou uma pizza: " + ny2.Name + "\n");
            BasePizza ny3 = nyStore.OrderPizza("loinCanadin");
            Console.WriteLine("Você comprou uma pizza: " + ny3.Name + "\n");
            BasePizza ny4 = nyStore.OrderPizza("chickenCatupiry");
            Console.WriteLine("Você comprou uma pizza: " + ny4.Name + "\n");

            Console.WriteLine("=====PIZZAS WHITE GOLD=========");
            BasePizzaStore whiteGoldStore = new WhiteGoldStylePizzaStore();
            BasePizza whiteGold1 = whiteGoldStore.OrderPizza("cheese");
            Console.WriteLine("Você comprou uma pizza: " + whiteGold1.Name + "\n");
            BasePizza whiteGold2 = whiteGoldStore.OrderPizza("portuguese");
            Console.WriteLine("Você comprou uma pizza: " + whiteGold2.Name + "\n");
            BasePizza whiteGold3 = whiteGoldStore.OrderPizza("loinCanadin");
            Console.WriteLine("Você comprou uma pizza: " + whiteGold3.Name + "\n");
            BasePizza whiteGold4 = whiteGoldStore.OrderPizza("chickenCatupiry");
            Console.WriteLine("Você comprou uma pizza: " + whiteGold4.Name + "\n");
        }
    }
}
