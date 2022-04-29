using System;
using System.Collections.Generic;

namespace PizzaFactory.Classes.Entities
{
    public abstract class BasePizza
    {
        public string Name { get; set; }
        public string Dough { get; set; }
        public string Sauce { get; set; }
        public List<string> Toppings { get; set; }

        public BasePizza()
        {
            Toppings = new List<string>();
        }

        public void Prepare()
        {
            Console.WriteLine("Preparando: "+Name);
            Console.WriteLine("Preparando massa: "+Dough);
            Console.WriteLine("Adicionando molhos: "+Sauce);
            foreach (string topping in Toppings)
            {
                Console.WriteLine("Adicionando condimento: "+topping);
            }
        }

        public void Bake()
        {
            Console.WriteLine("Assando por 25 minutos a 350 graus");
        }

        public void Cut()
        {
            Console.WriteLine("Cortado a pizza em pedaços diagonais");
        }

        public void Box()
        {
            Console.WriteLine("Colocando a pizza na caixa oficial");
        }
    }
}