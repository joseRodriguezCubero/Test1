package org.joseRodriguez;
    public class Ganga {
        private static Item item = null;
        private static float price = 0;

        public Ganga(Item item, float price) {
            Ganga.item = item;
            Ganga.price = price;
        }

        public static Item getItem() {
            return item;
        }

        public float getPrice() {
            return price;
        }
    }

